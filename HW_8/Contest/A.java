import java.util.Scanner;

public class A {
	public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int a=in.nextInt();
    int b=in.nextInt();
    int n=in.nextInt();
    int rba=a, rbb=b;
    int ans=0;

    while (rba!=n || rbb!=n) {
      if (rba==rbb) {
        rbb+=(b-a);
        if(rbb>n) {
          rbb=n;
        }
      }
      else {
        rba=rbb;
      }
      ans++;
    }

    System.out.println(ans);
  }
}
