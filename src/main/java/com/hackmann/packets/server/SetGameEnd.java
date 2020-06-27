package com.hackmann.packets.server;

import com.hackmann.packets.Event;
import com.hackmann.player.Player;

public class SetGameEnd implements Event {
    
    private String className;

    public SetGameEnd(String className) {
        this.className = className;
    }

    @Override
    public void run(Player player){
        player.setGameEnd(true);
    }
}