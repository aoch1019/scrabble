
public class Square {

	Tile tile;
	int multiplier;
	
	/**
	 * Creates a new square on the Board
	 * @param multiplier An integer representation of the Square's multiplier (i.e. double word)
	 */
	Square(int multiplier){
		this.multiplier = multiplier;
	}
	
	
	
	public Tile getTile() {
		return tile;
	}



	public void setTile(Tile tile) {
		this.tile = tile;
	}



	public int getMultiplier() {
		return multiplier;
	}

	/**
	 * Returns the squares tile if it has one. Otherwise, it returns the squares multiplier.
	 * @return The squares tile if it has one. Otherwise, it returns the squares multiplier.
	 */
	public String getSquareString() {
		if(this.tile != null) {
			return tile.getLetter() + "";
		}
		else {
			return getMultiplierString();
		}
	}
	
	/**
	 * Gets a String representation of the Square's multiplier.
	 * @return
	 */
	public String getMultiplierString() {
		switch(this.multiplier){
			case 1:
				return "DL";
			case 2:
				return "TL";
			case 3:
				return "DW";		
			case 4:
				return "TW";	
			default:
				return "  ";
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
