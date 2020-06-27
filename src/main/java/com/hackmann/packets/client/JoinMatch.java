package com.hackmann.packets.client;

import com.hackmann.packets.Event;
import com.hackmann.player.Player;

public class JoinMatch implements Event {

    private String className = "ConfirmUsernameChange";

    public String otherPlayerName;
    public String songName;
    public long maxPoints;

    public JoinMatch(){}

    @Override
    public void run(Player player) {}
}