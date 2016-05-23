package game;

public class Board {
	
	public volatile Piece[][] pieces = new Piece[8][8];
	public int num;
	
	public void resetBoard() {
		for(int i = 0; i < 8;i++) {
			for(int j = 0; j < 8;j++) {
				pieces[i][j] = Piece.NOTHING;
			}
		}
		
		pieces[0][0] = Piece.W_ROOK;
		pieces[1][0] = Piece.W_KNIGHT;
		pieces[2][0] = Piece.W_BISHOP;
		pieces[3][0] = Piece.W_KING;
		pieces[4][0] = Piece.W_QUEEN;
		pieces[5][0] = Piece.W_BISHOP;
		pieces[6][0] = Piece.W_KNIGHT;
		pieces[7][0] = Piece.W_ROOK;
		
		pieces[0][1] = Piece.W_PAWN;
		pieces[1][1] = Piece.W_PAWN;
		pieces[2][1] = Piece.W_PAWN;
		pieces[3][1] = Piece.W_PAWN;
		pieces[4][1] = Piece.W_PAWN;
		pieces[5][1] = Piece.W_PAWN;
		pieces[6][1] = Piece.W_PAWN;
		pieces[7][1] = Piece.W_PAWN;
		
		pieces[0][7] = Piece.B_ROOK;
		pieces[1][7] = Piece.B_KNIGHT;
		pieces[2][7] = Piece.B_BISHOP;
		pieces[3][7] = Piece.B_KING;
		pieces[4][7] = Piece.B_QUEEN;
		pieces[5][7] = Piece.B_BISHOP;
		pieces[6][7] = Piece.B_KNIGHT;
		pieces[7][7] = Piece.B_ROOK;
		
		pieces[0][6] = Piece.B_PAWN;
		pieces[1][6] = Piece.B_PAWN;
		pieces[2][6] = Piece.B_PAWN;
		pieces[3][6] = Piece.B_PAWN;
		pieces[4][6] = Piece.B_PAWN;
		pieces[5][6] = Piece.B_PAWN;
		pieces[6][6] = Piece.B_PAWN;
		pieces[7][6] = Piece.B_PAWN;
	}
	
	public Board(int num) {
		this.num = num;
		
		resetBoard();
	}
	
	public void move(int px, int py, int mx, int my) {
		pieces[mx][my] = pieces[px][py];
		pieces[px][py] = Piece.NOTHING;
	}
	
	public boolean isLegalMove(int num, int px, int py, int mx, int my) {
		return true;
	}
}