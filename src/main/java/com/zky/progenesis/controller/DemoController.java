package com.zky.progenesis.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DemoController {
    // Create a mapping for "/hello"
    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("theDate", LocalDateTime.now());
        return "helloworld";
    }
    
}
