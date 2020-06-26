package com.hackmann.packets;

import com.hackmann.server.*;

public abstract interface Event {

    public abstract void run(Connection connection);
}