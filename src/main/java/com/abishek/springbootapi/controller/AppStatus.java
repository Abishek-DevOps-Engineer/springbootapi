package com.abishek.springbootapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppStatus {

    @GetMapping("/appStatus")
    public String getAppStstus(){
        return "Application running Successfully updated";
    }
}
