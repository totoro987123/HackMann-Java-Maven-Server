package com.hackmann.packets;

import com.hackmann.server.*;

public class PlayerJoin implements Event {
    
    private String className;

    public PlayerJoin(String className){
        this.className = className;
    }

    @Override
    public void run(Connection connection){
        System.out.println("Connection: " + connection.id + " has connected!");
        ConnectionHandler.connections.put(connection.id, connection);
    }
}