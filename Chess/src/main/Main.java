package main;

import server.Server;

public class Main {
	public static Server server;
	public static Menu menu;
	
	public static void startServer(int port) {
		server = new Server(port);
		server.start();
	}
	
	public static void main(String[] args) {
		menu = new Menu();
	}
}
