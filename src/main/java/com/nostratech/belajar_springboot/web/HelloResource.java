package com.nostratech.belajar_springboot.web;

import com.nostratech.belajar_springboot.config.ApplicationProperties;
import com.nostratech.belajar_springboot.entity.Author;
import com.nostratech.belajar_springboot.entity.Book;
import com.nostratech.belajar_springboot.service.EmailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/hello")
public class HelloResource {

    private final ApplicationProperties applicationProperties;

    private final EmailService emailService;

    public HelloResource(ApplicationProperties applicationProperties, EmailService emailService) {
        super();
        this.applicationProperties = applicationProperties;
        this.emailService = emailService;
    }


    @GetMapping
    public String hello() {

        Author author1 = emailService.getAuthor();
        System.out.println(author1.getId());
        System.out.println(author1.getName());

        Book book1 = emailService.getBook();
        System.out.println(book1.getTitle());
        System.out.println(book1.getAuthor().getName());


        emailService.sendMail();
        System.out.println("Email sent successfully");


        return "Hello " + applicationProperties.getName() + " " + applicationProperties.getCurrency();
    }
}
