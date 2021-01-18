
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
