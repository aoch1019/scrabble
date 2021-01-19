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
		dynamicBoard.printBoardWithCoordinates();
	}
	
	/**
	 * Creates an integer representation of the board. 1 means there is a tile, 0 means it's blank.
	 */
	public void setIntRepresentationOfBoard(){
		int[][] intRep = new int[15][15];
		Square[][] boardSquares = board.getBoard();
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
	
	void makeAMove(Tile t, int row, int col) {
		board = dynamicBoard.clone();
	}
	
	void tryMove(Tile t, int row, int col) {
		dynamicBoard.placeTile(t, row, col);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] playerNames = {"Andrew", "Ali", "Josh"};
		Game g = new Game(playerNames);
		g.displayGame();
		g.setIntRepresentationOfBoard();
		g.printIntegerRepresentation();
		g.tryMove(g.getPlayers().get(0).getTiles().get(0), 7, 7);
		g.displayGame();
		g.displayDynamicBoard();
		g.setIntRepresentationOfBoard();
		g.printIntegerRepresentation();

	}

}
