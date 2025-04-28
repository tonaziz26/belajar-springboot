package com.nostratech.belajar_springboot.service;

import com.nostratech.belajar_springboot.entity.Author;
import com.nostratech.belajar_springboot.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author createAuthor(Author author) {

        authorRepository.save(author);
        return author;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author findByName(String name) {
        return authorRepository.findOneByName(name).orElse(null);
    }

    public List<Author> findByNameNative(String name) {

        name = "%" + name + "%";
        return authorRepository.findByNameLikeQueryNative(name);
    }
}
