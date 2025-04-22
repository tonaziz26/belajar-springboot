package com.nostratech.belajar_springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String home(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }
}
