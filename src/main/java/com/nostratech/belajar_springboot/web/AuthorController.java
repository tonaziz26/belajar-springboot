package com.nostratech.belajar_springboot.web;

import com.nostratech.belajar_springboot.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
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
        model.addAttribute("authorDTO", new AuthorDTO("",""));
        return "author-new";
    }

    // hit submit
    @PostMapping("submit")
    public String submit(@ModelAttribute AuthorDTO authorDTO, RedirectAttributes redirectAttributes) {
        authorService.createAuthor(authorDTO);
        redirectAttributes.addFlashAttribute("authorDTO", authorDTO);
        return "redirect:/authors/result-list"; // ke api nya
    }

    // hasil submit
    @GetMapping("result-list")
    public String result(Model model) {
        List<AuthorDTO> authorDTOList = authorService.getAuthors();
        model.addAttribute("authorDTOList", authorDTOList);
        return "author-result-list";
    }

    //getDetail
    @GetMapping("{name}")
    public String getAuthorByName(@PathVariable String name, Model model) {
        AuthorDTO authorDTO = authorService.findByName(name);
        if (authorDTO == null) {
            return "redirect:/authors/result-list";
        }
        model.addAttribute("authorDTO", authorDTO);
        return "author-result";
    }
}
