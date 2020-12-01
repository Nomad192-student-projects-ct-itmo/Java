import java.util.Scanner;
import java.util.LinkedHashMap; 

public class Res {
	public static void main(String[] args) {

    int n=5;
    //int[] a = new int[n];
    LinkedHashMap <Integer, Integer> map = new LinkedHashMap <Integer, Integer>();

    map.put(n, 8);

    if(map.get(n) != null) {
      map.put(n, map.get(n)+7);
    } else {
      map.put(n, 1);
    }
    System.out.println(map.get(n));
  }
}
