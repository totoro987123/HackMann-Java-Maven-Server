package com.hackmann.packets.server;

import com.hackmann.player.Player;
import com.hackmann.packets.Event;


public class PlayerJoin implements Event {
    
    private String className;

    public PlayerJoin(String className){
        this.className = className;
    }

    @Override
    public void run(Player player){
        System.out.println("\n" + player.getUsername() + " has connected to the server!\n");
    }
}