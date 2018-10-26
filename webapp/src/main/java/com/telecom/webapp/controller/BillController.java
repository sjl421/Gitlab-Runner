package com.telecom.webapp.controller;

import com.telecom.webapp.Service.BillService;
import com.telecom.webapp.model.Input;
import com.telecom.webapp.model.bill.Bill;

import com.telecom.webapp.model.bill.Content;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BillController {

    private static final Logger log = LoggerFactory.getLogger(BillController.class);

    @Autowired
    private BillService billService;


    @RequestMapping(value = "/billList", method = RequestMethod.POST)
    public String getBillByCustomerId(@Valid @ModelAttribute("input")Input input, BindingResult result, ModelMap model) {
        log.info("bla");
        if (result.hasErrors()) {
            return "error";
        }
        List<Content> bills =  billService.getBillByCustomerId(Long.valueOf(input.getId()));
        model.addAttribute("bills", bills);
        return "billView";
    }
}
