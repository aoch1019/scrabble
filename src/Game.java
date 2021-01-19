import java.util.*;

public class Game {

	Bag bag;
	ArrayList<Player> players;
	Board board;
	Board dynamicBoard;
	int[][] integerRepresentationOfBoard;
	Player yourMove;
	
	Game(String[] playerNames){
		board = new Board();
		dynamicBoard = board.clone();
		bag = new Bag();
		players = new ArrayList<Player>();
		for(String name : playerNames) {
			Player p = new Player(name, bag);
			players.add(p);
		}
		yourMove = players.get(0);
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	void displayGame() {
		board.printBoardWithCoordinates();
		for(Player p : players) {
			p.printTiles();
		}
		System.out.println("\nIt's " + yourMove.getName() + "'s turn\n");
		System.out.println("\nThe bag has " + bag.tilesLeft() + " tiles remaining");
	}
	
	void displayDynamicBoard() {
		System.out.println("\n\n\nDisplaying the dynamic board...\n");
		dynamicBoard.printBoardWithCoordinates();
	}
	
	/**
	 * Creates an integer representation of the dynamic board. 1 means there is a tile, 0 means it's blank.
	 */
	public void setIntRepresentationOfBoard(){
		int[][] intRep = new int[15][15];
		Square[][] boardSquares = dynamicBoard.getBoard();
		for(int i = 0; i < boardSquares.length; i++) {
			for(int j = 0; j < boardSquares[i].length; j++){
				if(boardSquares[i][j].hasTile()) {
					intRep[i][j] = 1;
				}
				else {
					intRep[i][j] = 0;
				}
			}
		}
		integerRepresentationOfBoard = intRep;
	}
	
	public void printIntegerRepresentation() {
		for(int[] row : this.integerRepresentationOfBoard) {
			for(int currInt : row) {
				System.out.print(currInt + " ");
			}
			System.out.println();
		}
	}
	
	void makeMove() {
		board = dynamicBoard.clone();
	}
	
	/**
	 * Updates both the dynamic board and its integer representation
	 * @param t
	 * @param row
	 * @param col
	 */
	void tryMove(Tile t, int row, int col) {
		dynamicBoard.placeTile(t, row, col);
		setIntRepresentationOfBoard();
	}
	
	/**
	 * Iterates through the integer representation of the board and returns all valid coordinates.
	 * @return
	 */
	ArrayList<HashMap<String, Integer>> getValidLocations(){
		
		ArrayList<HashMap<String, Integer>> validCoords = new ArrayList<HashMap<String, Integer>>();
		
		for(int i = 0; i < this.integerRepresentationOfBoard.length; i++) {
			for(int j = 0; j < this.integerRepresentationOfBoard[i].length; j++) {
				if(isValidLocation(i, j)) {
					HashMap<String, Integer> coords = new HashMap<String, Integer>();
					coords.put("row", i);
					coords.put("col", j);
					validCoords.add(coords);
				}
			}
		}
		
		return validCoords;
	}
	
	/**
	 * A helper method to check if a given location on the board is a valid placement by checking its neighbors.
	 * @param row
	 * @param col
	 * @return
	 */
	boolean isValidLocation(int row, int col) {
		// If the space is already filled, return false
		if(this.integerRepresentationOfBoard[row][col] == 1) {
			return false;
		}
		// If the space is the middle square and is 0, return true.
		if(row == 7 && col == 7) {
			return true;
		}
		
		int upperRow = row - 1;
		int lowerRow = row + 1;
		int leftCol = col - 1;
		int rightCol = col + 1;
		
		// Check the four surrounding positions. Before checking, ensure that the row/column exists.
		if(upperRow >= 0 && this.integerRepresentationOfBoard[upperRow][col] == 1) {
			return true;
		}
		if(lowerRow <= 14 && this.integerRepresentationOfBoard[lowerRow][col] == 1) {
			return true;
		}
		if(leftCol >= 0 && this.integerRepresentationOfBoard[row][leftCol] == 1) {
			return true;
		}
		if(rightCol <= 14 && this.integerRepresentationOfBoard[row][rightCol] == 1) {
			return true;
		}
		return false;
	}
	
	public void printValidLocations() {
		System.out.println("Here are all valid locations to place a tile:");
		for(HashMap<String, Integer> map : getValidLocations()) {
			System.out.println("row: " + map.get("row") + "  col: " + map.get("col"));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] playerNames = {"Andrew", "Ali", "Josh"};
		Game g = new Game(playerNames);
		g.tryMove(g.getPlayers().get(0).getTiles().get(0), 7, 7);
		g.makeMove();
		g.displayGame();
		g.displayDynamicBoard();
		g.printIntegerRepresentation();
		g.printValidLocations();
		
		g.tryMove(g.getPlayers().get(1).getTiles().get(0), 6, 7);
		g.displayGame();
		g.displayDynamicBoard();
		g.printIntegerRepresentation();
		g.printValidLocations();
	}

}
