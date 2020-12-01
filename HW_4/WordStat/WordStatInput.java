import java.io.*;
import java.util.*; //LinkedHashMap;
 
public class WordStatInput {
    public static void main(String[] args) throws IOException {
        try {
    		StringBuilder words = new StringBuilder();
            LinkedHashMap <String, Integer> map = new LinkedHashMap <String, Integer>();
            Reader reader = new InputStreamReader( new FileInputStream(args[0]), "utf-8" );
            Writer writer = new OutputStreamWriter( new FileOutputStream (args[1]), "utf-8" );
            try {
                while (reader.ready()) {
                    int data = reader.read();
                    if (Character.isAlphabetic(data) || Character.getType(data) == Character. DASH_PUNCTUATION || (char) data == '\'') {
                        words.append((char) data);
                    } else {
                        if (words.length() != 0) { 
                            if(map.get(words.toString().toLowerCase()) != null) {
                                map.put(words.toString().toLowerCase(), map.get(words.toString().toLowerCase()) + 1);
                            } else {
                                map.put(words.toString().toLowerCase(), 1);
                            }
                        }
                        words.delete(0, words.length());
                    }             
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
                reader.close();
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("IOException  " + e.getMessage());
        } 
    }
}