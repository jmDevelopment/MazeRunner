package maloto.personalprojects.EscapeTheTrolls;

import java.util.Scanner;

public class GameRunner {
	
	
	public static void main(String[] args) {
		
		GameMap gameMap = new GameMap();
		GameView gameView = new GameView();
		GameMapController gameMapController = new GameMapController(gameMap, gameView);		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the Maze Runner Game");
		System.out.println("Direction Controls: 'w' - up, 's' down, 'a' - left, and 'd' - right.");
		System.out.println();
		
		System.out.println("INITIAL GAME BOARD");
		
		gameMapController.placePlayerEntity();
		gameMapController.updateView();
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		int roundCounter = 0;
				
		while((gameMapController.getFinishIndex()[0] != gameMapController.playerPiece.getXCoord()) && (gameMapController.getFinishIndex()[1] != gameMapController.playerPiece.getYCoord())) {
			
			System.out.println("Enter Direction");
			char moveChoice = sc.next().charAt(0);
			
			gameMapController.updatePlayerPosition(moveChoice);
			
			System.out.println("Round " + roundCounter);
			gameMapController.updateView();
			
			roundCounter++;
		}
		
		sc.close();
		
		
	}
	
	
}
