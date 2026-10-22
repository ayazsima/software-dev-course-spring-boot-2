package com.example.mycollections.controllers;

import com.example.mycollections.models.Music;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class MusicController {
    private final List<Music> album = new ArrayList<>(List.of(
            new Music("Thriller", 1982, "Michael Jackson", 9),
            new Music("21", 2011, "Adele", 11),
            new Music("Back to Black", 2006, "Amy Winehouse", 11),
            new Music("Abbey Road", 1969, "The Beatles", 17)
    ));
    @GetMapping("/json")
    public List<Music> getAlbumJson(){
        return album;
    }

    @GetMapping("/html")
    public String getAlbumHtml(){
        String albumList = "";
        for (Music music : album) {
            albumList += "<li>" + music + "</li>";
        }

        return """
                <html>
                <body>
                <h1>Album</h1>
                <ul>
               """
                +albumList+

                """
                </ul>
                </body>
                <html>
                """;
    }
}
