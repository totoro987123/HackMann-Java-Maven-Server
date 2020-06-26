package com.hackmann.packets;

import com.hackmann.player.Player;

public class PlayerLeave implements Event {
    
    private String className;

    public PlayerLeave(String className){
        this.className = className;
    }

    @Override
    public void run(Player player){
        System.out.println("Player: " + player.getConnection().id + " has been disconnected!");
        player.disconnect();
    }
}