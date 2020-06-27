package com.hackmann.packets.server;

import com.hackmann.player.Player;
import com.hackmann.packets.Event;


public class UpdateScore implements Event {
    
    private String className;
    private int amount;

    public UpdateScore(String className, int amount) {
        this.className = className;
        this.amount = amount;
    }

    @Override
    public void run(Player player){
        player.changeScore(this.amount);
    }
}