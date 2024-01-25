package com.coderpwh.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author coderpwh
 */
@RestController
@CrossOrigin
public class HelloWorldController {


    @RequestMapping({"/hello"})
    public String hello() {
        return "Hello World";
    }
}
