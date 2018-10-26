package com.telecom.bff.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Controller
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${eApi.url.customers}")
    private String eApiCustomerUrl;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<String> getAllCustomers() {
        ResponseEntity<String> response = restTemplate.getForEntity(eApiCustomerUrl, String.class);
        log.info("Output from E-API:" + response);
        return response;
    }

    @RequestMapping(value = "/customers/{lastName}", method = RequestMethod.GET)
    public ResponseEntity<String> getCustomerByLastName(@PathVariable String lastName) {
        ResponseEntity<String> response = restTemplate.getForEntity(eApiCustomerUrl+"/"+lastName , String.class);
        log.info("Output from E-API:" + response.getBody());
        return response;
    }
}