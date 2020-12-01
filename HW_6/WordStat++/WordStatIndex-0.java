import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
 
public class WordStatIndex {
    public static void main(String[] args) {
        try {
    		StringBuilder words = new StringBuilder();
    		String line = " ";
            LinkedHashMap <String, Integer> map = new LinkedHashMap <String, Integer>();
            Writer writer = new OutputStreamWriter(new FileOutputStream (args[1]), "utf-8");
            Scanner in = new Scanner(args[0], "utf-8");
            int n = 1;
            int k = 1;
            int[][] a = new int[10000][10000];


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
	                                map.put(words.toString().toLowerCase(), map.get(words.toString().toLowerCase()));
	                                a[map.get(words.toString().toLowerCase())-1][0]++;
	                                a[map.get(words.toString().toLowerCase())-1][a[map.get(words.toString().toLowerCase())-1][0]] = k;
	                                k++;
	                            } else {
	                                map.put(words.toString().toLowerCase(), n);
	                                a[n-1][0] = 1;
	                                a[n-1][1] = k;
	                                //a[n-1][2] = n;
	                                n++;
	                                k++;
	                            }
	                        }
	                        words.setLength(0);	
	                    } 
	                }
                    if (words.length() != 0) { 
                        if(map.get(words.toString().toLowerCase()) != null) {
                            map.put(words.toString().toLowerCase(), map.get(words.toString().toLowerCase()));
	                        a[map.get(words.toString().toLowerCase())-1][0]++;
	                        a[map.get(words.toString().toLowerCase())-1][a[map.get(words.toString().toLowerCase())-1][0]] = k;
	                        k++;
                        } else {
                            map.put(words.toString().toLowerCase(), n);
	                        a[n-1][0] = 1;
	                        a[n-1][1] = k;
	                        //a[n-1][2] = n;
	                        n++;
	                        k++;
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

               	int i = 0;
                for (Map.Entry entry : map.entrySet()) {
                    writer.write(entry.getKey() + " " + (a[i][0])); //+ entry.getValue());//);
                    for(int j = 1; j <= a[i][0]; j++) {
                    	writer.write(" " + a[i][j]);
                    	//System.err.print(" " + i + " " + a[i][j] + " " + a[i][0] +"|");
                    }
                    //System.err.println();
                    writer.write(System.lineSeparator());
                    i++;
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