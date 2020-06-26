package com.hackmann.server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.hackmann.packets.Event;

public class Connection implements Runnable{
	
	private Socket socket;
	private BufferedInputStream in;
	private ObjectOutputStream out;
	private Serializer serializer;
	
	public int id;
	private EventListener listener;
	private boolean running = false;
	private int headerSize = 10;
	
	public Connection(Socket socket, int id) {
		this.socket = socket;
		this.id = id;

		System.out.println(this.id);
		
		try {
			this.out = new ObjectOutputStream(socket.getOutputStream());
			this.in = new BufferedInputStream(socket.getInputStream());
			this.listener = new EventListener();
			this.serializer = new Serializer(this.headerSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
            running = true;
            			
			while(running) {
				byte[] header = new byte[this.headerSize];
				this.in.read(header);

				if (header == new byte[this.headerSize]) {
					continue;
				}

				int length = this.serializer.getLength(header);

				byte[] data = new byte[length];
				this.in.read(data);

				Event event = this.serializer.jsonToEvent(this.serializer.bytesToText(data));
					
				listener.received(event, this);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			running = false;
			in.close();
			out.close();
			socket.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendObject(Object packet) {
		try {
			out.writeObject(packet);
			out.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
