package game;

import java.util.Scanner;

public class Game {// implements Position {
	//private final Player player1;
	//private final Player player2;
	private final boolean enableLogging;

	/*public Game(final Player player1, final Player player2, final boolean enableLogging) {
		this.enableLogging = enableLogging;
		this.player1 = player1;
		this.player2 = player2;
	}*/

	public Game(final boolean enableLogging) {
		this.enableLogging = enableLogging;
	}

	public int play(final int c, final int quantity) {//final Board board) {
		int[] results = new int[quantity];

		for (int i=0; i<c; i++) {
			for (int j=0; j<quantity-1; j++) {
				for (int q=j+1; q<quantity; q++) {
					int result;
					Scanner in = new Scanner(System.in);
					//System.out.println("Enter m, n & k");
					int m = 0;
					int n = 0;
					int k = 0;

					System.out.println("Enter m, n & k");
			       	while (m < 3) {
			        	while (!in.hasNextInt()) {
							System.err.println("Incorrect input, try again");
			        		System.err.println("Enter new m");
							in.next();
							if (!in.hasNext()) {
								System.err.println("Input ended");
								in.close();
								return -1; 	
							}
			        	}
						m = in.nextInt();
						if (m < 3) {
			        		System.err.println("Parameter m cannot be less than three, try again");
			        		System.err.println("Enter new m");					
						}
			       	}
			       	//System.out.println("Enter n");
			       	while (n < 3) {
			        	while (!in.hasNextInt()) {
							System.err.println("Incorrect input, try again");
			        		System.err.println("Enter new n");
							in.next();
							if (!in.hasNext()) {
								System.err.println("Input ended");
								in.close();
								return -1; 	
							}
			        	}
						n = in.nextInt();
						if (n < 3) {
			        		System.err.println("Parameter n cannot be less than three, try again");
			        		System.err.println("Enter new n");					
						}
			       	}
			       	//System.out.println("Enter k");
			       	while (k < 2) {
			        	while (!in.hasNextInt()) {
							System.err.println("Incorrect input, try again");
			        		System.err.println("Enter new k");
							in.next();
							if (!in.hasNext()) {
								System.err.println("Input ended");
								in.close();
								return -1; 	
							}
			        	}
						k = in.nextInt();
						if (k < 2) {
			        		System.err.println("Parameter k cannot be less than two, try again");
			        		System.err.println("Enter new k");					
						}
			       	}

					final Board board = new Board(m, n, k);
					final Player player1 = new HumanPlayer();
					final Player player2 = new HumanPlayer();
					while (true) {
						result = makeMove(board, player1, 1); //this.player1
						if (result >= 0) {
							break;
						}

						result = makeMove(board, player2,  2); //this.player2
						if (result >= 0) {
							break;
						}
					}

					//System.out.println("\nFinal position:");
					System.out.println(board);

					if (result == 1) {
						results[j]+=3;
						System.out.println("Game result: player " + (j+1) + " won, player points: " + results[j]);
					} else if (result == 2) {
						results[q]+=3;
						System.out.println("Game result: player " + (q+1) + " won, player points: " + results[q]);		
					} else if (result == 0) {
						
						results[j]+=1;
						results[q]+=1;
						System.out.println("Game result: draw, player " + (j+1) + 
						 			" points: " + results[j] + 
						 			", and player " + (q+1) + 
						 			" points: " + results[q]);
					}

		//return result;			
				}
			}
		}

		System.out.println("Game result: \n");
		for (int i=0; i<quantity; i++) {
			System.out.println("player " + (i+1) + " result: " + results[i] + '\n');
		}
		return 0;
	}

	public int makeMove(final Board board, final Player player, final int no) {
		if (enableLogging) {
			System.out.println(board);
		}
		final Move move = player.makeMove(board, board.getTurn());	
			
		if (enableLogging) {
			System.out.println("\nMove: " + move);
		}
		
		final Result result = board.makeMove(move);

		if (result == Result.WIN) {
			return no;
		} else if (result == Result.LOSE) {
			return no; // Not //(3 - no);
		} else if (result == Result.DRAW) {
			return 0;
		} else if (result == Result.UNKNOWN) {
			return -1;
		} else {
			throw new AssertionError("Unknown result type " + result);
		}	

	}
}