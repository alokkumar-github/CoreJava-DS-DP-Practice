package conceptORproblem;

public class ReverseArrayElement {
	static int[] reverseArray(int[] a) {
		 int i= 0;
		 int j=a.length-1;
	           // for(int i=0,j=a.length-1;i<a.length-1;i++,j--){
		 while(i<j) {
	                int temp = a[i]; // 2,
	                 a[i] = a[j]; // 0=5,
	                 a[j] = temp; // 5=2,
	                 i++;
	                 j--;
	            }
	    return a;
	    }
	 static void display(int a[]) {
		 for(int i=0;i<a.length;i++) {
			 //System.out.println(a[i]);
		 }
	 }
	public static void main(String[] args) {
		int a[] = new int[] {2,3,0,8,10,5};
		display(reverseArray(a));

	}

}
