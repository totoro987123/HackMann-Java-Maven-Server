package com.hackmann.packets.client;

import com.hackmann.packets.Event;
import com.hackmann.player.Player;

public class EndMatch implements Event {

    private String className = "EndMatch";

    public String winnerName;

    public EndMatch(){}

    @Override
    public void run(Player player) {}
}