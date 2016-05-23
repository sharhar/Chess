package main;

import game.Player;
import game.UserPlayer;
import server.Server;

public class Main {
	public static UserPlayer user;
	public static Player other = null;
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
