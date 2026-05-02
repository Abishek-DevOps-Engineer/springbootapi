package com.abishek.springbootapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/howdy")
    public String howdy(){
        return "How you doin? ";
    }


    @GetMapping("/message2")
    public String message2(){
        return "could i be any more dumb? ";
    }
}
