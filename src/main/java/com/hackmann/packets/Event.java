package com.hackmann.packets;

import com.hackmann.player.*;

public abstract interface Event {

    public abstract void run(Player player);
}