import java.util.Scanner;
import java.util.LinkedHashMap;

public class M {
	public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t=in.nextInt();
    while(t>0){
      int n=in.nextInt();
      int[] a = new int[n+1];
      int c=0;
      LinkedHashMap <Integer, Integer> map = new LinkedHashMap <Integer, Integer>();
      for(int i=0; i<n; i++)
        a[i]=in.nextInt();

      map.put(a[n-1], 1);

      for(int j=n-2; j>0; j--) {
        for(int i=0; i<j; i++) {
          if(map.get(2*a[j]-a[i]) != null) {
            c+=map.get(2*a[j]-a[i]);
          }
          //if(a[j+1]==2*a[j]-a[i])
            //c++;
        }
        if(map.get(a[j]) != null) {
          map.put(a[j], map.get(a[j])+1);
        } else {
          map.put(a[j], 1);
        } 
      }
      System.out.println(c); 
      t--; 
    }
  }
}
