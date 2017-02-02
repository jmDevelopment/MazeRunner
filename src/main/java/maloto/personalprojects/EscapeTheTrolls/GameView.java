package maloto.personalprojects.EscapeTheTrolls;

public class GameView {

	public void displayGame(String[][] gameMap) {
		for (String[] row : gameMap) {
			for (String line : row) {
				System.out.println(line.toString());
			}
		}
		
		
	}
	
	
}
