package com.hackmann.server;

import com.hackmann.game.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
	
	private int port;
	private ServerSocket serverSocket;
	private boolean running = false;
	private int id = 0;
	
	public Server(int port) {
		this.port = port;
		
		try {
			serverSocket = new ServerSocket(port);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		new Thread(this).start();
		new Thread(MatchMaker.matchMaker).start();
	}

	@Override
	public void run() {
		running = true;
		System.out.println("Server started on port: " + port);
		
		while(running) {
			try {
				Socket socket = serverSocket.accept();
				initSocket(socket);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		shutdown();
	}
	
	private void initSocket(Socket socket) {
		Connection connection = new Connection(socket,id);
		new Thread(connection).start();
		this.id++;
	}
	
	public void shutdown() {
		this.running = false;
		MatchMaker.matchMaker.stop();

		try {
			serverSocket.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
