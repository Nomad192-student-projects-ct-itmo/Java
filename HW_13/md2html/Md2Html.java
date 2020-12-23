package md2html;

import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Md2Html  {

	public static Result getLine (StringBuffer result, int num, 
										String line, boolean c, 
										int em, int emz, int strong, 
										int strongz, int s, int m) {

		//StringBuffer result = new StringBuffer ();


		for (int i = num; i < line.length(); i++) {
			if (line.charAt(i) == '`') {
				if (c) {
					result.append("</code>");	
				} else {
					result.append("<code>");
				}
				c = !c;

			} else if (line.charAt(i) == '<') {
				result.append("&lt;");
			} else if (line.charAt(i) == '>') {
				result.append("&gt;");
			} else if (line.charAt(i) == '&') {
				result.append("&amp;");
			} else if (line.charAt(i) == '\\') {
				i++;
				result.append(line.charAt(i));
			} else if (line.charAt(i) == '_') {
				if (i == line.length()-1) {
					if (em == -1) {
						em = result.length();	
					} else {
						result.insert(em, "<em>");
						result.append("</em>");	
						em = -1;
					}	

				} else {
					if (line.charAt(i+1) == '_') {
						i++;
						if (strong == -1) {
							strong = result.length();	
						} else {
							result.insert(strong, "<strong>");
							result.append("</strong>");	
							strong = -1;
						}

					} else {
						if (em == -1) {
							em = result.length();	
						} else {
							result.insert(em, "<em>");
							result.append("</em>");	
							em = -1;
						}
					}
				}

			} else if (line.charAt(i) == '*') {
				if (i == line.length()-1) {
					if (emz == -1) {
						emz = result.length();	
					} else {
						result.insert(emz, "<em>");
						result.append("</em>");	
						emz = -1;
					}

				} else {
					if (line.charAt(i+1) == '*') {
						i++;
						if (strongz == -1) {
							strongz = result.length();	
						} else {
							result.insert(strongz, "<strong>");
							result.append("</strong>");	
							strongz = -1;
						}

					} else {
						if (emz == -1) {
							emz = result.length();	
						} else {
							result.insert(emz, "<em>");
							result.append("</em>");	
							emz = -1;
						}
					}
				}
			} else if (line.charAt(i) == '-') {
				if (i < line.length()-1) {
					if (line.charAt(i+1) == '-') {
						i++;
						if (s == -1) {
							s = result.length();	
						} else {
							result.insert(s, "<s>");
							result.append("</s>");	
							s = -1;
						}
					} else {
						result.append("-");
					}
				} else {
					result.append("-");
				}

			} else if (line.charAt(i) == '~') {
				if (m == -1) {
					m = result.length();	
				} else {
					result.insert(m, "<mark>");
					result.append("</mark>");	
					m = -1;
				}	
			} else {
				result.append(line.charAt(i));	
			}
		}	

		return new Result (result, c, em, emz, strong, strongz, s, m);
	}

	static class Result {

		boolean c = false;
		int em = -1;
		int emz = -1;
		int strong = -1;
		int strongz = -1;
		int s = -1;
		int m = -1;

		StringBuffer result = new StringBuffer ();

		public Result (StringBuffer result, boolean c, 
						int em, int emz, int strong, 
						int strongz, int s, int m) {

			this.result = result;
			this.c = c;
			this.em = em;
			this.emz = emz;
			this.strong = strong;
			this.strongz = strongz;
			this.s = s;
			this.m = m;
		}
	}

	public static String getPar (int k, String line, Scanner in) {

		Result r;

		/*StringBuffer result = new StringBuffer ();

		boolean c = false;
		int em = -1;
		int emz = -1;
		int strong = -1;
		int strongz = -1;
		int s = -1;

		int j = 0;*/

		//result.append(getLine(k+1, line, c, em, emz, strong, strongz, s, j));
		//System.out.print(r.j + " ");
		r = getLine(new StringBuffer(), k+1, line, false, -1, -1, -1, -1, -1, -1);
		//System.err.println(r.emz);
		while (in.hasNextLine()) {
			line = in.nextLine();
			if (line.length() > 0) {
				r.result.append(System.lineSeparator());
				//System.out.println(r.strong + " ");
				//System.err.println(r.j);
				//result.append(getLine(0, line, c, em, emz, strong, strongz, s, j));
				r = getLine(r.result, 0, line, r.c, 
							r.em, r.emz, r.strong, 
							r.strongz, r.s, r.m);

			} else {
				break;
			}
		}

		if (r.em != -1) {
			r.result.insert(r.em, "_");	
		}

		if (r.emz != -1) {
			r.result.insert(r.emz, "*");
		}

		//System.err.println(r.emz);

		return r.result.toString();
	}

	public static void main(String[] args) {

		try {

			Scanner in = new Scanner(new File (args[0]), "utf-8");
			Writer out = new OutputStreamWriter(new FileOutputStream (args[1]), "utf-8");
			
			try {
				String line = new String();
				StringBuffer result = new StringBuffer ();
				StringBuffer reserv = new StringBuffer ();

				while (in.hasNextLine()) {

					line = in.nextLine();
					//result.append('<');

					while (line.length() == 0 && in.hasNextLine()) {
						line = in.nextLine();
					}

					//System.out.print(line + System.lineSeparator());
					//boolean c = false;

					int k = 0;

					while (line.charAt(k) == '#') {
						k++;
					}

					if (k > 0 && line.charAt(k) == ' ') {

						//result.append('h');

						//result.append('<h');
						result.append("<h" + (char)(k + '0') + '>');
						result.append(getPar(k, line, in));
						result.append("</h" + (char)(k + '0') + '>');
						//System.out.println(k);
	 						
					} else {
						result.append("<p>");
						result.append(getPar(-1, line, in));
						result.append("</p>");
					}

					System.out.print(result + System.lineSeparator());
					out.write(result + System.lineSeparator());
					result.setLength(0);
					reserv.setLength(0);
				}


			} finally {
                in.close();
                out.close();
        	}

		} catch (FileNotFoundException e) {

			System.err.println("File not found:");
        	e.printStackTrace();

    	} catch (IOException e) {

            System.err.println("IOException found:");
            e.printStackTrace();

        } 

        //for (Map.Entry entry : map.entrySet()) {
			
        //}
    }
}
