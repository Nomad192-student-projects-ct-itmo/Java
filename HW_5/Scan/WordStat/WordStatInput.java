import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
 
public class WordStatInput {
    public static void main(String[] args) {
        try {
    		String words = new String();
            LinkedHashMap <String, Integer> map = new LinkedHashMap <String, Integer>();
            Writer writer = new OutputStreamWriter(new FileOutputStream (args[1]), "utf-8");
            Scanner in = new Scanner(args[0], "utf-8");

            try {
                while (in.hasNext()) {
	                if (in.hasNextWord()) { 
                        words = in.nextWord();
	                    if(map.get(words.toLowerCase()) != null) {
	                        map.put(words.toLowerCase(), map.get(words.toLowerCase()) + 1);
	                    } else {
	                        map.put(words.toLowerCase(), 1);
	                    }   
	                } else {
                        in.next();
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