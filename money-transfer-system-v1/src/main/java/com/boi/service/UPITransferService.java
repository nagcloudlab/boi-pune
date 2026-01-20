package com.boi.service;

import com.boi.model.Account;
import com.boi.repository.AccountRepository;
import com.boi.repository.AccountRepositoryFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*

    design issues
    ---------------

    -> tight-coupling with b/w dependent & dependency
        UPITransferService  <-----> SQLAccountRepository

        - can't extend with new repository types (NoSQL, In-Memory, Mock etc)
        - can't unit-test UPITransferService in isolation (mocking not possible)


    performance issues
    ----------------------

    -> each transfer() call creates new SQLAccountRepository instance
        leads to resource overhead (DB connections, memory, CPU)

       - user experience degradation
       - increased operational costs


    why these issues happening here?
    ---------------------------------

    -> dependent manages lifecycle of its dependency
        (UPITransferService creates SQLAccountRepository instance directly)


    solution
    ----------------

    -> Don' create dependencies directly within dependent classes.
       use 'Factory'

    limitations of factory pattern here
    --------------------------------------

    -> leads to performance issues (new instance creation on each call)

    best solution
    ----------------------

    -> Don't create & lookup dependencies within dependent classes.
       inject by 'third-party' (DI Container / Framework)

       aka Inversion of Control (IoC)

       how to achieve IoC?
       -------------------------
         -> Dependency Injection (DI)
             - Constructor Injection
             - Setter Injection

      --------------------------------------
      SOLID Principles aka Object design principles
      --------------------------------------
         -> S - Single Responsibility Principle
            - UPITransferService has single responsibility (money transfer logic)
            - AccountRepository creation logic moved to Factory
         -> O - Open/Closed Principle
            - UPITransferService open for extension (can use different repository implementations)
            - closed for modification (no need to change UPITransferService code to add new repository types)
         -> L - Liskov SubstitutionPrinciple
            - AccountRepository interface allows substituting different implementations (SQL, NoSQL, In-Memory)
         -> I - Interface SegregationPrinciple
            - UPITransferService depends only on AccountRepository interface, not on concrete implementations
         -> D - Dependency  InversionPrinciple
            - UPITransferService depends on abstraction (AccountRepository) rather than concrete implementation (SQLAccountRepository)



 */

public class UPITransferService implements TransferService {

    private static Logger logger = LoggerFactory.getLogger("boi");

    private AccountRepository accountRepository;

    // DI via Constructor Injection
    public UPITransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        logger.info("UPITransferService initialized.");
    }

    public void transfer(double amount, String fromUPI, String toUPI) {
        logger.info("Initiating transfer of amount: " + amount + " from " + fromUPI + " to " + toUPI);

        //SQLAccountRepository accountRepository = new SQLAccountRepository(); // Don't create
        //AccountRepository accountRepository = AccountRepositoryFactory.getAccountRepository("SQL"); // Use Factory but lead performance issue
        Account fromAccount = accountRepository.loadAccount(fromUPI);
        Account toAccount = accountRepository.loadAccount(toUPI);

        fromAccount.debit(amount);
        toAccount.credit(amount);

        accountRepository.updateAccount(fromAccount);
        accountRepository.updateAccount(toAccount);

        logger.info("Transfer completed successfully.");

    }

}
