import java.io.*;
import java.util.*; //LinkedHashMap;
 
public class WordStatInput {
    public static void main(String[] args) {
        try {
    		StringBuilder words = new StringBuilder();
    		String line = " ";
            LinkedHashMap <String, Integer> map = new LinkedHashMap <String, Integer>();
            Writer writer = new OutputStreamWriter(new FileOutputStream (args[1]), "utf-8");
            Scanner in = new Scanner(args[0], "utf-8");

            try {
                while (in.hasNextLine()) {
                	line = in.nextLine();
                    char data;
                    for(int i=0; i<line.length(); i++) {
                    	data = line.charAt(i);
	                    if (Character.isAlphabetic(data) || Character.getType(data) == Character. DASH_PUNCTUATION || data == '\'') {
	                        words.append(data);
	                    } else {
	                        if (words.length() != 0) { 
	                            if(map.get(words.toString().toLowerCase()) != null) {
	                                map.put(words.toString().toLowerCase(), map.get(words.toString().toLowerCase()) + 1);
	                            } else {
	                                map.put(words.toString().toLowerCase(), 1);
	                            }
	                        }
	                        words.setLength(0);	
	                    } 
	                }
                    if (words.length() != 0) { 
                        if(map.get(words.toString().toLowerCase()) != null) {
                            map.put(words.toString().toLowerCase(), map.get(words.toString().toLowerCase()) + 1);
                        } else {
                            map.put(words.toString().toLowerCase(), 1);
                        }
                    }
                    words.setLength(0);            
                }
               

                if (words.length() != 0) {
                    if(map.get(words.toString().toLowerCase()) != null) {
                        map.put(words.toString().toLowerCase(), map.get(words.toString().toLowerCase()) + 1);
                    } else {
                        map.put(words.toString().toLowerCase(), 1);
                    }
                }

               
                for (Map.Entry entry : map.entrySet()) {
                    writer.write(entry.getKey() + " " + entry.getValue() + System.lineSeparator());
                } 
            } finally {
                in.close();
                writer.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
}