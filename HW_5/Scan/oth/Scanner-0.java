/*
import java.io.Reader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.BufferedReader;//*/

import java.io.Reader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.StringReader;
import java.io.File;

public class Scanner {
	Reader reader;// = new BufferedReader(new InputStreamReader(System.in));
	
    public Scanner(InputStream in) throws IOException {
        reader = new BufferedReader(new InputStreamReader(in));
    }

    public Scanner(String file, String encoding) throws IOException {
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file)), encoding));
    }

    public Scanner(String s) {
        reader = new BufferedReader(new StringReader(s));
    }


    public void close() throws IOException {
        reader.close();
    }

	public boolean hasNext() throws Exception {
		reader.mark(1);
		if(reader.read() == -1) {
			reader.reset();
			return false; 
		}
		reader.reset();
		return true;
	}

	public boolean hasNextInt() throws Exception {	
		reader.mark(10 + 1);					//max exp of a number + sign
		int data = reader.read();
		while(data == 10 || data == 32) {
			reader.mark(10 + 1);
			data = reader.read();
			//System.err.println("spaceH");
		}
		if(data == -1) {
			reader.reset();
			return false;
		}
		//System.err.println(data);
		for(int i = 0; i < 11; i++) {
			//System.err.println("Sc" + data);
			if(data == 32 || data == 13 || data == -1) {
				//System.err.println("sp");
				reader.reset();
				return true;
			}			
			if((data < 48 || data > 57) && data != 45) {
				//System.err.println("non int");
				reader.reset();
				return false;
			}
			data = reader.read();
		}
		reader.reset();
		return true;			
	}

	public boolean hasNextLine() throws Exception {
		return hasNext();
	}

	public int nextInt() throws Exception {
		int data = reader.read();
		int result = 0;
		byte sign = 1;
		while(data == 10 || data == 32) {
			data = reader.read();
			//System.err.println("space");
		} 
		if(data == 45) {
			sign = -1;
			data = reader.read();
		}
		for(int i = 0; i < 11; i++) {
			//System.err.println(data);
			if(data == 32 || data == 13 || data == -1) {
				return result*sign;
			}
			result = result * 10 + data - 48;
			data = reader.read();			
		}
		return result*sign;			
	}


	public String nextLine() throws Exception {
		StringBuilder line = new StringBuilder();
		int data = 0;
		while (true) {
			data = reader.read();
			//System.err.print(data + " ");				
			if (data !=  13) {							// 	Carriage Return
				if (data ==  10 || data ==  -1) {		//Line Feed 
					return line.toString();
				}
            	line.append((char) data);
            	//System.err.println(data);					
			} 						
        }
	}
}