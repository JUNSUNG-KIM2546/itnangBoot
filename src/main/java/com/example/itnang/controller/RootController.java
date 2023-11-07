package com.example.itnang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class RootController {

    final String home = "home/";

    @GetMapping
    public String root() {
        return home + "index.html";
    }

    @GetMapping("/hello")
    public String hello() {
        return home + "hello.html";
    }

}
