import java.util.Scanner;
import java.util.LinkedHashMap;

public class H {
	public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    LinkedHashMap <Integer, Integer> map = new LinkedHashMap <Integer, Integer>();

    int n = in.nextInt();
    int [] a = new int[n+1];
    a[0] = 0;
    int maxa = 0; 
    int[] f = new int[1000001];
    int l = 1, res;

    for (int i = 1; i <= n; i++) {
      res = in.nextInt();
      a[i] = a[i-1] + res;
      if (res > maxa) {
        maxa = res;
      }
      for ( ; l <= a[i]; l++) {
        f[l] = i;
      }
    }

    int q = in.nextInt();

    for (int k, t; q > 0; q--) {
      t = in.nextInt();
      k = 0;
      if (t < maxa) {
        System.out.println("Impossible");   
      } else if(map.get(t) != null) {
        System.out.println(map.get(t));
      } else {
        int s = 0;
        while (true) {
          if (t + a[s] >= a[n]) {
            k++;
            break;
          }
          if (f[t+a[s]] == f[t+a[s]+1]) {
            s = f[t+a[s]] - 1;
          } else {
            s = f[t+a[s]];
          }
          k++;
        }
        map.put(t, k);
        System.out.println(k);
      }      
    }
    
  }
}
