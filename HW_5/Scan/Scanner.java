import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.StringReader;
import java.io.InputStreamReader;
import java.io.File;
import java.util.LinkedList; 

public class Scanner {
	Reader reader;
	LinkedList<Integer> dataList = new LinkedList<>();

	private final int CARRIAGE_RETURN_CODE = 13;
	private final int       LINE_FEED_CODE = 10;
	private final int    END_OF_INPUT_CODE = -1;
	private final int            DASH_CODE = 45;
	private final int           SPACE_CODE = 32;
	private final int            ZERO_CODE = 48;
	private final int            NINE_CODE = 57;


	
	
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
		if(dataList.peekFirst() == END_OF_INPUT_CODE) {
				return false;	
			}
		}	
		if(dataList.peekFirst() == END_OF_INPUT_CODE) {
			return false; 
		}
		return true;
	}


	public boolean hasNextInt() throws Exception {
		if(dataList.peekFirst() == null) {
			dataList.add(reader.read());
		}
		while(dataList.peekFirst() == LINE_FEED_CODE 
			|| dataList.peekFirst() == SPACE_CODE 
			|| dataList.peekFirst() == CARRIAGE_RETURN_CODE) {
			dataList.remove();
			dataList.add(reader.read());	
		}
		if(dataList.peekFirst() == END_OF_INPUT_CODE) {
			return false;
		}
		for(int i = 0; i < 11; i++) {
			if(dataList.size() <= i) {
				dataList.add(reader.read());	
			}			
			if(dataList.get(i) == SPACE_CODE 
				|| dataList.get(i) == CARRIAGE_RETURN_CODE 
				|| dataList.get(i) == END_OF_INPUT_CODE 
				|| dataList.get(i) == LINE_FEED_CODE) {
				return true;
			}			
			if((dataList.get(i) < ZERO_CODE || dataList.get(i) > NINE_CODE) 
				&& dataList.get(i) != DASH_CODE) {
				return false;
			}
		}
		return true;	
	}


	public boolean hasNextWord() throws Exception {
	   	if(hasNext() 
	   		&& Character.isAlphabetic((char) dataList.peekFirst().intValue()) 
	   		|| Character.getType((char) dataList.peekFirst().intValue()) == Character. DASH_PUNCTUATION 
	   		|| (char) dataList.peekFirst().intValue() == '\'') {
	   		return true;
	   	}
		return false;
	}


	public boolean hasNextLine() throws Exception {
		return hasNext();
	}


	public boolean hasNextLF() throws Exception {
		if(dataList.peekFirst() == null) {
			dataList.add(reader.read());
		}
		while(dataList.peekFirst() == SPACE_CODE 
			|| dataList.peekFirst() == CARRIAGE_RETURN_CODE) {
			dataList.remove();
			dataList.add(reader.read());	
		}
		if(dataList.peekFirst() == LINE_FEED_CODE) {
			return true;
		}
		return false;
	}


	public boolean hasNextCharLF() throws Exception {
		if(dataList.peekFirst() == null) {
			dataList.add(reader.read());
		}
		if(dataList.peekFirst() == LINE_FEED_CODE) {
			return true;
		}
		return false;
	}




	public char next() throws Exception {
		char c;
		if(dataList.peekFirst() == null) {
			dataList.add(reader.read());
		}
		return (char) dataList.pollFirst().intValue();
	}


	public int nextInt() throws Exception {
		int i = 0;
		int result = 0;
		byte sign = 1;
		if(dataList.peekFirst() == null) {
			dataList.add(reader.read());
		}
		while(dataList.peekFirst() == LINE_FEED_CODE || dataList.peekFirst() == SPACE_CODE) {
			dataList.remove();
			dataList.add(reader.read());	
		}
		if(dataList.peekFirst() == DASH_CODE) {
			sign = -1;
			dataList.remove();
		}
		for(; i < 11; i++) {
			if (dataList.peekFirst() == null) { 
				dataList.add(reader.read());
			}
			if(dataList.peekFirst() == SPACE_CODE 
				|| dataList.peekFirst() == CARRIAGE_RETURN_CODE 
				|| dataList.peekFirst() == END_OF_INPUT_CODE 
				|| dataList.peekFirst() == LINE_FEED_CODE) {
				return result*sign;
			}
			result = result * LINE_FEED_CODE + dataList.peekFirst() - ZERO_CODE;
			dataList.remove();		
		}
		return result*sign;			
	}


	public String nextWord() throws Exception {
		StringBuilder line = new StringBuilder();
		if(dataList.peekFirst() == null) {
			dataList.add(reader.read());
		}
		while(dataList.peekFirst() == LINE_FEED_CODE || dataList.peekFirst() == SPACE_CODE) {
			dataList.remove();
			dataList.add(reader.read());	
		}
		int i = 0;
	   	while (true) {
			if (dataList.peekFirst() == null) { 
				dataList.add(reader.read());
			}
			if (Character.isAlphabetic((char) dataList.peekFirst().intValue()) 
				|| Character.getType((char) dataList.peekFirst().intValue()) == Character. DASH_PUNCTUATION 
				|| (char) dataList.peekFirst().intValue() == '\'') {
				line.append((char) dataList.pollFirst().intValue());
			} else {
				dataList.remove();
				return line.toString();
			}
			i++;
	   	}			
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
			if (dataList.peekFirst() !=  CARRIAGE_RETURN_CODE) {							
				if (dataList.peekFirst() ==  LINE_FEED_CODE || dataList.peekLast() ==  END_OF_INPUT_CODE) {
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