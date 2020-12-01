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
	int data = 0;
	int dataI[] = new int[12];
	
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
		//reader.mark(1);
		data = reader.read();
		if(data == -1) {
			//reader.reset();
			return false; 
		}
		//reader.reset();
		//System.err.println(data);
		return true;
	}

	public boolean hasNextInt() throws Exception {	
		//reader.mark(10 + 1);					//max exp of a number + sign
		data = reader.read();
		while(data == 10 || data == 32) {
			//reader.mark(10 + 1);
			data = reader.read();
			//System.err.println("spaceH");
		}
		if(data == -1) {
			//reader.reset();
			return false;
		}
		dataI[0] = data;
		//System.err.println(data);
		for(int i = 0; i < 11; i++) {
			//System.err.println("Sc " + dataI[i] + " " + i);
			if(dataI[i] == 32 || dataI[i] == 13 || dataI[i] == -1) {
				//System.err.println("sp");
				//reader.reset();
				return true;
			}			
			if((dataI[i] < 48 || dataI[i] > 57) && dataI[i] != 45) {
				//System.err.println("non int");
				//reader.reset();
				return false;
			}
			dataI[i+1] = reader.read();
		}
		//reader.reset();
		return true;			
	}

	public boolean hasNextLine() throws Exception {
		return hasNext();
	}

	public int nextInt() throws Exception {
		//System.err.println(dataI[1] + " one");
		//data = reader.read();
		int i = 0;
		int result = 0;
		byte sign = 1;
		//while(data == 10 || data == 32) {
			//data = reader.read();
			//System.err.println("space");
		//} 

		if(dataI[0] == 45) {
			sign = -1;
			i = 1;
		}
		for(; i < 11; i++) {
			//System.err.println(dataI[i] + " " + i);
			if(dataI[i] == 32 || dataI[i] == 13 || dataI[i] == -1) {
				return result*sign;
			}
			result = result * 10 + dataI[i] - 48;
			//dataI[i+1] = reader.read();			
		}
		return result*sign;			
	}


	public String nextLine() throws Exception {
		StringBuilder line = new StringBuilder();
		//int data = 0;
		//System.err.println(data);
		while (true) {
			if (data !=  13) {							// 	Carriage Return
				if (data ==  10 || data ==  -1) {		//Line Feed 
					return line.toString();
				}
            	line.append((char) data);
            	//System.err.println(data);					
			} 			
			data = reader.read();
			//System.err.print(data + " ");				
						
        }
	}
}