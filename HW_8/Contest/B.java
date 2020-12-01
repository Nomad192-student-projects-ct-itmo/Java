import java.util.Scanner;

public class B {
	public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n=in.nextInt();
    int k=-710*25000;
    while(n>0){
      k+=710;
      System.out.println(k);
      n--;
    }
  }
}
