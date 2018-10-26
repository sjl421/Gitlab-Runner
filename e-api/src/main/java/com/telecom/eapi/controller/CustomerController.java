package com.telecom.eapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${sap.url.customers}")
    private String sapCustomerUrl;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<String> getAllCustomers() {
        ResponseEntity<String> response = restTemplate.getForEntity(sapCustomerUrl, String.class);
        log.info("Output from SAP:" + response.getBody());
        return response;
    }

    @RequestMapping(value = "/customers/{lastName}",  method = RequestMethod.GET)
    public ResponseEntity<String> getCustomerByLastName(@PathVariable String lastName) {
        ResponseEntity<String> response = restTemplate.getForEntity(sapCustomerUrl+"search/findByLastName?lastName="+lastName , String.class);
        log.info("Output from SAP:" + response.getBody());
        return response;
    }
}
