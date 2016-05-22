package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable{
	Socket socket;
	Thread thread;
	boolean on;
	PrintWriter out;
	BufferedReader in;
	
	public Client(String address, int port) {
		try {
			socket = new Socket(address, port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		thread = new Thread(this);
		
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new
		            InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		
		try {
			socket.close();
		} catch (IOException e) {
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
				System.out.println("Server sent " + input);
			 } catch (IOException e1) {
				e1.printStackTrace();
			}
			 
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
