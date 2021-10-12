package com.example.songr.controller;

import com.example.songr.Repository.PostRepository;
import com.example.songr.model.albumModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class helloworld {

    @Autowired
    private PostRepository albumRepository;

    @ResponseBody
    @PostMapping("/albums")
    public RedirectView createNewalbum(@ModelAttribute albumModel album,Model model) {
        model.addAttribute("album",album);
        albumRepository.save(album);
        return new RedirectView("albums");
    }
    @GetMapping("/albums")
    public String getAlbums(Model model) {
        model.addAttribute("albums", albumRepository.findAll());
        return "album";
    }

    @GetMapping("/hello")
    public String helloWorld(@RequestParam(name = "name", required = false, defaultValue = "world") String name,
                            Model model) {
        model.addAttribute("name", name);
        return "helloWorld";
    }

    @GetMapping("/capitalize/{text}")
    public String setCapitalize(Model model, @PathVariable String text) {
        String capitalizeText = text.toUpperCase();
        model.addAttribute("Text" , capitalizeText);
        return "capitalize";
    }



}
