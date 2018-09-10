package annotation;

public class BitMnupulation {

	public static void main(String[] args) {
		// int arr[] = {20,10,10,20,30};
		int arr[] = { 2, 3, 4, 5, 4, 3, 6, 5, 2 };
		// findNotPairElement(arr);
		String s = "abc";
		possibleSet(s.toCharArray(),s.length());

	}

	// in a given array of int, every element appear twice except one. find it.
	public static int findNotPairElement(int[] arr) {
		int nonPairElement = 0;
		for (int i = 0; i < arr.length; i++) {
			// System.out.println("nonPairElement "+i+":: "+nonPairElement);
			nonPairElement = nonPairElement ^ arr[i];
			System.out.println("nonPairElement " + i + ":: " + nonPairElement);
		}
		System.out.println("nonPairElement:: " + nonPairElement);
		return nonPairElement;
	}

	// possible subset from a set
	public static void possibleSet(char[] A, int N) {
		for (int i = 0; i < (1 << N); ++i) {
			for (int j = 0; j < N; ++j) {
				//System.out.println(j+" dfs :: "+(1<<j));
				//System.out.println("sgf:: "+(i & (1 << j)));
				String s = "";
				if ((i & (1 << j))!=0 ) {
					//System.out.println(" " + A[j] + ", ");
					s = s+A[j];
					System.out.println(s);
				}
			}
			System.out.println(" ");
		}
	}
	
	public static boolean checkithBitIsSetOrNot(int n) {
		if(n & (1<<i)!=0)
	}

}
