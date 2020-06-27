package com.hackmann.packets.server;

import com.hackmann.player.Player;
import com.hackmann.packets.Event;


public class SetName implements Event {
    
    private String className;
    private String newName;

    public SetName(String className, String newName) {
        this.className = className;
    }

    @Override
    public void run(Player player){
        player.setUsername(this.newName);
    }
}