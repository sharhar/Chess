package game;

import input.Mouse;
import main.GameWindow;

public class UserPlayer extends Player{
	
	public UserPlayer(String address, int port) {
		super(address, port);
	}

	public int[] move() {
		GameWindow.moving = 1;
		
		while(!Mouse.press) {
			int x = Mouse.x;
			int y = Mouse.y;
			
			int mx = (int) Math.round((x + 7)/70.0) - 1;
			int my = (int) Math.round((y - 15)/70.0) - 1;
			
			if(mx < 0) {
				mx = 0;
			}
			if(my < 0) {
				my = 0;
			}
			if(mx > 7) {
				mx = 7;
			}
			if(my > 7) {
				my = 7;
			}
			
			GameWindow.mx = mx;
			GameWindow.my = my;
		}
		
		Mouse.press = false;
		
		int cx = Mouse.cx;
		int cy = Mouse.cy;
		
		int px = (int) Math.round((cx - 0)/70.0) - 1;
		int py = (int) Math.round((cy - 0)/70.0) - 1;
		
		if(px < 0) {
			px = 0;
		}
		if(py < 0) {
			py = 0;
		}
		if(px > 7) {
			px = 7;
		}
		if(py > 7) {
			py = 7;
		} 
		
		GameWindow.px = px;
		GameWindow.py = py;
		GameWindow.moving = 2;
		
		while(!Mouse.press) {
			int x = Mouse.x;
			int y = Mouse.y;
			
			int mx = (int) Math.round((x + 7)/70.0) - 1;
			int my = (int) Math.round((y - 15)/70.0) - 1;
			
			if(mx < 0) {
				mx = 0;
			}
			if(my < 0) {
				my = 0;
			}
			if(mx > 7) {
				mx = 7;
			}
			if(my > 7) {
				my = 7;
			}
			
			GameWindow.mx = mx;
			GameWindow.my = my;
		}
		
		Mouse.press = false;
		
		int[] result = {-1,-1,-1,-1};
		
		return result;
	}
}
