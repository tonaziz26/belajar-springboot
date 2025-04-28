package com.nostratech.belajar_springboot;

import com.nostratech.belajar_springboot.entity.Author;
import com.nostratech.belajar_springboot.repository.AuthorRepository;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AuthorRepositoryTest {

    @Inject
    AuthorRepository authorRepository;

    @Test
    public void test() {
//        Author author = new Author();
//        author.setName("Faisal");
//        author.setDescription("Belajar Spring Boot");
//        authorRepository.save(author);

        List<Author> authors = authorRepository.findByName("Faisal");
        assertEquals(1, authors.size());
    }
}
