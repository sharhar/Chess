package main;

import client.Client;
import server.Server;

public class Main {
	public static Client client;
	public static Server server;
	
	public static void net() {
		server = new Server(52000);
		server.start();
		
		client = new Client("localhost", 52000);
		client.start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		client.sendData("PING");
		server.sendToAll("PONG");
	}
	
	public static void main(String[] args) {
		
	}
}
