package com.example.songr.controller;

import com.example.songr.Repository.PostRepository;
import com.example.songr.Repository.SongRepository;
import com.example.songr.model.Song;
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
    @Autowired
    private SongRepository songRepository;

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

    @GetMapping("/song")
    public String allSong(Model model) {
        model.addAttribute("song", songRepository.findAll());
        return "song";
    }

//    @GetMapping("albums/{id}")
//    public String getSong(@PathVariable ("id") int id,Model m){
//        m.addAttribute("album",albumRepository.findById(Long.parseLong(id)).orElseThrow();
//        return ("detailedAlbums.html");
//    }
    @GetMapping("/album/{postId}")
    public String findPostByPostId(@PathVariable String postId, Model model) {
        Song album = songRepository.findById(Long.parseLong(postId)).orElseThrow();
        model.addAttribute("song", album);

        return "album";
    }
    @PostMapping("/addsong/{postId}")
    public RedirectView addsong(@RequestParam String title,int length,int trackNumber,@PathVariable ("id") int postId){
        albumModel album=albumRepository.findById(Long.parseLong(String.valueOf(postId))).orElseThrow();
        Song song=new Song(title,length,trackNumber);
        song.setAlbum(album);
        songRepository.save(song);
        return new RedirectView("/albums/{postId}");
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
