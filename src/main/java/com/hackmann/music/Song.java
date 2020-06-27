package com.hackmann.music;

public class Song {
    
    private String name;
    private long scorablePoints;

    public Song(String name, long scorablePoints){
        this.name = name;
        this.scorablePoints = scorablePoints;
    }

    public String getName(){
        return this.name;
    }

    public long getScorablePoints(){
        return this.scorablePoints;
    }
}