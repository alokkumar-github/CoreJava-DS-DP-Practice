package ds.array;

import java.lang.reflect.Array;

public class MaergeTwoArray {

	public static void main(String[] args) {
		new MaergeTwoArray().f();

	}
	void f() {
		Integer a[] = new Integer[]{0,1,1};
	      Integer b[] = new Integer[]{2,3};
	      Integer[] arrBoth = new Integer[a.length+b.length];
	      for(int i = 0; i < a.length; i++){
	            arrBoth[i] = a[i];
	        }
	      for(int j = a.length;j < arrBoth.length;j++){
	            arrBoth[j] = b[j-a.length];
	        }
	      for(int k = 0; k < arrBoth.length; k++){
	            System.out.print(arrBoth[k]);
	        }
	}
}
