package com.boi.service;

import com.boi.model.Account;
import com.boi.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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

@Component("upiTransferService")
public class UPITransferService implements TransferService {

    private static Logger logger = LoggerFactory.getLogger("boi");

    private AccountRepository accountRepository;

    // DI via Constructor Injection
    @Autowired
    public UPITransferService(@Qualifier("sqlAccountRepository") AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        logger.info("UPITransferService initialized.");
    }

    @Transactional(
            isolation = Isolation.REPEATABLE_READ,
            rollbackFor = RuntimeException.class
    )
    public void transfer(double amount, String fromUPI, String toUPI) {
        logger.info("Initiating transfer of amount: " + amount + " from " + fromUPI + " to " + toUPI);

        Account fromAccount = accountRepository.findById(Integer.parseInt(fromUPI))
                .orElseThrow(()-> new RuntimeException("Source account not found: " + fromUPI));
        Account toAccount = accountRepository.findById(Integer.parseInt(toUPI))
                .orElseThrow(()-> new RuntimeException("Destination account not found: " + toUPI));

        fromAccount.debit(amount);
        toAccount.credit(amount);

        accountRepository.save(fromAccount);
        if(false){
            throw new RuntimeException("Simulawted failure during transfer process.");
        }
        accountRepository.save(toAccount);

        logger.info("Transfer completed successfully.");

    }

}
