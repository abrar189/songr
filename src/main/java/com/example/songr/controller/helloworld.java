package com.example.songr.controller;

import com.example.songr.Repository.AlbumRepository;
import com.example.songr.Repository.SongRepository;
import com.example.songr.model.Album;
import com.example.songr.model.Song;
import com.example.songr.model.SongDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class helloworld {

    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private SongRepository songRepository;


    @PostMapping("/albums")
    public RedirectView createNewalbum(@ModelAttribute Album album) {
        albumRepository.save(album);
        return new RedirectView("/albums");
    }

    @GetMapping("/albums")
    public String getAlbums(Model model) {

        model.addAttribute("Albums", albumRepository.findAll());
        return "album";
    }

    @GetMapping("/songs")
    public String allSong(Model model) {
        model.addAttribute("songs", songRepository.findAll());
        return "allsongs";
    }

    @Transactional
    @GetMapping("/albuminfo/{id}")
    public String showAblumInfo(@PathVariable Long id, Model model) {
        System.out.println(id);
        Album album = albumRepository.findById(id).orElseThrow();
        List<Song> songsList = album.getSong();
        model.addAttribute("Album", album);
        model.addAttribute("Songs", songsList);
        return "albuminfo.html";
    }

    @GetMapping("/addsong")
    public String addsongpage() {
        return "addSong";
    }


    @PostMapping("/addsong")
    public RedirectView addsong(@ModelAttribute SongDTO songDto) {
        String albumTitle = songDto.getAlbumTitle();
        Album songAlbum = albumRepository.findByTitle(albumTitle);

        Song song = new Song(songDto.getTitle(), songDto.getLength(), songDto.getTrackNumber());
        song.setAlbum(songAlbum);

        songRepository.save(song);

        return new RedirectView("/songs");
    }

//    @GetMapping("addsong/{id}")
//    public String getSong(@PathVariable("id") String id, Model model) {
//        model.addAttribute("Album", albumRepository.findById(Long.parseLong(id)).orElseThrow());
//        return ("addsongbyid");
//    }

//    @PostMapping("/addsong/{albumId}")
//    public RedirectView addsong(@PathVariable String albumId, @ModelAttribute Song song) {
//
//        Album songAlbum = albumRepository.findById(Long.parseLong(albumId)).orElseThrow();
//
//        Song song1 = new Song(song.getTitle(), song.getLength(), song.getTrackNumber());
//        song.setAlbum(songAlbum);
//
//        songRepository.save(song1);
//
//        return new RedirectView("/songs");
//    }

//    @PostMapping("/addsong/{albumId}")
//    public RedirectView addsong(@RequestParam String title,int length,int trackNumber,@PathVariable ("id") int postId){
//
//        return new RedirectView("/albums/{postId}");
//    }

//    @GetMapping("albums/{id}")
//    public String getSong(@PathVariable ("id") int id,Model m){
//        m.addAttribute("album",albumRepository.findById(Long.parseLong(id)).orElseThrow();
//        return ("detailedAlbums.html");
//    }
//    @GetMapping("/album/{postId}")
//    public String findalbumByPostId(@PathVariable String postId, Model model) {
//        Song album = songRepository.findById(Long.parseLong(postId)).orElseThrow();
//        model.addAttribute("song", album);
//
//        return "album";
//    }
//


    @GetMapping("/hello")
    public String helloWorld(@RequestParam(name = "name", required = false, defaultValue = "world") String name,
                             Model model) {
        model.addAttribute("name", name);
        return "helloWorld";
    }

    @GetMapping("/capitalize/{text}")
    public String setCapitalize(Model model, @PathVariable String text) {
        String capitalizeText = text.toUpperCase();
        model.addAttribute("Text", capitalizeText);
        return "capitalize";
    }


}
