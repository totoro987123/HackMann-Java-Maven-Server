package com.hackmann.server;
import com.hackmann.packets.*;

public class EventListener {
	
	public void received(Event p,Connection connection) {

        p.run(connection);
        
	}
}
