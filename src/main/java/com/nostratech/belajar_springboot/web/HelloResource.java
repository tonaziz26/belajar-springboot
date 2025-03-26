package com.nostratech.belajar_springboot.web;

import com.nostratech.belajar_springboot.entity.Author;
import com.nostratech.belajar_springboot.entity.Book;
import com.nostratech.belajar_springboot.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/hello")
public class HelloResource {

    @Value("${test.name}")
    private String name;

    private final EmailService emailService;

    public HelloResource(EmailService emailService) {
        this.emailService = emailService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String hello() {

        Author author1 = emailService.getAuthor();
        System.out.println(author1.getId());
        System.out.println(author1.getName());

        Book book1 = emailService.getBook();
        System.out.println(book1.getTitle());
        System.out.println(book1.getAuthor().getName());


        emailService.sendMail();
        System.out.println("Email sent successfully");


        return "hello "+ name;
    }
}
