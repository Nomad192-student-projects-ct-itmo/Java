import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.StringReader;
import java.io.InputStreamReader;
import java.io.File;
import java.util.LinkedList; //LinkedHashMap;

//------------------------------
//       13 - Carriage Return
//       10 - Line Feed
//       -1 - End Of Input
//       45 - Dash
//       32 - Space 
// [48, 57] - Numerals
//------------------------------

public class Scanner {
	Reader reader;
	LinkedList<Integer> dataList = new LinkedList<>();
	
    public Scanner(InputStream in) throws Exception {
        reader = new BufferedReader(new InputStreamReader(in));
    }

    public Scanner(String file, String encoding) throws Exception {
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file)), encoding));
    }

    public Scanner(String s) {
        reader = new BufferedReader(new StringReader(s));
    }


    public void close() throws Exception {
        reader.close();
    }

	public boolean hasNext() throws Exception {
		if(dataList.peekFirst() == null) {
			dataList.add(reader.read());
			if(dataList.peekFirst() == -1) {
				return false;	
			}
		}	
		if(dataList.peekFirst() == -1) {
			return false; 
		}
		return true;
	}

	public boolean hasNextInt() throws Exception {
		if(dataList.peekFirst() == null) {
			dataList.add(reader.read());
		}
		while(dataList.peekFirst() == 10 || dataList.peekFirst() == 32) {
			dataList.remove();
			dataList.add(reader.read());	
			
		}
		if(dataList.peekFirst() == -1) {
			return false;
		}
		for(int i = 0; i < 11; i++) {
			if(dataList.size() <= i) {
				dataList.add(reader.read());	
			}			
			if(dataList.get(i) == 32 || dataList.get(i) == 13 || dataList.get(i) == -1) {
				return true;
			}			
			if((dataList.get(i) < 48 || dataList.get(i) > 57) && dataList.get(i) != 45) {
				return false;
			}
		}
		return true;	
	}

	

	public boolean hasNextLine() throws Exception {
		return hasNext();
	}

	public int nextInt() throws Exception {
		int i = 0;
		int result = 0;
		byte sign = 1;
		if(dataList.peekFirst() == null) {
			dataList.add(reader.read());
		}
		if(dataList.peekFirst() == 45) {
			sign = -1;
			dataList.remove();
		}
		for(; i < 11; i++) {
			if (dataList.peekFirst() == null) { 
				dataList.add(reader.read());
			}
			if(dataList.peekFirst() == 32 || dataList.peekFirst() == 13 || dataList.peekFirst() == -1) {
				return result*sign;
			}
			result = result * 10 + dataList.peekFirst() - 48;
			dataList.remove();		
		}
		return result*sign;			
	}


	public String nextLine() throws Exception {
		StringBuilder line = new StringBuilder();
		if(dataList.peekFirst() == null) {
			dataList.add(reader.read());
		}
		while (true) {
			if (dataList.peekFirst() == null) { 
				dataList.add(reader.read());
			}
			if (dataList.peekFirst() !=  13) {							
				if (dataList.peekFirst() ==  10 || dataList.peekLast() ==  -1) {
					dataList.remove();	
					return line.toString();
				}
	            line.append((char) dataList.pollFirst().intValue());			
			} else {
				dataList.remove();
			}			
        }
	}

}