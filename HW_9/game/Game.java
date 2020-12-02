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
		char[] players = new char[quantity];

		Scanner in = new Scanner(System.in);

		for (int i=0; i<quantity; i++) {
			System.err.println("Enter player " + (i+1) + ": [R/S/H]");
			while (players[i] != 'R' && players[i] != 'S' && players[i] != 'H') {
				if (!in.hasNext()) {
					System.err.println("Input ended");
					in.close();
					return -1; 	
				}

				players[i] = in.next().charAt(0);
				if (players[i] == 'r') {
					players[i] = 'R';
				}
				if (players[i] == 's') {
					players[i] = 'S';
				}
				if (players[i] == 'h') {
					players[i] = 'H';
				}

				if (players[i] != 'R' && players[i] != 'S' && players[i] != 'H') {
	        		System.err.println("The entered character does not match any type of gamer, please try again");
	        		System.err.println("Enter new player " + (i+1) + ": [R/S/H]");					
				}
	       	}
		} 

		int m = 0;
		int n = 0;
		int k = 0;

		for (int i=0; i<c; i++) {
			for (int j=0; j<quantity-1; j++) {
				for (int q=j+1; q<quantity; q++) {
					int result;
					//System.out.println("Enter m, n & k");

					//m = 0;
					//n = 0;
					//k = 0;

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
					Player player1;
					Player player2;


					if (players[j] == 'R'){
						player1 = new RandomPlayer();//(m, n);
					} else if (players[j] == 'S') {
						player1 = new SequentialPlayer();//(m, n);
					} else if (players[j] == 'H') {
						player1 = new HumanPlayer();
					} else {
						throw new AssertionError("Unknown player type " + players[j]);	
					}

					if (players[q] == 'R'){
						player2 = new RandomPlayer();//(m, n);
					} else if (players[q] == 'S') {
						player2 = new SequentialPlayer();//(m, n);
					} else if (players[q] == 'H') {
						player2 = new HumanPlayer();
					} else {
						throw new AssertionError("Unknown player type " + players[q]);	
					}

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

		System.out.println("Game result: \n");// + "points | player");
		int resi = 0, f = 0;
		for (int i=0; f<quantity; i++) {
			//System.out.println("i " + results[i] + " resi " + results[resi]);
			if (results[i] > results[resi]) {
				resi = i;
			} else if (results[i] == results[resi]) {
				if (resi > i) {
					resi = i;
				}
			}
			if (i + 1 == quantity) {
				System.out.println("points: " + results[resi] + " - player " + (resi+1) + " - " + players[resi]);
				results[resi] = -1;
				i = -1;
				f++;
			}
				
		}
		System.out.println();

		//in.close();

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