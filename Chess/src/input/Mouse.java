package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener{
	public static int cx = -1, cy = -1, lcx = -1, lcy = -1;
	
	public void mouseClicked(MouseEvent e) {
		lcx = cx;
		lcy = cy;
		cx = e.getX();
		cy = e.getY();
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

}
