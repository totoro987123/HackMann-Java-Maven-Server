package com.hackmann.server;

public class Main {
	
	public static void main(String[] args) {
		
		Server server = new Server(16568);
		server.start();
		
	}

}