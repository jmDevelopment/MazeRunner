package maloto.personalprojects.EscapeTheTrolls;

import java.util.Random;
import java.util.Scanner;

public class PlayerPiece implements GamePiece{

	public char characterIcon = '@';
	private int xCoord;
	private int yCoord;
	GameMap gameMap;
	
	public PlayerPiece (GameMap gameMap) {
		this.gameMap = gameMap;
		this.xCoord = generateRandomX();
		this.yCoord = generateRandomY();
	}
	
	public void setXCoord(int xCoord) {
		this.xCoord = xCoord;
	}
	
	public void setYCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	
	public int getXCoord() {
		return xCoord;
	}
	
	public int getYCoord() {
		return yCoord;
	}
	
	public char getCharacterIcon() {
		return characterIcon;
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
	
	public void move(char input) {
		
		if (input == 'w') {
			setYCoord(getYCoord() - 1);
		} else if (input == 's') {
			setYCoord(getYCoord()  + 1);
		} else if (input == 'a') {
			setXCoord(getXCoord()  - 2);
		} else if (input == 'd') {
			setXCoord(getXCoord()  + 2);
		}
		
	}
	


		
	
}
