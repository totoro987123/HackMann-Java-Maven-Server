package com.hackmann.packets.client;

import com.hackmann.packets.Event;
import com.hackmann.player.Player;

public class ConfirmUsernameChange implements Event {

    private String className = "ConfirmUsernameChange";

    public ConfirmUsernameChange(){}

    @Override
    public void run(Player player) {}
    
}