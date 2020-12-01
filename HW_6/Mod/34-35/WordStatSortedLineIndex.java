import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.util.TreeMap;
import java.util.Map;
 
public class WordStatSortedLineIndex {
    public static void main(String[] args) {
        try {
            String words = new String();
            TreeMap <String, Integer>          map = new TreeMap <String, Integer>();
            TreeMap <String, StringBuilder> mapPos = new TreeMap <String, StringBuilder>();
            Writer writer = new OutputStreamWriter(new FileOutputStream (args[1]), "utf-8");
            Scanner in = new Scanner(args[0], "utf-8");
            int n = 1;
            int k = 1;
            StringBuilder line = new StringBuilder(); 

            try {
                while (in.hasNext()) {
                    if (in.hasNextWord()) { 
                        words = in.nextWord();
                        if(map.get(words.toLowerCase()) != null) {
                            map.put(words.toLowerCase(), map.get(words.toLowerCase()) + 1);
                            mapPos.put(words.toLowerCase(), mapPos.get(words.toLowerCase()).append(" " + k + ":" + n));
                        } else {
                            map.put(words.toLowerCase(), 1);
                            mapPos.put(words.toLowerCase(), new StringBuilder());
                            mapPos.put(words.toLowerCase(), mapPos.get(words.toLowerCase()).append(k + ":" + n));
                        } 
                        n++;
                        
                    } else if (in.hasNextCharLF()) {
                        n = 1;
                        k++;
                        in.next();       
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