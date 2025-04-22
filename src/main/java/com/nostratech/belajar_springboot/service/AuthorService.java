package com.nostratech.belajar_springboot.service;

import com.nostratech.belajar_springboot.web.AuthorDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    List<AuthorDTO> authors = new ArrayList<>();

    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        authors.add(authorDTO);
        return authorDTO;
    }

    public List<AuthorDTO> getAuthors() {
        return authors;
    }

    public AuthorDTO findByName(String name) {
        return authors.stream()
                .filter(author -> author.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
