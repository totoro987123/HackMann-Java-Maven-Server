package com.hackmann.packets;

import com.hackmann.player.Player;

public class PlayerJoin implements Event {
    
    private String className;

    public PlayerJoin(String className){
        this.className = className;
    }

    @Override
    public void run(Player player){
        System.out.println("Player: " + player.getConnection().id + " has connected!");
    }
}