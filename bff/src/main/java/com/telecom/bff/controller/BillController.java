package com.telecom.bff.controller;

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
public class BillController {

    private static final Logger log = LoggerFactory.getLogger(BillController.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${eApi.url.bills}")
    private String eApiBillUrl;

    @RequestMapping(value = "/bills/{customerId}",  method = RequestMethod.GET)
    public ResponseEntity<String> getBillByCustomerId(@PathVariable Long customerId) {
        ResponseEntity<String> response = restTemplate.getForEntity(eApiBillUrl+customerId , String.class);
        log.info("Output from E-API:" + response.getBody());
        return response;
    }
}
