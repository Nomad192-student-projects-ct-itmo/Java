import java.util.Scanner;
import java.util.*;

public class GameMNK {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int kpl=-1, c=-1;

    	while (kpl<=0) {
        	while (!in.hasNextInt()) {
				System.err.println("incorrect input");
				System.err.println("enter new width");
				in.next();
				if (!in.hasNext()) {
					System.err.println("input ended");
					in.close();
					return; 	
				}
        	}
			kpl = in.nextInt();
			if (kpl<=0) {
				System.err.println("incorrect input");
				System.err.println("enter new width");						
			}	
       	}

       	while (c<=0) {
        	while (!in.hasNextInt()) {
				System.err.println("incorrect input");
				System.err.println("enter new width");
				in.next();
				if (!in.hasNext()) {
					System.err.println("input ended");
					in.close();
					return; 	
				}
        	}
			c = in.nextInt();
			if (c<=0) {
				System.err.println("incorrect input");
				System.err.println("enter new width");						
			}	
       	}

       	int[] tablу = new int[kpl];

       	for (int l=0; l < c; l++)	{
       		for (int p1=0; p1 < kpl-1; p1++) {
       			for (int p2=p1+1; p1 < kpl; p2++) { 
					int m=-1, n=-1, k=-1;
					int j=0;

			    	while (m<=0) {
			        	while (!in.hasNextInt()) {
							System.err.println("incorrect input");
							System.err.println("enter new width");
							in.next();
							if (!in.hasNext()) {
								System.err.println("input ended");
								in.close();
								return; 	
							}
			        	}
						m = in.nextInt();
						if (m<=0) {
							System.err.println("incorrect input");
							System.err.println("enter new width");						
						}	
			       	}

			    	while (n<=0) {
			        	while (!in.hasNextInt()) {
							System.err.println("incorrect input");
							System.err.println("enter new length");
							in.next();
							if (!in.hasNext()) {
								System.err.println("input ended");
								in.close();
								return; 	
							}
			        	}
						n = in.nextInt();
						if (n<=0) {
							System.err.println("incorrect input");
							System.err.println("enter new length");						
						}	
			       	}

			       	while (k<=0 || k > (m < n ? m : n)) {
			        	while (!in.hasNextInt()) {
							System.err.println("incorrect input");
							System.err.println("enter new row length");
							in.next();
							if (!in.hasNext()) {
								System.err.println("input ended");
								in.close();
								return; 	
							}
			        	}
						k = in.nextInt();
						if (k<=0) {
							System.err.println("incorrect input");
							System.err.println("enter new row length");						
						}
						if (k > (m < n ? m : n)) {
			            	System.err.println("impossible row length condition");
			            	System.err.println("enter new row length");					
						}	
			       	}

			        int[][] field = new int[m][n];

			        boolean end = false;
			        boolean color = false;

			        int x=-1, y=-1;
			        int pos = 1, neg = 1;
			        
			        while (!end) {
			        	x=-1; 
			        	y=-1;
				       	while (x<0 || (x > m - 1)) {
				        	while (!in.hasNextInt()) {
								System.err.println("incorrect input");
			            		System.err.println("enter new x coordinates");
								in.next();
								if (!in.hasNext()) {
									System.err.println("input ended");
									in.close();
									return; 	
								}
				        	}
							x = in.nextInt();
							if (x<0 || (x > m - 1)) {
			            		System.err.println("point is out of field");
			            		System.err.println("enter new x coordinates");					
							}
				       	}

				       	while (y<0 || (y > n - 1)) {
				        	while (!in.hasNextInt()) {
								System.err.println("incorrect input");
			            		System.err.println("enter new y coordinates");
								in.next();
								if (!in.hasNext()) {
									System.err.println("input ended");
									in.close();
									return; 	
								}
				        	}
							y = in.nextInt();
							if (y<0 || (y > n - 1)) {
			            		System.err.println("point is out of field");
			            		System.err.println("enter new y coordinates");					
							}
				       	}

			            if (field[x][y] != 0) {
			            	while (field[x][y] != 0) {
			            		System.err.println("the cell is already occupied");
			            		System.err.println("enter new coordinates");
			            		x=-1;
			            		y=-1;
						       	while (x<0 || (x > m - 1)) {
						        	while (!in.hasNextInt()) {
										System.err.println("incorrect input");
					            		System.err.println("enter new x coordinates");
										in.next();
										if (!in.hasNext()) {
											System.err.println("input ended");
											in.close();
											return; 	
										}
						        	}
									x = in.nextInt();
									if (x<0 || (x > m - 1)) {
					            		System.err.println("point is out of field");
					            		System.err.println("enter new x coordinates");					
									}
						       	}

						       	while (y<0 || (y > n - 1)) {
						        	while (!in.hasNextInt()) {
										System.err.println("incorrect input");
					            		System.err.println("enter new y coordinates");
										in.next();
										if (!in.hasNext()) {
											System.err.println("input ended");
											in.close();
											return; 	
										}
						        	}
									y = in.nextInt();
									if (y<0 || (y > n - 1)) {
					            		System.err.println("point is out of field");
					            		System.err.println("enter new y coordinates");					
									}
						       	}
			            	}
			            }


			            field[x][y] = (color ? 1:0) + 1;


			            for (int i = 1; pos<k; i++) {
			            	if ((x+i<m) && (y+i<n)) {
				            	if (field[x+i][y+i] == 1 + (color ? 1:0)) {
				    				pos++;
				    			} else {
				    				break;
				    			}
			    			} else {
			    				break;
			    			}
			    			if (pos == k) {
			    				end = true;
			    			}
			    		}

			            for (int i = 1; pos<k; i++) {
			            	if ((x-i>=0) && (y-i>=0)) {
				            	if (field[x-i][y-i] == 1 + (color ? 1:0)) {
				    				pos++;
				    			} else {
				    				break;
				    			}
				    		} else {
				    			break;
				    		}
			    			if (pos == k) {
			    				end = true;
			    			}
			    		}


			    		for (int i = 1; neg<k; i++) {
			    			if ((x+i<m) && (y-i>=0)) {
				            	if (field[x+i][y-i] == 1 + (color ? 1:0)) {
				    				neg++;
				    			} else {
				    				break;
				    			}
				    		} else {
				    			break;	
				    		}
			    			if (neg == k) {
			    				end = true;
			    			}
			    		}

			    		for (int i = 1; neg<k; i++) {
			    			if ((x-i>=0) && (y+i<n)) {
				            	if (field[x-i][y+i] == 1 + (color ? 1:0)) {
				    				neg++;
				    			} else {
				    				break;
				    			}
			    			} else {
			    				break;
			    			}
							if (neg == k) {
			    				end = true;
			    			}
			    		}

			            pos = 1;
			            neg = 1;
			            color = !color; 
			            j++; 
			            if(j >= m*n) {
			            	System.err.println("game over, no winner");
			            	end = true;
			            	in.close();
			            	return;
			            }         
			        }
			        in.close();
			        System.out.println("game over, winner " + ((!color ? 1:0) + 1));
		        }       			
       		}
       	} 
       	System.out.println(table);
    }
}
