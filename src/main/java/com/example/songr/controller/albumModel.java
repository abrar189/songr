package com.example.songr.controller;

import com.example.songr.model.albumModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
class Album {

    @GetMapping("/album")
    public String Album(Model model) {

        albumModel album1 = new albumModel("Sahran" , "Amer Deab" ,12, 2880 , "https://1.bp.blogspot.com/-rfB8UeZc8ms/Xx2Of7yqLWI/AAAAAAAADd4/5Qmhv2z5UGEiEEwQeNVHadWzZfyTDkuygCNcBGAsYHQ/w625-h335/fgfdgfd.jpg" );
        albumModel album2 = new albumModel("Sevme" , "Bilal sonses" ,10, 2500 , "https://i.ytimg.com/vi/Zh-52CVVAv4/maxresdefault.jpg" );
        albumModel album3 = new albumModel("Halet Hob" , "Elisa" ,13, 2950 , "https://s1.dmcdn.net/v/7QF-Y1Vj32mDFtNgP/x1080" );
        List<albumModel> Albums = new ArrayList<>();
        Albums.add(album1);
        Albums.add(album2);
        Albums.add(album3);
        model.addAttribute("Album" , Albums);
        return "album";
    }
}
