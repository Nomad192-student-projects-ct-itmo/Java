package game;

import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		//final Board board = new Board();
		//System.out.println(board);
		/*System.out.println("Enter m, n & k");
		Scanner in = new Scanner(System.in);
		int m, n, k;
		m = in.nextInt();
		n = in.nextInt();
		k = in.nextInt();*/
		//System.out.println("Enter c & number of players");


		Scanner in = new Scanner(System.in);
		
		int quantityC = 0;


		System.out.println("Enter the number of tournaments");
       	while (quantityC < 1) {
        	while (!in.hasNextInt()) {
				System.err.println("Incorrect input, try again");
        		System.err.println("Enter new number of tournaments");
				in.next();
				if (!in.hasNext()) {
					System.err.println("Input ended");
					in.close();
					return; 	
				}
        	}
			quantityC = in.nextInt();
			if (quantityC < 1) {
        		System.err.println("The number of tournaments cannot be less than one, try again");
        		System.err.println("Enter new number of tournaments");					
			}
       	}

       	for(int i = 0; i<quantityC; i++)	{

       		int c =  0, quantityP = 0;

			System.out.println("Enter the number of laps for " + (i+1) + " tournament");
	       	while (c < 1) {
	        	while (!in.hasNextInt()) {
					System.err.println("Incorrect input, try again");
	        		System.err.println("Enter new number of laps for " + (i+1) + " tournament");
					if (!in.hasNext()) {
						System.err.println("Input ended");
						in.close();
						return; 	
					}
					in.next();
					if (!in.hasNext()) {
						System.err.println("Input ended");
						in.close();
						return; 	
					}
	        	}
				c = in.nextInt();
				if (c < 1) {
	        		System.err.println("The number of laps cannot be less than one, try again");
	        		System.err.println("Enter new number of laps for " + (i+1) + " tournament");					
				}
	       	}

			System.out.println("Enter the number of players for " + (i+1) + " tournament");
	       	while (quantityP < 2) {
	        	while (!in.hasNextInt()) {
					System.err.println("Incorrect input, try again");
	        		System.err.println("Enter new number of players for " + (i+1) + " tournament");
					in.next();
					if (!in.hasNext()) {
						System.err.println("Input ended");
						in.close();
						return; 	
					}
	        	}
				quantityP = in.nextInt();
				if (quantityP < 2) {
	        		System.err.println("The number of players cannot be less than two, try again");
	        		System.err.println("Enter new number of players for " + (i+1) + " tournament");					
				}
	       	}


			final Game game = new Game(true);//new SequentialPlayer(m, n), new SequentialPlayer(m, n), true);
			//System.out.println("Game result: " + game.play(c, n));//new Board(m, n, k)));	
			game.play(c, quantityP);

		}

		in.close();
	}
}