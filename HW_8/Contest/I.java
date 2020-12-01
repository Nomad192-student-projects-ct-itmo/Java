import java.util.Scanner;

public class I {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextInt();

    long xl=Long.MAX_VALUE;
    long xr=Long.MIN_VALUE;
    long yl=Long.MAX_VALUE;
    long yr=Long.MIN_VALUE;
    long x, y, h;

    for (int i=0; i<n; i++) {
      x=sc.nextLong();
      y=sc.nextLong();
      h=sc.nextLong();

      xl=Math.min(xl, x-h);
      xr=Math.max(xr, x+h);
      yl=Math.min(yl, y-h);
      yr=Math.max(yr, y+h);
    }

    System.out.print((xl+xr)/2 + " ");
    System.out.print((yl+yr)/2 + " ");
    System.out.print(((Math.max(xr-xl, yr-yl)-1)/2)+1);
  }
}