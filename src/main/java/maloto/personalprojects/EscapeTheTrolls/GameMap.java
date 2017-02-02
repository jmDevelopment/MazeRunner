package maloto.personalprojects.EscapeTheTrolls;

public class GameMap {
	
	private String[][] gameMap;
	private int mapHeight;
	private int mapWidth;
	
	private String[][] sampleGameMap = 	{{"#########################################################################"},
										{"#   #               #               #           #                   #   #"},
										{"#   #   #########   #   #####   #########   #####   #####   #####   #   #"},
										{"#               #       #   #           #           #   #   #       #   #"},
										{"#########   #   #########   #########   #####   #   #   #   #########   #"},
										{"#       #   #               #           #   #   #   #   #           #   #"},
										{"#   #   #############   #   #   #########   #####   #   #########   #   #"},
										{"#   #               #   #   #       #           #           #       #   #"},
										{"#   #############   #####   #####   #   #####   #########   #   #####   #"},
										{"#           #       #   #       #   #       #           #   #           #"},
										{"#   #####   #####   #   #####   #   #########   #   #   #   #############"},
										{"#       #       #   #   #       #       #       #   #   #       #       #"},
										{"#############   #   #   #   #########   #   #####   #   #####   #####   #"},
										{"#           #   #           #       #   #       #   #       #           #"},
										{"#   #####   #   #########   #####   #   #####   #####   #############   #"},
										{"#   #       #           #           #       #   #   #               #   #"},
										{"#   #   #########   #   #####   #########   #   #   #############   #   #"},
										{"#   #           #   #   #   #   #           #               #   #       #"},
										{"#   #########   #   #   #   #####   #########   #########   #   #########"},
										{"#   #       #   #   #           #           #   #       #               #"},
										{"#   #   #####   #####   #####   #########   #####   #   #########   #   #"},
										{"#   #                   #           #               #               #   #"},
										{"# X #####################################################################"}};
	
	public void setGameMap(String[][] gameMap) {
		this.gameMap = gameMap;
	}
	
	public void setSampleGameMap(String[][] gameMap) {
		this.sampleGameMap = gameMap;
	}
	
	public void setMapHeight(int height) {
		this.mapHeight = height;
	}
	
	public void setMapWidth(int width) {
		this.mapWidth = width;
	}
	
	public int getMapHeight() {
		return mapHeight;
	}
	
	public int getMapWidth() {
		return mapWidth;
	}
	
	// For testing
	public int getSampleMapHeight() {
		return sampleGameMap.length;
	}
	
	public int getSampleMapWidth() {
		String[][] map = sampleGameMap;
		String[] targetRow = map[0];
		char[] targetRowAsChars = targetRow[0].toCharArray();
		
		return targetRowAsChars.length;
	}
	// For testing
	
	public String[][] getSampleGameMap() {
		return sampleGameMap;
	}
				
}
