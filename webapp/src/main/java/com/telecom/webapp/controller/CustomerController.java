package com.telecom.webapp.controller;

import com.telecom.webapp.Service.CustomerService;
import com.telecom.webapp.model.customer.Content;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = {"/customerList"}, method = RequestMethod.GET)
    public String personList(Model model) {
        List<Content> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customerView";
    }
}
