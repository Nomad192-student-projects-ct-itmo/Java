import java.util.*;
 
public class ReverseMax {
	public static void main(String[] args) { 
		int[] lineBreak = new int[1000000];
		int[] maxqi = new int[1000000];
		int[] maxndb = new int[1000000];

		int n=0, qi=0, f, maxn=0;
		String subStr;

        		Scanner in = new Scanner(System.in);

		while(in.hasNextLine()) {
			subStr = in.nextLine();
			Scanner inStr = new Scanner(subStr);
			qi=0;
 			while(inStr.hasNextInt()) {
				f=inStr.nextInt();
				if(qi>=maxn) {
					maxndb[qi]=f;
				}
				if(qi==0) {
					maxqi[n]=f;
				}
				if(maxqi[n]<f) {
					maxqi[n]=f;
				}
				if(maxndb[qi]<f) {
					maxndb[qi]=f;
				}
				qi++;
			}
			if (maxn<qi) {
				maxn=qi;

			}
			lineBreak[n] = qi;
			n++;
		}

				
          		for (int i=0; i<n; i++) {
			for (int y=0; y<lineBreak[i]; y++) {
				if(maxndb[y]>=maxqi[i]) {
					System.out.print(maxndb[y] + " ");
				} else {
					System.out.print(maxqi[i] + " ");
				}
			} 
			System.out.println();
		}
    	}
}