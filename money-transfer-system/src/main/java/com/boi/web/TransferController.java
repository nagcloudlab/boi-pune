package com.boi.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/transfer")
public class TransferController {

    @GetMapping
    public ModelAndView showTransferPage() {
        // authrization logic to be implemented
        ModelAndView mav=new ModelAndView();
        mav.setViewName("transfer-form.html");
        return mav;
    }

}
