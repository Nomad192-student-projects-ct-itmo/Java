public class Sum {
	public static void main(String[] args) {
		int s=0;
		String[] subStr;
		for (String str: args) {
			subStr = str.split("[^0123456789+-]+");
      			for(int i = 0; i < subStr.length; i++) {
				if(subStr[i].length()!=0){
					s += Integer.parseInt(subStr[i]);
				}
       			}
		}
        	System.out.println(s); //"Результат: " + 
    	}
}
