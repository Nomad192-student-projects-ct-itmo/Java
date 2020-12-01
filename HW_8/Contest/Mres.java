import java.util.Scanner;
 
public class Mres {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t=in.nextInt();
    while(t>0){
      int n=in.nextInt();
      int[] a = new int[n];
      int c=0;
 
      for(int i=0; i<n; i++)
        a[i]=in.nextInt();
 
      for(int i=0; i<=n-3; i++)
        for(int j=i+1; j<=n-2; j++)
          for(int k=j+1; k<=n-1; k++)
            if(a[k]-a[j]==a[j]-a[i])
              c++;
 
      System.out.println(c); 
      t--; 
    }
  }
}