
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
	 * Gets a String representation of the Square's multiplier.
	 * @return
	 */
	public String getMultiplierString() {
		switch(this.multiplier){
			case 1:
				return "Double Letter";
			case 2:
				return "Triple Letter";
			case 3:
				return "Double Word";		
			case 4:
				return "Triple Word";	
			default:
				return "";
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
