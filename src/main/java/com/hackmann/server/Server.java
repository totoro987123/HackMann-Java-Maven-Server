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

	private MatchMaker matchMaker;
	
	public Server(int port) {
		this.port = port;
		
		try {
			serverSocket = new ServerSocket(port);
		}catch(IOException e) {
			e.printStackTrace();
		}

		this.matchMaker = new MatchMaker();
	}
	
	public void start() {
		new Thread(this).start();
		new Thread(this.matchMaker).start();
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
		ConnectionHandler.connections.put(id,connection);
		new Thread(connection).start();
		this.id++;
	}
	
	public void shutdown() {
		this.running = false;
		this.matchMaker.stop();
		
		try {
			serverSocket.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
