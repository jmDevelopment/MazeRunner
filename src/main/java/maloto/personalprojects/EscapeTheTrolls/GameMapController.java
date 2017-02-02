package maloto.personalprojects.EscapeTheTrolls;

import java.util.Arrays;
import java.util.Random;

public class GameMapController {
	
	GameMap gameMap;
	GameView gameView;
	PlayerPiece playerPiece;
	
	public GameMapController(GameMap gameMap, GameView gameView) {
		this.gameMap = gameMap;
		this.gameView = gameView;
		this.playerPiece = new PlayerPiece(gameMap);
	}
	
	public Boolean isSpaceEmpty(int xCoord, int yCoord) {
		
		Boolean check = false;
		String[][] map = gameMap.getSampleGameMap();
		String targetRow = Arrays.toString(map[yCoord]).substring(1, Arrays.toString(map[yCoord]).length() - 1);
		
		if (targetRow.charAt(xCoord) == ' ') {
			if( (targetRow.charAt(xCoord - 1) == ' ') && (targetRow.charAt(xCoord + 1) == ' ') && (xCoord % 2 == 0)) {
				System.out.println( "IS EMPTY ---> " + xCoord % 2);
				check = true;
			} 
		}
		
		return check;
	}
	
	public void placePlayerEntity() {
		int xCoord = playerPiece.getXCoord();
		int yCoord =  playerPiece.getYCoord();
			
		while (!isSpaceEmpty(xCoord, yCoord)){
			playerPiece.setXCoord(playerPiece.generateRandomX());
			playerPiece.setYCoord(playerPiece.generateRandomY());
			
			xCoord = playerPiece.getXCoord();
			yCoord =  playerPiece.getYCoord();
			
		}
		
		String[][] map = gameMap.getSampleGameMap();
		String[] targetRow = map[yCoord];
		char[] targetRowAsChars = targetRow[0].toCharArray();
		
		if(isSpaceEmpty(xCoord, yCoord)) {
			playerPiece.setXCoord(xCoord);
			playerPiece.setYCoord(yCoord);
			targetRowAsChars[xCoord] = playerPiece.getCharacterIcon();
			targetRow[0] = String.valueOf(targetRowAsChars);
		}	
		
		gameMap.setSampleGameMap(map);
		
	}
	
	public void updatePlayerPosition(char input) {
		
		int priorIndex = 0;
		
		playerPiece.move(input);
		String[][] map = gameMap.getSampleGameMap();
	
		if (isSpaceEmpty(playerPiece.getXCoord(), playerPiece.getYCoord())) {
			
			if (input == 'w') {
				priorIndex = playerPiece.getYCoord() + 1;
			} else if (input == 's') {
				priorIndex = playerPiece.getYCoord() - 1;
			} else if (input == 'a') {
				priorIndex = playerPiece.getXCoord() + 2;
			} else if (input == 'd') {
				priorIndex = playerPiece.getXCoord() - 2;
			}
			
			if (input == 'w' || input == 's') {
				String[] targetRow = map[playerPiece.getYCoord()];
				char[] targetRowAsChars = targetRow[0].toCharArray(); // Transform String array into Char array.
				
				targetRowAsChars[playerPiece.getXCoord()] = playerPiece.getCharacterIcon(); // Move char to new index.
				targetRow[0] = String.valueOf(targetRowAsChars);
				
				String[] oldTargetRow = map[priorIndex];
				char[] oldTargetRowAsChars = oldTargetRow[0].toCharArray(); // Transform String array into Char array.
				oldTargetRowAsChars[playerPiece.getXCoord()] = ' '; // Replace priorly filled space with empty char.
				oldTargetRow[0] = String.valueOf(oldTargetRowAsChars);
			
			} else if (input == 'a' || input == 'd') {
				
				String[] targetRow = map[playerPiece.getYCoord()];
				
				System.out.println("TARGET ROW " + Arrays.toString(targetRow));
				System.out.println("XCOORD ---> " + playerPiece.getXCoord());
				System.out.println("PRIOR INDEX ---> " + priorIndex);
				
				char[] targetRowAsChars = targetRow[0].toCharArray(); // Transform String array into Char array.
				targetRowAsChars[playerPiece.getXCoord()] = playerPiece.getCharacterIcon(); // Move char to new index.
				targetRow[0] = String.valueOf(targetRowAsChars);

				targetRowAsChars[priorIndex] = ' ';
				targetRow[0] = String.valueOf(targetRowAsChars);
			}
			
			gameMap.setSampleGameMap(map);
		} else {
			System.out.println("CANNOT MOVE HERE -- PLEASE CHOOSE NEW POSITION");
			playerPiece.move(input);
		}
	}
	
	
	public void placeEnemyEntity(int numberOfEnemies) {
		
		for (int i = 0; i < numberOfEnemies; i++) {
			int xCoord = generateRandomX();
			int yCoord = generateRandomY();
			
			while (!isSpaceEmpty(xCoord, yCoord)){
				xCoord = generateRandomX();
				yCoord = generateRandomY();
			}
			
			String[][] map = gameMap.getSampleGameMap();
			String[] targetRow = map[yCoord];
			char[] targetRowAsChars = targetRow[0].toCharArray();
			
			if(isSpaceEmpty(xCoord, yCoord)) {
				targetRowAsChars[xCoord] = '*';
				targetRow[0] = String.valueOf(targetRowAsChars);
			}	
			gameMap.setSampleGameMap(map);
		}
	}
	
	public int generateRandomY() {
		int value;
		Random rand = new Random();
		int min = 1;
		int max = gameMap.getSampleMapHeight() - 1;
		
		value = rand.nextInt((max - min) + 1) + min;
		
		return value;
		
	}
	
	public int generateRandomX() {
		int value; 
		Random rand = new Random();
		int min = 1; 
		int max = gameMap.getSampleMapWidth() - 1;
				
		value = rand.nextInt((max - min) + 1) + min;
		
		return value;
	}
	
	
	
	public int[] getFinishIndex() {
		int[] coordinates = new int[2];
		String[][] map = gameMap.getSampleGameMap();
		
		for (int i = 0; i < map.length; i++) {	
			String targetRow = Arrays.toString(map[i]).substring(1, Arrays.toString(map[i]).length() - 1);
			if (targetRow.contains("X")) {
				coordinates[1] = i;
				coordinates[0] = targetRow.indexOf('X');
			}
		}
		
		return coordinates;
	}
	
	public void updateView() {
		gameView.displayGame(gameMap.getSampleGameMap());
	}

}
