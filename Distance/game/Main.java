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
		int c =  0, quantity = 0;

		System.out.println("Enter c");
       	while (c < 1) {
        	while (!in.hasNextInt()) {
				System.err.println("Incorrect input, try again");
        		System.err.println("Enter new c");
				in.next();
				if (!in.hasNext()) {
					System.err.println("Input ended");
					in.close();
					return; 	
				}
        	}
			c = in.nextInt();
			if (c < 1) {
        		System.err.println("Parameter c cannot be less than one, try again");
        		System.err.println("Enter new number of players");					
			}
       	}

		System.out.println("Enter number of players");
       	while (quantity < 2) {
        	while (!in.hasNextInt()) {
				System.err.println("Incorrect input, try again");
        		System.err.println("Enter new number of players");
				in.next();
				if (!in.hasNext()) {
					System.err.println("Input ended");
					in.close();
					return; 	
				}
        	}
			quantity = in.nextInt();
			if (quantity < 2) {
        		System.err.println("The number of players cannot be less than two, try again");
        		System.err.println("Enter new number of players");					
			}
       	}


		final Game game = new Game(true);//new SequentialPlayer(m, n), new SequentialPlayer(m, n), true);
		//System.out.println("Game result: " + game.play(c, n));//new Board(m, n, k)));	
		game.play(c, quantity);
	}
}