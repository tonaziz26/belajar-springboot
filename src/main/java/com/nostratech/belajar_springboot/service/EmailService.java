package com.nostratech.belajar_springboot.service;

import com.nostratech.belajar_springboot.entity.Author;
import com.nostratech.belajar_springboot.entity.Book;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;


import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMultipart;

@Service
public class EmailService {


    private final Book book1;
    private final Author author1;

    private final Session session;


    public EmailService( Book book1, Author author1, Session session) {
        this.book1 = book1;
        this.author1 = author1;
        this.session = session;
    }

    public Book getBook() {
        return book1;
    }

    public Author getAuthor() {
        return author1;
    }

    public void sendMail() {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("to@gmail.com"));
            message.setSubject("Mail Subject");

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent("This is my first email using JavaMailer", "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}