import java.util.*;

public class Bag {

	ArrayList<Tile> tiles;
	
	Bag(){
		HashMap<Character, Integer> letterBreakdown = new HashMap<Character, Integer>();
		letterBreakdown.put('A', 9);
		letterBreakdown.put('B', 2);
		letterBreakdown.put('C', 2);
		letterBreakdown.put('D', 4);
		letterBreakdown.put('E', 12);
		letterBreakdown.put('F', 2);
		letterBreakdown.put('G', 3);
		letterBreakdown.put('H', 2);
		letterBreakdown.put('I', 9);
		letterBreakdown.put('J', 1);
		letterBreakdown.put('K', 1);
		letterBreakdown.put('L', 4);
		letterBreakdown.put('M', 2);
		letterBreakdown.put('N', 6);
		letterBreakdown.put('O', 8);
		letterBreakdown.put('P', 2);
		letterBreakdown.put('Q', 1);
		letterBreakdown.put('R', 6);
		letterBreakdown.put('S', 4);
		letterBreakdown.put('T', 6);
		letterBreakdown.put('U', 4);
		letterBreakdown.put('V', 2);
		letterBreakdown.put('W', 2);
		letterBreakdown.put('X', 1);
		letterBreakdown.put('Y', 2);
		letterBreakdown.put('Z', 1);
		letterBreakdown.put(' ', 2);
		
		tiles = new ArrayList<Tile>();
		
		for(Character c : letterBreakdown.keySet()) {
			for(int i = 0; i < letterBreakdown.get(c); i++) {
				tiles.add(new Tile(c));	
			}
		}
	}
	
	public ArrayList<Tile> getTiles() {
		return tiles;
	}

	public void printBag() {
		for(Tile t : tiles) {
			System.out.println(t.getLetter());
		}
	}
	
	/**
	 * Gets a random tile from the Bag and removes it from the Bag object
	 * @return The randomly selected tile
	 */
	public Tile getRandomTile() {
		Random r = new Random();
		int index = r.nextInt(tiles.size());
		Tile t = tiles.get(index);
		removeTile(t);
		return t;
	}
	
	/**
	 * Removes the given tile from the Bag
	 * @param t The tile to remove
	 */
	public void removeTile(Tile t) {
		tiles.remove(t);
	}
	
	public int tilesLeft() {
		return tiles.size();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bag b = new Bag();
		b.printBag();
		System.out.println("Before removing, there are " + b.getTiles().size() + " tiles in the bag.");
		Tile t = b.getRandomTile();
		System.out.println("Removed a " + t.getLetter());
		System.out.println("Now there are " + b.getTiles().size() + " remaining");
	}

}
