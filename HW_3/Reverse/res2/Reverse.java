import java.util.*;
 
public class Reverse {
	public static void main(String[] args) { 
		int[] dataBase = new int[1000000];
		int[] lineBreak = new int[1000000];

		int n=0, qi=0, qin=0;
		String subStr;

        	Scanner in = new Scanner(System.in);

		while(in.hasNextLine()) {
			subStr = in.nextLine();
			Scanner inStr = new Scanner(subStr);
			qi=0;
 			while(inStr.hasNextInt()) {
				dataBase[qin] = inStr.nextInt();
				qi++;
				qin++;
			}
			lineBreak[n] = qi;
			n++;
		}

          	for (int i=n-1; i>=0; i--) {
			for (int y=lineBreak[i]-1; y>=0; y--) {
				qin--;
				System.out.print(dataBase[qin] + " ");
			} 
			System.out.println();
		}
    	}
}