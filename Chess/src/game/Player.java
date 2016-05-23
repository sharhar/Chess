package game;

import client.Client;
import client.ClientImpl;

public abstract class Player implements ClientImpl{
	public Client client;
	public int id;
	public boolean ready = false;
	public Board board;
	
	public Player(String address, int port) {
		this.client = new Client(address, port, this);
		this.client.start();
	}
	
	public abstract void move();
	
	public void send(Client client) {
		if(!ready) {
			client.sendData("CONNECT");
		}
	}
	
	public void listen(Client client, String data) {
		if(!ready && data.startsWith("CONNECT")) {
			this.id = Integer.parseInt(data.split(" ")[1]);
			board = new Board(this.id);
			System.out.println("I am player " + id + "!");
			ready = true;
		}
	}
}
