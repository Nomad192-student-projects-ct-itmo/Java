import java.util.*;
 
public class Reverse {
	public static void main(String[] args) { 
		Vector<Integer> dataBase = new Vector<Integer>();
		Vector<Integer> lineBreak = new Vector<Integer>();

		int n=0, qi=0, qin=0;
		String subStr;

        	Scanner in = new Scanner(System.in);

		while(in.hasNextLine()) {
			subStr = in.nextLine();
			Scanner inStr = new Scanner(subStr);
			qi=0;
 			while(inStr.hasNextInt()) {
				dataBase.addElement(inStr.nextInt());
				qi++;
				qin++;
			}
			lineBreak.addElement(qi);
			n++;
		}

          	for (int i=n-1; i>=0; i--) {
			for (int y=lineBreak.lastElement()-1; y>=0; y--) {
				System.out.print(dataBase.lastElement() + " ");
				qin--;
				dataBase.remove(qin);
			} 
			lineBreak.remove(i);
			System.out.println();
		}
    	}
}