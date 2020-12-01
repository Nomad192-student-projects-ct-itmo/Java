package game;

public class SequentialPlayer implements Player {

	int m = 3;
	int n = 3;

	public SequentialPlayer(final int m, final int n) {
		this.m = m;
		this.n = n;
	}

	@Override
	public Move makeMove(final Position position, final Cell cell) {
		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				if (position.get(row, col) == Cell.E) {
					return new Move(row, col, cell);
				}
			}
		}
		throw new AssertionError("No emply cells");
	}
}