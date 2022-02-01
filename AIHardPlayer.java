package tictactoe;

import java.util.ArrayList;
import java.util.Random;

public class AIHardPlayer {
	private String[][] tables;
	private int turn;
	
	public AIHardPlayer(String[][] tables, int turn) {
		this.tables = tables;
		this.turn = turn;
	}
	
	public int[] startPlay() {
		return hardSet();
	}
	
	private int[] hardSet() {
		int[] coordinates = new int[2];
		ArrayList<Pair> list = new ArrayList<>();
		int value = Integer.MIN_VALUE;
		
		for (int i = 0; i <= 3;  ++i) {
			for (int j = 0; j <= 3; ++j) {
				if (tables[i][j].equals(" "))
					list.add(new Pair(i, j));
			}
		}
		
		for (Pair pair: list) {
			tables[pair.getX()][pair.getY()] = turn % 2 == 0 ? "X" : "O";
			
			int flag = mimMaxAlgorithm(tables, turn + 1);
			if (flag > value) {
				value = flag;
				coordinates[0] = pair.getX();
				coordinates[1] = pair.getY();
			}
			tables[pair.getX()][pair.getY()] = " ";
		}
		
		return coordinates;
	}
	
	private int mimMaxAlgorithm(String[][] nowTables, int nowTurn) {
		ArrayList<Pair> list = new ArrayList<>();
		int value = 0;
		
		for (int i = 0; i <= 3;  ++i) {
			for (int j = 0; j <= 3; ++j) {
				if (tables[i][j].equals(" "))
					list.add(new Pair(i, j));
			}
		}
		
		if (nowTurn % 2 == turn % 2) {
			value = Integer.MIN_VALUE;
			for (Pair pair: list) {
				nowTables[pair.getX()][pair.getY()] = nowTurn % 2 == 0 ? "X" : "O";
				var state = new JudegeStatement(nowTables);
				switch (state.statement()) {
					case 0: value = Math.max(value, 0);
						break;
					case 1: value = Math.max(value, nowTurn % 2 == 0 ? 10 : -10);
						break;
					case 2: value = Math.max(value, nowTurn % 2 == 0 ? -10 : 10);
						break;
					default: value = Math.max(value, mimMaxAlgorithm(nowTables, nowTurn + 1));
						break;
				}
				nowTables[pair.getX()][pair.getY()] = " ";
			}
		}
		else {
			value = Integer.MAX_VALUE;
			for (Pair pair: list) {
				nowTables[pair.getX()][pair.getY()] = nowTurn % 2 == 0 ? "X" : "O";
				var state = new JudegeStatement(nowTables);
				switch (state.statement()) {
					case 0: value = Math.min(value, 0);
						break;
					case 1: value = Math.min(value, nowTurn % 2 == 0 ? -10 : 10);
						break;
					case 2: value = Math.min(value, nowTurn % 2 == 0 ? 10 : -10);
						break;
					default: value = Math.min(value, mimMaxAlgorithm(nowTables, nowTurn + 1));
						break;
				}
				nowTables[pair.getX()][pair.getY()] = " ";
			}
		}
		return value;
	}
}

class Pair{
	private int x;
	private int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
