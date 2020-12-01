import java.util.LinkedList; 

public class ReverseAbc {
	public static void main(String[] args) { 
		LinkedList<String> dataBase = new LinkedList<>();
		LinkedList<Integer> lineBreak = new LinkedList<>();

		try{
			int n=0, qi=0, res=0, k=0;
			String str;
			StringBuilder subStr = new StringBuilder();
			char c;

        	Scanner in = new Scanner(System.in);

			while(in.hasNextLine()) {
				str = in.nextLine();
				qi=0;
 				for(int i=0; i<str.length(); i++) {
 					if(str.charAt(i) == ' ') {
 						if(k == 0) {
 							dataBase.add(subStr.toString());
 							subStr.setLength(0);
 							k++;
 							qi++;	
 						}
 					} else {
 						subStr.append(str.charAt(i));
 						k=0;
 					}
				}
				if(subStr.length() != 0) {
				 	dataBase.add(subStr.toString());
 					subStr.setLength(0);	
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
		} catch(Exception ex){
         	System.out.println(ex);
   		}
	}		
}
