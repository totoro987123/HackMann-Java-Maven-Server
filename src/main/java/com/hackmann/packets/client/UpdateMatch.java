package com.hackmann.packets.client;


import com.hackmann.packets.Event;
import com.hackmann.player.Player;

public class UpdateMatch implements Event {

    private String className = "UpdateMatch";

    public int yourScore;
    public int otherPlayerScore;

    public UpdateMatch(){}

    @Override
    public void run(Player player) {}
}