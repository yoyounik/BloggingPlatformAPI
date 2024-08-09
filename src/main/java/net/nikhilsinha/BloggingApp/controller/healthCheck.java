package net.nikhilsinha.BloggingApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthCheck {
    @GetMapping("/hello")
    public String healthCheck() {
        return "Hello Bloggers";
    }
}
