package com.hackmann.server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import com.hackmann.packets.Event;
import com.hackmann.player.*;

public class Connection implements Runnable{

	private Socket socket;
	private BufferedInputStream in;
	private OutputStream out;
	private Serializer serializer;

	public int id;
	private EventListener listener;
	private boolean running = false;
	private int headerSize = 10;

	public Connection(Socket socket, int id) {
		this.socket = socket;
		this.id = id;

		try {
			this.out = socket.getOutputStream();
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

				Event event = this.serializer.bytesToEvent(data);

				listener.received(event, this);
			}
		}catch(IOException e) {
			e.printStackTrace();
			PlayerHandler.getPlayer(this).disconnect();
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

	public void send(Event event) {
		byte[] data = this.serializer.eventToBytes(event);
		int length = data.length;

		String header = Integer.toString(length);
        for (int i = header.length(); i < this.headerSize; i++){
            header = header + "-";
		}

		byte[] bytesHeader = header.getBytes();

		byte[] finalData = new byte[bytesHeader.length + data.length];
		for (int i = 0; i < bytesHeader.length; i++){
			finalData[i] = bytesHeader[i];
		}
		for (int i = 10; i < finalData.length; i++){
			finalData[i] = data[i-10];
		}
		try {
			out.write(finalData);
			out.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
