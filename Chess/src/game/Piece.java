package game;

public class Piece {
	
	public static int TYPE_PAWN = 0;
	public static int TYPE_ROOK = 1;
	public static int TYPE_KNGT = 2;
	public static int TYPE_BSHP = 3;
	public static int TYPE_KING = 4;
	public static int TYPE_QUEN = 5;
	
	public int x, y;
	public int type;
	
	public Piece(int type, int x, int y) {
		this.type = type;
		this.x = x;
		this.y = y;
	}
}
