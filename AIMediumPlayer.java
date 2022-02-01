package tictactoe;

public class AIMediumPlayer {
	private String[][] tables;
	private int turn;
	
	public AIMediumPlayer(String[][] tables, int turn) {
		this.tables = tables;
		this.turn =turn;
	}
	
	public int[] startPlay() {
		return mediumSet();
	}
	
	private int[] mediumSet() {
		int[] coordinates = new int[2];
		
		for (int i = 1; i <= 3; ++i) {
			for (int j = 1; j <= 3; ++j) {
				if (tables[i][j].equals(" ")) {
					tables[i][j] = turn % 2 == 0  ? "X" : "O";
					var judge = new JudegeStatement(tables);
					if (turn % 2 == 0 ? judge.statement() == 1 : judge.statement() == 2) {
						coordinates[0] = i;
						coordinates[1] = j;
						return coordinates;
					}
					tables[i][j] = " ";
				}
			}
		}
		
		for (int i = 1; i <= 3; ++i) {
			for (int j = 1; j <= 3; ++j) {
				if (tables[i][j].equals(" ")) {
					tables[i][j] = turn % 2 == 0  ? "O" : "X";
					var judge = new JudegeStatement(tables);
					if (turn % 2 == 0 ? judge.statement() == 2 : judge.statement() == 1) {
						coordinates[0] = i;
						coordinates[1] = j;
						return coordinates;
					}
					tables[i][j] = " ";
				}
			}
		}
		
		var easy = new AIEasyPlayer(tables);
		return easy.startPlay();
	}
}
