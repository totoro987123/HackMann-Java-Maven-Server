package com.hackmann.music;

import java.util.Random;

public class SongHandler {

    private static Song[] songs = {
        new Song("Natural", 13280),
        new Song("Havana", 16571),
        new Song("Hey There Delilah", 18336),
        new Song("Without Me", 15322),
        new Song("Hey, Soul Sister", 17692),
        new Song("7 Years",14839)
    };
    /*private static Song[] songs = {
        new Song("Unsteady", 7432)
    };*/
    private static Random selector = new Random();

    public static Song pickRandomSong(){
        return songs[selector.nextInt(songs.length)];
    }
}
