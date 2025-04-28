package com.nostratech.belajar_springboot.web;

import com.nostratech.belajar_springboot.entity.Author;
import com.nostratech.belajar_springboot.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {


    @Autowired
    AuthorService authorService;

    // tampilan awal
    @GetMapping("new")
    public String createForm(Model model) {
        Author author = new Author();
        author.setName("");
        author.setDescription("");
        model.addAttribute("authorDTO", author);
        return "author-new";
    }

    // hit submit
    @PostMapping("submit")
    public String submit(@ModelAttribute Author author, RedirectAttributes redirectAttributes) {
        authorService.createAuthor(author);
        redirectAttributes.addFlashAttribute("authorDTO", author);
        return "redirect:/authors/result-list"; // ke api nya
    }

    // hasil submit
    @GetMapping("result-list")
    public String result(Model model) {
        List<Author> authors = authorService.getAuthors();
        model.addAttribute("authorDTOList", authors);
        return "author-result-list";
    }

    //getDetail
    @GetMapping("{name}")
    public String getAuthorByName(@PathVariable String name, Model model) {
        Author author = authorService.findByName(name);
        if (author == null) {
            return "redirect:/authors/result-list";
        }
        model.addAttribute("authorDTO", author);
        return "author-result";
    }

    @GetMapping("list/{name}")
    public ResponseEntity<List<Author>> getAuthorByNameApi(@PathVariable("name") String name) {
        return ResponseEntity.ok(authorService.findByNameNative(name));
    }
}
