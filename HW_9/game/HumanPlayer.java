package game;

import java.util.Scanner;

public class HumanPlayer implements Player {

	private final Scanner in;

	public HumanPlayer(final Scanner in) {
		this.in = in;
	}

	public HumanPlayer() {
		this(new Scanner(System.in));
	}

	int n;
	int k;

	public HumanPlayer(final int n, final int k) {
		this(new Scanner(System.in));
	}

	@Override
	public Move makeMove(final Position position, final Cell cell) {
	   	while (true) {
	   		System.out.println("Enter " + cell + "'s move");
			System.out.println("Row & Col:");

			int row=-1, col=-1;

			//while (n < 3) {
        	while (!in.hasNextInt()) {
				System.err.println("Incorrect input, try again");
        		System.err.println("Enter new row");
				in.next();
				if (!in.hasNext()) {
					System.err.println("Input ended");
					in.close();
					//return -1; 	
				}
        	}

			row = in.nextInt()-1;

			while (!in.hasNextInt()) {
				System.err.println("Incorrect input, try again");
        		System.err.println("Enter new col");
				in.next();
				if (!in.hasNext()) {
					System.err.println("Input ended");
					in.close();
					//return -1; 	
				}
        	}
			col = in.nextInt()-1;
				//if (n < 3) {
	        		//System.err.println("Parameter n cannot be less than one, try again");
	        		//System.err.println("Enter new n");					
				//}
	       	//}
		    //if(in.hasNextInt()) {
			//	row = in.nextInt()-1;
			//}

			//if(in.hasNextInt()) {
				//col = in.nextInt()-1;
			//}

			final Move move = new Move(row, col, cell);
			if (position.isValid(move)) {
				return move;
			}
			System.out.println("Invalid move: row " + (row + 1) + ", column " + (col + 1));
	   	}	
	}
}