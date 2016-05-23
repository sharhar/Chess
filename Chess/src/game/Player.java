package game;

import client.Client;
import client.ClientImpl;

public abstract class Player implements ClientImpl{
	public Client client;
	public int id;
	public boolean ready = false;
	public Board board;
	boolean started = false;
	
	public Player(String address, int port) {
		this.client = new Client(address, port, this);
		this.client.start();
	}
	
	public abstract int[] move();
	
	public void send(Client client) {
		if(!ready) {
			client.sendData("CONNECT");
		} else if (started){
			//int[] moved = move();
			//client.sendData("MOVE " + moved[0] + " " + moved[1] + " " + moved[2] + " " + moved[3]);
		}
	}
	
	public void listen(Client client, String data) {
		if(!ready && data.startsWith("CONNECT")) {
			this.id = Integer.parseInt(data.split(" ")[1]);
			board = new Board(this.id);
			System.out.println("I am player " + id + "!");
			ready = true;
		} else if(data.equals("START")) {
			started = true;
		} else if (data.startsWith("MOVE ")) {
			String[] parts = data.split(" ");
			int[] moved = new int[4];
			moved[0] = Integer.parseInt(parts[1]);
			moved[1] = Integer.parseInt(parts[2]);
			moved[2] = Integer.parseInt(parts[3]);
			moved[3] = Integer.parseInt(parts[4]);
			
			if(moved[0] != -1) {
				board.move(moved[0], moved[1], moved[2], moved[3]);
			}
		} else if (data.startsWith("PLAY ")) {
			String[] parts = data.split(" ");
			
			int num = Integer.parseInt(parts[1]);
			if(num == id) {
				int[] moved = move();
				client.sendData("MOVE " + moved[0] + " " + moved[1] + " " + moved[2] + " " + moved[3]);
			}
		}
	}
}
