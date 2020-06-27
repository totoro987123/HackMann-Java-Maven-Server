package com.hackmann.packets.client;

import com.hackmann.packets.Event;
import com.hackmann.player.Player;

public class StartMatch implements Event {

    private String className = "StartMatch";

    public StartMatch(){}

    @Override
    public void run(Player player) {}
    
}