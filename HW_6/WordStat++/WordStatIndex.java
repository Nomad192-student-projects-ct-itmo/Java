import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
 
public class WordStatIndex {
    public static void main(String[] args) {
        try {
            String words = new String();
            LinkedHashMap <String, Integer>          map = new LinkedHashMap <String, Integer>();
            LinkedHashMap <String, StringBuilder> mapPos = new LinkedHashMap <String, StringBuilder>();
            Writer writer = new OutputStreamWriter(new FileOutputStream (args[1]), "utf-8");
            Scanner in = new Scanner(args[0], "utf-8");
            int n = 1;
            StringBuilder line = new StringBuilder(); 

            try {
                while (in.hasNext()) {
                    if (in.hasNextWord()) { 
                        words = in.nextWord();
                        if(map.get(words.toLowerCase()) != null) {
                            map.put(words.toLowerCase(), map.get(words.toLowerCase()) + 1);
                            mapPos.put(words.toLowerCase(), mapPos.get(words.toLowerCase()).append(" " + n));
                        } else {
                            map.put(words.toLowerCase(), 1);
                            mapPos.put(words.toLowerCase(), new StringBuilder());
                            mapPos.put(words.toLowerCase(), mapPos.get(words.toLowerCase()).append(n));
                        } 
                        n++;  
                    } else {
                        in.next();
                    }               
                }


                for (Map.Entry entry : mapPos.entrySet()) {
                    writer.write(entry.getKey() + " " + map.get(entry.getKey()) + " " + entry.getValue() + System.lineSeparator());
                } 
            } finally {
                in.close();
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}