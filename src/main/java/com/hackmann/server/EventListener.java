package com.hackmann.server;
import com.hackmann.packets.*;
import com.hackmann.player.*;

public class EventListener {
	
	public void received(Event p, Connection connection) {
        Player player = new Player(connection);

        p.run(player);

	}
}
