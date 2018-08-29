package conceptORproblem;

public class ReverseArrayElement {
	static int[] reverseArray(int[] a) {
		 int i= 0;
		 int j=a.length-1;
	           // for(int i=0,j=a.length-1;i<a.length-1;i++,j--){
		 while(i<j) {
			 // swap , increment first pointer , decrement pointer pointing last.
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
	 static void display(char a[]) {
		 for(int i=0;i<a.length;i++) {
			 System.out.println(a[i]);
		 }
	 }
	 static char[] reverseArrayWithoutaffectingspecialChar(char a[]) {
	/* sudo code...
	 * 1) Let input string be 'str[]' and length of string be 'n'
	 2) l = 0, r = n-1
	 3) While l is smaller than r, do following
	     a) If str[l] is not an alphabetic character, do l++
	     b) Else If str[r] is not an alphabetic character, do r--
	     c) Else swap str[l] and str[r]*/
		 
		 int pointer_i = 0;
		 int pointer_n = a.length-1;
		 
		 while(pointer_i<pointer_n) {
			 if(!isAlphabet(a[pointer_i])) {
				 pointer_i++;
			 }else if(!isAlphabet(a[pointer_n])) {
				 pointer_n--;
			 }else {
				 // swap
				 char temp = a[pointer_i];
				 a[pointer_i] = a[pointer_n];
				 a[pointer_n] = temp;
				 pointer_i++;
				 pointer_n--;
			 }
		 }
		 return a; 
	 }
	 static boolean isAlphabet(char c) {
		 return ((c>='a' && c<='z')|| (c>='A' && c<='Z')); 
	 }
	public static void main(String[] args) {
		int a[] = new int[] {2,3,0,8,10,5};
		String s = "a,bf$c";
		char[] c = s.toCharArray();
		//display(reverseArray(a));
		display(reverseArrayWithoutaffectingspecialChar(c));
	}

}
