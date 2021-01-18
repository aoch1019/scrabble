import java.util.*;

public class Game {

	Bag bag;
	ArrayList<Player> players;
	Board board;
	Player yourMove;
	
	Game(String[] playerNames){
		board = new Board();
		bag = new Bag();
		players = new ArrayList<Player>();
		for(String name : playerNames) {
			Player p = new Player(name, bag);
			players.add(p);
		}
		yourMove = players.get(0);
	}
	
	void displayGame() {
		board.printBoardWithCoordinates();
		for(Player p : players) {
			p.printTiles();
		}
		System.out.println("\nIt's " + yourMove.getName() + "'s turn\n");
		System.out.println("\nThe bag has " + bag.tilesLeft() + " tiles remaining");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] playerNames = {"Andrew", "Ali", "Josh"};
		Game g = new Game(playerNames);
		g.displayGame();
	}

}
