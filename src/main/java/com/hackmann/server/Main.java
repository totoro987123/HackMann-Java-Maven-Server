package com.hackmann.server;

public class Main {
	
	public static void main(String[] args) {
		
		Server server = new Server(4500);
		server.start();
		
	}

}