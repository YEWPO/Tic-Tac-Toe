package tictactoe;

import java.util.Scanner;

public class FinalGame {
	private String[][] tables;
	private int[] coordinates;
	private int turn;
	private int playerX;
	private int playerO;
	
	public FinalGame() {
		this.coordinates = new int[2];
		this.tables = new String[5][5];
		this.turn = 0;
		this.playerX = 0;
		this.playerO = 0;
	}
	
	public void startGame() {
		while (true) {
			inputCommands();
			setMap();
			printMap();
			
			while (true) {
				choosePlayer(turn % 2 == 0 ? playerX : playerO);
				tables[coordinates[0]][coordinates[1]] = turn % 2 == 0 ? "X" : "O";
				turn++;
				printMap();
				
				var state = new JudegeStatement(tables);
				int flag = state.statement();
				
				switch (flag) {
					case 0: System.out.println("Draw");
					break;
					case 1: System.out.println("X wins");
					break;
					case 2: System.out.println("O wins");
					break;
					default: continue;
				}
				break;
			}
		}
	}
	
	private void choosePlayer(int player) {
		switch (player) {
			case 0: var play0 = new UserPlayer(tables);
					coordinates = play0.startPlay();
					break;
			case 1: var play1 = new AIEasyPlayer(tables);
					System.out.println("Making move level \"easy\"");
					coordinates = play1.startPlay();
					break;
			case 2: var play2 = new AIMediumPlayer(tables, turn);
					System.out.println("Making move level \"medium\"");
					coordinates = play2.startPlay();
					break;
			case 3: var play3 = new AIHardPlayer(tables, turn);
					System.out.println("Making the move level \"hard\"");
					coordinates = play3.startPlay();
					break;
		}
	}
	
	private void inputCommands() {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("Input command: ");
			String[] commands = scanner.nextLine().trim().split("\\s+");
			
			try {
				switch (commands[0]) {
					case "start": {
						if (commands.length != 3)
							throw new Exception();
						switch (commands[1]) {
							case "user": this.playerX = 0;
								break;
							case "easy": this.playerX = 1;
								break;
							case "medium": this.playerX = 2;
								break;
							case "hard": this.playerX = 3;
								break;
							default: throw new Exception();
						}
						switch (commands[2]) {
							case "user": this.playerO = 0;
								break;
							case "easy": this.playerO = 1;
								break;
							case "medium": this.playerO = 2;
								break;
							case "hard": this.playerO = 3;
								break;
							default: throw new Exception();
						}
					}
					break;
					case "exit": {
						if (commands.length != 1)
							throw new Exception();
						System.exit(0);
					}
				}
			} catch (Exception e) {
				System.out.println("Bad parameters!");
				continue;
			}
			break;
		}
	}
	
	private void setMap() {
		this.turn = 0;
		
		for (int i = 0; i < tables.length; ++i) {
			for (int j = 0; j <  tables.length; ++j) {
				if (i == 0 || i == 4)
					tables[i][j] = "-";
				else if (j == 0 || j == 4)
					tables[i][j] = "|";
				else
					tables[i][j] = " ";
			}
		}
	}
	
	private void printMap() {
		for (String[] strings: tables){
			for (String string: strings)
				System.out.print(string + " ");
			System.out.println();
		}
	}
}
