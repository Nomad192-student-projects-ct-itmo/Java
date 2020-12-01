public class HelloWorld {
	public static void main(String[] args) {
		        int result = 0;
        for (int i = 0; i < 2020; i++) {
            for (int j = 0; j < 2020; j++) {
                for (int k = 0; k < 2020; k++) {
                    for (int p = 0; p < 10; p++) {
                        result ^= (i * 3) | (j * 2 + k) & ~p;
                        result ^= result << 1;
	         print(3, result);
                    }
                }
            }
        }
	}
}