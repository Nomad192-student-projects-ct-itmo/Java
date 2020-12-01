import java.util.Scanner;

public class Reverse {
public static void main(String[] args){
    int[] i = new int[1000000];
    int k = 0;
    int line = 0;
    int[] num = new int[10000];
    int v = 0;
      Scanner scanner = new Scanner (System.in);
     while (scanner.hasNextLine()){
       Scanner sc = new Scanner (scanner.nextLine());
     while (sc.hasNextInt()){
      i[k] = sc.nextInt();
    v++;
      k++;
      }
      num[line] = v;
      v = 0;
      line++;
    } 
    for (int j = line - 1; j >= 0; j--){
      for (int b = 0; b < num[j]; b++){ 
        System.out.print(i[k - b -  1] + " ");
      }
      k -= num[j];
      System.out.print("\n");
    }
  }
}