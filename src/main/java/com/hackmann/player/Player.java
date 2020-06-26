package com.hackmann.player;

import com.hackmann.server.*;

public class Player {

    private int score = 0;
    private String username = "";
    private Connection connection = null; //server id and socket

    public Player(Connection connection) { //when a new player enters
        this.connection = connection;
    }

    public void changeScore(int amount) {
        this.score += score;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String name){
        this.username = name;
    }

    public int getScore() {
        return this.score;
    }
    public void disconnect() {
        this.connection.close();
    }
}
