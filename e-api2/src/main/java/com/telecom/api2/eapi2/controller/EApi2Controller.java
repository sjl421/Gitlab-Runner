package com.telecom.api2.eapi2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EApi2Controller {

    @RequestMapping("/")
    public String index() {
        return "Greetings from EApi-2";
    }

}