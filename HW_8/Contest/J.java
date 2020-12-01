import java.util.Scanner;

public class J {
	public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[][] a = new int[n][n];

    for (int i = 0; i < n; i++) {
      char[] line = new char [n];
      line = in.next().toCharArray();
      for (int j = 0; j < n; j++) {
        a[i][j] = line[j] - '0';
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i < j && a[i][j] == 1) {
          for (int q = j + 1; q < n; q++) {
            a[i][q] -= a[j][q]; 
            if (a[i][q] < 0) {
              a[i][q] += 10;
            }
          }
        } else {
          a[i][j] = 0;
        } 
        System.out.print(a[i][j]);  
      }
      System.out.print("\n");     
    }

    in.close();  
  }
}
