package tictactoe;

import java.util.Random;

public class AIEasyPlayer {
	private String[][] tables;
	
	public AIEasyPlayer(String[][] tables) {
		this.tables = tables;
	}
	
	public int[] startPlay() {
		return randomSet();
	}
	
	private int[] randomSet() {
		var rand = new Random();
		int[] coordinates = new int[2];
		
		while (true) {
			coordinates[0] = rand.nextInt(4) + 1;
			coordinates[1] = rand.nextInt(4) + 1;
			
			if (tables[coordinates[0]][coordinates[1]].equals(" "))
				break;
		}
		return coordinates;
	}
}
