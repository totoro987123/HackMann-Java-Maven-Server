package com.hackmann.packets;

import com.hackmann.server.*;

public class PlayerLeave implements Event {
    
    private String className;

    public PlayerLeave(String className){
        this.className = className;
    }

    @Override
    public void run(Connection connection){
        System.out.println("Connection: " + connection.id + " has been disconnected!");
        ConnectionHandler.connections.get(connection.id).close();
        ConnectionHandler.connections.remove(connection.id);
    }
}