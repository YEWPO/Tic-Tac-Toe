package tictactoe;

import java.util.Scanner;

public class UserPlayer {
	private String[][] tables;
	
	public UserPlayer(String[][] tables) {
		this.tables = tables;
	}
	
	public int[] startPlay() {
		return inputCoordinates();
	}
	
	private int[] inputCoordinates() {
		Scanner scanner = new Scanner(System.in);
		int[] coordinates = new int[2];
		
		while(true) {
			System.out.print("Enter the coordinates: ");
			String[] input = scanner.nextLine().trim().split("\\s+");
			
			try {
				coordinates[0] = Integer.parseInt(input[0]);
				coordinates[1] = Integer.parseInt(input[1]);
				if (coordinates[0] < 1 || coordinates[0] > 3
					|| coordinates[1] < 1 || coordinates[1] > 3) {
					System.out.println("Coordinates should be from 1 to 3!");
				}
				if (tables[coordinates[0]][coordinates[1]].equals(" "))
					break;
			} catch (NumberFormatException e) {
				System.out.println("You should enter numbers!");
			}
		}
		
		return coordinates;
	}
}
