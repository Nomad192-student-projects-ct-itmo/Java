import java.util.LinkedList; 

public class Reverse {
	public static void main(String[] args) { 
		LinkedList<Integer> dataBase = new LinkedList<>();
		LinkedList<Integer> lineBreak = new LinkedList<>();
		
		try {
			int n=0, qi=0;
			Scanner in = new Scanner(System.in);
        	
			while(in.hasNextLF()) {
				lineBreak.add(qi);
				n++;
				in.next();			
			}
			while(in.hasNextInt()) {					
				dataBase.add(in.nextInt());
				qi++;
				while(in.hasNextLF()) {
					lineBreak.add(qi);
					n++;
					qi=0;	
					in.next();		
				}
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
		} catch(Exception e) {
         	System.out.println(e);
		}	
	}	
}
