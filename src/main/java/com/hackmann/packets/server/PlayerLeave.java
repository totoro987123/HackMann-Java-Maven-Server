package com.hackmann.packets.server;

import com.hackmann.player.Player;
import com.hackmann.packets.Event;


public class PlayerLeave implements Event {
    
    private String className;

    public PlayerLeave(String className){
        this.className = className;
    }

    @Override
    public void run(Player player){
        player.disconnect();
    }
}