import java.util.*;
 
public class ReverseMin {
	public static void main(String[] args) { 
		int[] lineBreak = new int[1000000];
		int[] minqi = new int[1000000];
		int[] minndb = new int[1000000];

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
					minndb[qi]=f;
				}
				if(qi==0) {
					minqi[n]=f;
				}
				if(minqi[n]>f) {
					minqi[n]=f;
				}
				if(minndb[qi]>f) {
					minndb[qi]=f;
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
				if(minndb[y]<=minqi[i]) {
					System.out.print(minndb[y] + " ");
				} else {
					System.out.print(minqi[i] + " ");
				}
			} 
			System.out.println();
		}
    	}
}