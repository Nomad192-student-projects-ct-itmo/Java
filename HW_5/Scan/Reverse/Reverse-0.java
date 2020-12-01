import java.util.LinkedList; 

public class Reverse {
	public static void main(String[] args) { 
		LinkedList<Integer> dataBase = new LinkedList<>();
		LinkedList<Integer> lineBreak = new LinkedList<>();
		
		try {
			int n=0, qi=0, res=0;
			String subStr;
			Scanner in = new Scanner(System.in);
        	

			while(in.hasNextLine()) {
				subStr = in.nextLine();
				Scanner inStr = new Scanner(subStr);
				qi=0;
 				while(inStr.hasNextInt()) {
 					res = inStr.nextInt();
					dataBase.add(res);
					qi++;
				}
				lineBreak.add(qi);
				n++;
			}

        	for (int i=n-1; i>=0; i--) {
				for (int y=lineBreak.getLast()-1; y>=0; y--) {
					System.out.print(dataBase.getLast() + " ");
					dataBase.removeLast();
				} 
				lineBreak.removeLast();
				System.out.println();
			}
			in.close();
		} catch(Exception ex) {
         	ex.printStackTrace();
		}	
	}	
}
