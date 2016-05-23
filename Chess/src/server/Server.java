package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server implements Runnable{
	
	List<ServerClient> clients = new ArrayList<ServerClient>();
	ServerSocket server;
	Thread thread;
	boolean on;
	int clientNum = 0;
	int currentPlayer = 0;
	
	public Server(int port) {
		ServerClient.server = this;
		
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			System.err.println("Couln't creat server on port " + port);
			e.printStackTrace();
		}
		
		thread = new Thread(this);
	}
	
	public void start() {
		on = true;
		thread.start();
	}
	
	public void stop() {
		on = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void sendToAll(String data) {
		for(ServerClient client:clients) {
			client.sendData(data);
		}
	}
	
	public void nextMove() {
		sendToAll("PLAY " + currentPlayer);
		currentPlayer++;
		currentPlayer = currentPlayer%2;
	}
	
	public void run() {
		while(on) {
			try {
				Socket clientSocket = server.accept();
				ServerClient client = new ServerClient(clientSocket, clientNum);
				client.start();
				clients.add(client);
				clientNum++;
				
				if(clientNum == 2) {
					try {
						Thread.sleep(15);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Starting game...");
					sendToAll("START");
					
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					nextMove();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
