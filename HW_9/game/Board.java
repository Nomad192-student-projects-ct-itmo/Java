package game;

import java.util.Arrays;

public class Board implements Position {

	int m=3;
	int n=3;
	int k=3;

	int empty;

	private	Cell[][] field; // = new Cell[m][n];
	private	Cell turn;

	public Board(int m, int n, int k) {
		this.m = m;
		this.n = n;
		this.k = k;

		field = new Cell[m][n];
	 	for (int r = 0; r < m; r++) {
			Arrays.fill(field[r], Cell.E);
		}
		turn = Cell.X;
		empty = m*n;
	}


    @Override
    public int getM() {
    	return m;
    }


    @Override
    public int getN() {
    	return n;
    }	


	@Override
   	public String toString() {
   		final StringBuilder sb = new StringBuilder(" ");

   		for (int v=0; v < n; v++) {
   			sb.append(' ');
   			sb.append(v + 1);	
   		}
   		sb.append('\n');

   		for (int r = 0; r < m; r++) {
			sb.append(r + 1);
			for (Cell cell : field[r]) {
				if (cell == Cell.E) {
					sb.append(" .");
				} else {
					sb.append(' ');
					sb.append(cell);
				}	
			}
			sb.append('\n');
		}
       	return sb.toString();
    }

    public Cell getTurn() {
    	return turn;
    }


    @Override
    public Cell get (final int row, final int col) {
    	return field[row][col];
    }

    @Override
    public boolean isValid (final Move move) {

    	return 0 <= move.getRow() && move.getRow() < m
    			&& 0 <= move.getCol() && move.getCol() < n
    			&& get(move.getRow(), move.getCol()) == Cell.E
    			&& move.getValue() == turn;
    }

    public Result makeMove(final Move move) {
    	empty--;    	
    	//if (!isValid(move)) {
    		//return Result.LOSE;
    	//}

    	field[move.getRow()][move.getCol()] = move.getValue();	

    	/*int diag1 = 0;
    	int diag2 = 0;
    	int empty = 0;
    	for (int u = 0; u < m; u++) {
    		int rowCount = 0;
    		int colCount = 0;
    		for (int v = 0; v < n; v++) {

    			if (get(u, v) == turn) {
    				rowCount++;
    			}

    			if (get(v, u) == turn) {
    				colCount++;
    			}
      			if (get(u, v) == Cell.E) {
    				empty++;
    			}
    		}
    		if (rowCount == k || colCount == k) {
    			return Result.WIN;
    		}
    		if (get(u, u) == turn) {
    			diag1++;
    		}
    		if (get(u, k-1-u) == turn) { //min
    			diag2++;
    		}  
    	}

		if (diag1 == k || diag2 == k) {
			return Result.WIN;
		} else if (empty == 0) {
			return Result.DRAW;
		}

		turn = turn == Cell.X ? Cell.O : Cell.X;

		return Result.UNKNOWN;*/

	    int rowCount = 1;
	    int colCount = 1;
    	int posDia = 1;
	    int negDia = 1;
	    int x = move.getRow();
	    int y = move.getCol();
	    //System.err.println("k=" + k);
		for (int i = 1; rowCount<k; i++) {
	    	if ((x+i<m) && (y<n)) {
	        	if (get(x+i, y) == turn) {
					rowCount++;
				} else {
					break;
				}
			} else {
				break;
			}
			if (rowCount == k) {
				return Result.WIN;
			}
		}

	    for (int i = 1; rowCount<k; i++) {
	    	if ((x-i>=0) && (y>=0)) {
	        	if (get(x-i, y) == turn) {
					rowCount++;
				} else {
					break;
				}
			} else {
				break;
			}
			if (rowCount == k) {
				return Result.WIN;
			}
		}

		for (int i = 1; colCount<k; i++) {
	    	if ((x<m) && (y+i<n)) {
	        	if (get(x, y+i) == turn) {
					colCount++;
				} else {
					break;
				}
			} else {
				break;
			}
			if (colCount == k) {
				return Result.WIN;
			}
		}

	    for (int i = 1; colCount<k; i++) {
	    	if ((x>=0) && (y-i>=0)) {
	        	if (get(x, y-i) == turn) {
					colCount++;
				} else {
					break;
				}
			} else {
				break;
			}
			if (colCount == k) {
				return Result.WIN;
			}
		}

		for (int i = 1; posDia<k; i++) {
	    	if ((x+i<m) && (y+i<n)) {
	        	if (get(x+i, y+i) == turn) {
					posDia++;
				} else {
					break;
				}
			} else {
				break;
			}
			if (posDia == k) {
				return Result.WIN;
			}
		}

	    for (int i = 1; posDia<k; i++) {
	    	if ((x-i>=0) && (y-i>=0)) {
	        	if (get(x-i, y-i) == turn) {
					posDia++;
				} else {
					break;
				}
			} else {
				break;
			}
			if (posDia == k) {
				return Result.WIN;
			}
		}


		for (int i = 1; negDia<k; i++) {
			if ((x+i<m) && (y-i>=0)) {
	        	if (get(x+i, y-i) == turn) {
					negDia++;
				} else {
					break;
				}
			} else {
				break;	
			}
			if (negDia == k) {
				return Result.WIN;
			}
		}
	    //System.err.println("negDia=" + negDia);
		for (int i = 1; negDia<k; i++) {
			if ((x-i>=0) && (y+i<n)) {
	        	if (get(x-i, y+i) == turn) {
					negDia++;
				} else {
					break;
				}
			} else {
				break;
			}
			if (negDia == k) {
				return Result.WIN;
			}
		}
	    //System.err.println("negDia=" + negDia);
		if(empty <= 0) {
			return Result.DRAW;
		} 		

		turn = turn == Cell.X ? Cell.O : Cell.X;

		return Result.UNKNOWN;
    }
}