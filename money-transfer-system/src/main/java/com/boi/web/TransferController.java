package com.boi.web;

import com.boi.dto.TransferResponse;
import com.boi.service.TransferServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    TransferServiceImpl transferService;

    @GetMapping
    public ModelAndView showTransferPage() {
        // authrization logic to be implemented
        ModelAndView mav = new ModelAndView();
        mav.setViewName("transfer-form");
        return mav;
    }

    @PostMapping
    public ModelAndView handleTransfer(
            @RequestParam("fromAccountId") String fromAccountId,
            @RequestParam("toAccountId") String toAccountId,
            @RequestParam("amount") double amount
    ) {
        // validation and
        // transfer handling logic to be implemented
        System.out.println("Transferring " + amount + " from account " + fromAccountId + " to account " + toAccountId);
        transferService.transfer(fromAccountId, toAccountId, amount);
        TransferResponse txrResponseModel=new TransferResponse(121212, "SUCCESS", "Transfer completed successfully");
        ModelAndView mav = new ModelAndView();
        mav.addObject("response", txrResponseModel);
        mav.setViewName("transfer-success");
        return mav;
    }

}
