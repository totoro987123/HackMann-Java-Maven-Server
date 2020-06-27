package com.hackmann.packets.server;

import com.hackmann.packets.Event;
import com.hackmann.player.Player;

public class JoinQueue implements Event {
    
    private String className;

    public JoinQueue(String className) {
        this.className = className;
    }

    @Override
    public void run(Player player){
        player.joinGame();
    }
}