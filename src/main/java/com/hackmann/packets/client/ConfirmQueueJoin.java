package com.hackmann.packets.client;

import com.hackmann.packets.Event;
import com.hackmann.player.Player;

public class ConfirmQueueJoin implements Event {

    private String className = "ConfirmQueueJoin";

    public ConfirmQueueJoin(){}

    @Override
    public void run(Player player) {}
    
}