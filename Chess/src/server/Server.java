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
	
	public Server(int port) {
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
	
	public void run() {
		while(on) {
			try {
				Socket clientSocket = server.accept();
				ServerClient client = new ServerClient(clientSocket);
				client.start();
				while(!client.ready()) {} 
				clients.add(client);
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
