package maloto.personalprojects.EscapeTheTrolls;

public interface GamePiece {
	
	// Move game piece 
	void move(char input);
	
	// Generate random x coordinate
	int generateRandomX();
	
	// Generate random y coordinate;
	int generateRandomY();

}
