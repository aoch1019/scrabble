
public class Tile {

	boolean isBlank;
	char letter;

	/**
	 * Creates a new Tile with the specified letter
	 * @param letter The letter that the tile should be (input of space as the char means blank tile).
	 */
	Tile(char letter){
		if(letter == ' ') {
			this.isBlank = true;
		}
		else {
			this.isBlank = false;
		}
		this.letter = letter;
	}
	
	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public boolean isBlank() {
		return isBlank;
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
