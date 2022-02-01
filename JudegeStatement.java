package tictactoe;

public class JudegeStatement {
	private String[][] tables;
	
	public JudegeStatement(String[][] tables) {
		this.tables = tables;
	}
	
	public int statement() {
		if ((tables[1][1].equals("X") && tables[1][2].equals("X") && tables[1][3].equals("X"))
				|| (tables[2][1].equals("X") && tables[2][2].equals("X") && tables[2][3].equals("X"))
				|| (tables[3][1].equals("X") && tables[3][2].equals("X") && tables[3][3].equals("X"))
				|| (tables[1][1].equals("X") && tables[2][2].equals("X") && tables[3][3].equals("X"))
				|| (tables[3][1].equals("X") && tables[2][2].equals("X") && tables[1][3].equals("X"))
				|| (tables[1][1].equals("X") && tables[2][1].equals("X") && tables[3][1].equals("X"))
				|| (tables[1][2].equals("X") && tables[2][2].equals("X") && tables[3][2].equals("X"))
				|| (tables[1][3].equals("X") && tables[2][3].equals("X") && tables[3][3].equals("X")))
			return 1;
		if ((tables[1][1].equals("O") && tables[1][2].equals("O") && tables[1][3].equals("O"))
				|| (tables[2][1].equals("O") && tables[2][2].equals("O") && tables[2][3].equals("O"))
				|| (tables[3][1].equals("O") && tables[3][2].equals("O") && tables[3][3].equals("O"))
				|| (tables[1][1].equals("O") && tables[2][2].equals("O") && tables[3][3].equals("O"))
				|| (tables[3][1].equals("O") && tables[2][2].equals("O") && tables[1][3].equals("O"))
				|| (tables[1][1].equals("O") && tables[2][1].equals("O") && tables[3][1].equals("O"))
				|| (tables[1][2].equals("O") && tables[2][2].equals("O") && tables[3][2].equals("O"))
				|| (tables[1][3].equals("O") && tables[2][3].equals("O") && tables[3][3].equals("O")))
			return 2;
		
		int numberOfX = 0;
		int numberOfO = 0;
		
		for (int i = 1; i <= 3; ++i){
			for (int j = 1; j <= 3; ++j) {
				if (tables[i][j].equals("X"))
					numberOfX++;
				else if (tables[i][j].equals("O"))
					numberOfO++;
			}
		}
		if (numberOfX + numberOfO == 9)
			return 0;
		
		return -1;
	}
}
