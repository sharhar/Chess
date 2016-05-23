package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerClient implements Runnable{
	
	Socket socket;
	Thread thread;
	boolean on;
	PrintWriter out;
	BufferedReader in;
	boolean ready = false;
	int num;
	public static Server server;
	
	public ServerClient(Socket socket, int num) {
		System.out.println("New client at " + socket.getInetAddress().toString());
		this.socket = socket;
		this.thread = new Thread(this);
		
		try {
			out = new PrintWriter(this.socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.num = num;
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
	
	public void sendData(String data) {
		out.println(data);
	}
	
	public void run() {
		while(on) {
			try {
				String input = in.readLine();
				if(input.equals("CONNECT")) {
					sendData("CONNECT " + num);
				} else if(input.startsWith("MOVE ")) {
					server.sendToAll(input);
				}
			} catch (IOException e) {
				System.out.println("Could not connect to client " + socket.getInetAddress().toString());
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
