package com.hackmann.server;

public class Main {

	public static void main(String[] args) {
		System.out.println("v5");
		Server server = new Server(16568);
		server.start();

	}

}
