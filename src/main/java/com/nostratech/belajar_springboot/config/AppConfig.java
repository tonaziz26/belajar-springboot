package com.nostratech.belajar_springboot.config;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import java.util.Properties;

import com.nostratech.belajar_springboot.entity.Author;
import com.nostratech.belajar_springboot.entity.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Author author1() {
        Author author = new Author();
        author.setId(1L);
        author.setName("Faisal");
        return author;
    }

    @Bean
    public Author author2() {
        Author author = new Author();
        author.setId(2L);
        author.setName("Albana");
        return author;
    }

    @Bean
    public Book book1(@Qualifier("author2") Author author1) {
        return new Book("Java Book", author1);
    }

    @Bean
    public Properties mailProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "sandbox.smtp.mailtrap.io");
        return props;
    }

    @Bean
    public PasswordAuthentication passwordAuthentication() {
        return new PasswordAuthentication("8115d618f7b411", "55caa73c24f75e");
    }

    @Bean
    public Session mailSession(Properties mailProperties, PasswordAuthentication passwordAuthentication) {
        return Session.getInstance(mailProperties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return passwordAuthentication;
            }
        });
    }
}