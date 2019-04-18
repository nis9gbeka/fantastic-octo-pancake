package com.abcd.lol.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@RequestMapping("/")
public class MainController {
    @RequestMapping
    public String greeting(Map<String, Object> model){
        return "greeting";
    }
}
