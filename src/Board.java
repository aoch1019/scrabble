
public class Board {

	Square[][] board;
	
	Board(){
		initializeSquares();
	}
	
	/**
	 * Initializes the board with the appropriate squares.
	 */
	void initializeSquares() {
		int[][] nums = {{4, 0, 0, 1, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 4},
						{0, 3, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0},
						{0, 0, 3, 0, 0, 0, 1, 0, 1, 0, 0, 0, 3, 0, 0},
						{1, 0, 0, 3, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0},
						{0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
						{0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0},
						{0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0},
						{4, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 1, 0, 0, 4},
						{0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0},
						{0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0},
						{0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
						{1, 0, 0, 3, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0},
						{0, 0, 3, 0, 0, 0, 1, 0, 1, 0, 0, 0, 3, 0, 0},
						{0, 3, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0},
						{4, 0, 0, 1, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 4}};
		this.board = new Square[15][15];
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums[i].length; j++) {
				this.board[i][j] = new Square(nums[i][j]);
			}
		}
	}
	
	public void printBoard() {
		for(Square[] sqArr : board) {
			for(Square sq : sqArr) {
				System.out.print(sq.getSquareString() + " | ");
			}
			System.out.println("");
			System.out.println("--------------------------------------------------------------------------");
		}
	}
	
	public void printBoardWithCoordinates() {
		System.out.println();
		System.out.print("     ");
		for(int i = 0; i < 15; i++) {
			if(i < 10) {
				System.out.print(" " + i + "   ");	
			}
			else {
				System.out.print(i + "   ");	
			}
		}
		System.out.println("");
		System.out.println("    ---------------------------------------------------------------------------");
		int row = 0;
		for(Square[] sqArr : board) {
			if(row < 10) {
				System.out.print(" " + row + " | ");				
			}
			else {
				System.out.print(row + " | ");
			}
			row++;
			for(Square sq : sqArr) {
				System.out.print(sq.getSquareString() + " | ");
			}
			System.out.println("");
			System.out.println("    ---------------------------------------------------------------------------");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board b = new Board();
		b.printBoardWithCoordinates();
	}

}
