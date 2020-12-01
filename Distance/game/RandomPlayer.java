package game;

import java.util.Random;

public class RandomPlayer implements Player {

	private final Random random = new Random();
	int m = 3;
	int n = 3;

	public RandomPlayer(final int m, final int n) {
		this.m = m;
		this.n = n;
	}

	@Override
	public Move makeMove(final Position position, final Cell cell) {
		//int row;
		//int col;
		Move move;
		do {
			//row = random.nextInt(3);
			//col = random.nextInt(3);
			//move = new Move (row, col, cell);
			move = new Move (random.nextInt(m), random.nextInt(n), cell);
		} while (!position.isValid(move)); //(position.get(row, col) == Cell.E);
		return move; //new Move(row, col, cell);
	}
}