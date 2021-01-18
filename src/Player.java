import java.util.*;

public class Player {

	String name;
	ArrayList<Tile> tiles;
	
	Player(String name, Bag bag){
		this.name = name;
		tiles = new ArrayList<Tile>(); 
		for(int i = 0; i < 7; i++) {
			tiles.add(bag.getRandomTile());
		}
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<Tile> getTiles() {
		return tiles;
	}


	void printTiles() {
		System.out.println("            " + name);
		System.out.println("-----------------------------");
		System.out.print("| ");
		for(Tile t : tiles) {
			System.out.print(t.getLetter() + " | ");
		}
		System.out.println("\n-----------------------------");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bag bag = new Bag();
		Player andrew = new Player("Andrew", bag);
		andrew.printTiles();
		System.out.println(bag.tilesLeft());
	}

}
