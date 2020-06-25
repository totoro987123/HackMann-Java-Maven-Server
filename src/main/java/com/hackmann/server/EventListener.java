package com.hackmann.server;

import org.json.*;

public class EventListener {
	
	public void received(Object p,Connection connection) {

		JSONObject object = new JSONObject((String) p);

        String todo = object.getString("todo");

        if (todo.equals("Add Connection")){
            System.out.println("Connection: " + connection.id + " has connected!");
            ConnectionHandler.connections.put(connection.id, connection);
        } else if (todo.equals("Remove Connection")){
            System.out.println("Connection: " + connection.id + " has been disconnected!");
            ConnectionHandler.connections.get(connection.id).close();
            ConnectionHandler.connections.remove(connection.id);
        } else {
            System.out.println("Not a valid order!");
        }
	}
}
