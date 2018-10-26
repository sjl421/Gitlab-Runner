package com.telecom.eapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class EApi2Controller {

    private static final Logger log = LoggerFactory.getLogger(EApi2Controller.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${eApi2.Url}")
    private String eApi2Url;

    @RequestMapping(value = "/eapi2/", method = RequestMethod.GET)
    public ResponseEntity<String> getEApi2() {
        ResponseEntity<String> response = restTemplate.getForEntity(eApi2Url, String.class);
        log.info("Output from EApi-2:" + response.getBody());
        return response;
    }
}
