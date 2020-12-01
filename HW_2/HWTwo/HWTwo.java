public class HWTwo {
	public static void main(String[] args) {
		int s=0;
		for (String str: args) {
           		s+=Integer.parseInt(str);
       		}
        	System.out.println(s);
//.replace("\\n", " ").replace("\\r", " ").replace("\\t", " ").replace("\\f", " ").trim().split("\\D+");
        	//String name = System.console().readLine();
        	//int age = Integer.parseInt(System.console().readLine());
        	//float height = Float.parseFloat(System.console().readLine());
    }
}
