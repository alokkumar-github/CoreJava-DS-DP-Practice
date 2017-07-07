package practiceExamples;

public class Test00002 {
	public void test() {
		String str = "";
		p: for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 2; k++) {
				if (i == 1)
					break;
				if (i == 2 && k == 1)
					break p;
				str = str + i + k;
			}
		}
		System.out.println(str);
		System.out.println(p);
	}

	public static void main(String[] args) {
		Test00002 alpha = new Test00002();
		alpha.test();
	}

}
