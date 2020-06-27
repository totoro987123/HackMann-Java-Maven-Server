package com.hackmann.music;

import java.util.Random;

public class SongHandler {

    private static Song[] songs = {
        new Song("Natural", 13280),
        new Song("Havana", 16571)
    };

    private static Random selector = new Random();

    public static Song pickRandomSong(){
        return songs[selector.nextInt(songs.length)];
    }
}