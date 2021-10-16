package com.example.songr.controller;

import com.example.songr.Repository.AlbumRepository;
import com.example.songr.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class album {

    @Autowired
    AlbumRepository albumRepository;

//    @GetMapping("/album")
//    public String Album(Model model) {
//
////        Album album1 = new Album("Sahran" , "Amer Deab" ,12, 2880 , "https://1.bp.blogspot.com/-rfB8UeZc8ms/Xx2Of7yqLWI/AAAAAAAADd4/5Qmhv2z5UGEiEEwQeNVHadWzZfyTDkuygCNcBGAsYHQ/w625-h335/fgfdgfd.jpg" );
////        Album album2 = new Album("Sevme" , "Bilal sonses" ,10, 2500 , "https://i.ytimg.com/vi/Zh-52CVVAv4/maxresdefault.jpg" );
////        Album album3 = new Album("Halet Hob" , "Elisa" ,13, 2950 , "https://s1.dmcdn.net/v/7QF-Y1Vj32mDFtNgP/x1080" );
//////        List<Album> Albums = new ArrayList<>();
//////        Albums.add(album1);
//////        Albums.add(album2);
//////        Albums.add(album3);
////        albumRepository.save(album1);
////        albumRepository.save(album2);
////        albumRepository.save(album3);
//        List<Album> Albums = albumRepository.findAll();
//        model.addAttribute("Albums" , Albums);
//        return "album";
//    }
}
