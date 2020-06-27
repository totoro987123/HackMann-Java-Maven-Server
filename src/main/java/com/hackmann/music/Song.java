package com.hackmann.music;

public class Song {

    private String name;
    private int scorablePoints;

    public Song(String name, int scorablePoints){
        this.name = name;
        this.scorablePoints = scorablePoints;
    }

    public String getName(){
        return this.name;
    }

    public int getScorablePoints(){
        return this.scorablePoints;
    }
}
