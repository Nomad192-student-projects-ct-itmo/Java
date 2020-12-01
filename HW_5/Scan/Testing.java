//import java.io.*;
//import java.util.*; //LinkedHashMap;
import java.io.FileInputStream;

public class Testing {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);//System.in);//" 123");//
		String s = " ";
		while(sc.hasNextWord()) {
			s = sc.nextWord();
			System.out.println(s + " m");
		}

        
        sc.close();
    }
    	
}