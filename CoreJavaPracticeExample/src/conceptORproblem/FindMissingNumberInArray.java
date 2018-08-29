package conceptORproblem;

public class FindMissingNumberInArray {

	static int naiveSol(int arr[]) { // o(n)
		// will be the sum of the numbers in the array.
		int sum = 0;
		int idx = -1;
		int l = arr.length;
		// we know there is a missing no.
		int n = l+1;
		// sum of natural numbers from 1 to N, can be expressed as Nx(N+1)/2. In your case N=100.
		int total = (n+1) * n / 2;
		for (int i = 0; i < arr.length; i++)
		{
//		    if (arr[i] == 0)
//		    {
//		         idx = i; 
//		    }
//		    else 
//		    {
		         //sum += arr[i];
		    	total -=arr[i];
//		    }
		}
		
       // System.out.println("total:: "+total);
		//System.out.println("missing number is: " + (total - sum) + " at index " + idx);
		//return (total - sum);
		return total;
	}
	/*
	 * 1) XOR all the array elements, let the result of XOR be X1.
	  2) XOR all numbers from 1 to n, let XOR be X2.
	  3) XOR of X1 and X2 gives the missing number.
	 */
	static int usingXOR(int a[]) {
		int x1 = a[0]; 
        int x2 = 1; 
        int n = a.length; 
        /* For xor of all the elements 
           in array */
        for (int i = 1; i < n; i++)
            x1 = x1 ^ a[i];
                 
        /* For xor of all the elements 
           from 1 to n+1 */        
        for (int i = 2; i <= n+1; i++)
            x2 = x2 ^ i;         
        System.out.println("missingNo:: "+(x1 ^ x2));
//        logic::::::::::::: o(n)
//        X1 = a1^a2^a4
//        X2 = a1^a2^a3^a4
//        X1^X2 = (a1^a2^a4)^(a1^a2^a3^a4)
//        	  = (a1^a1)^(a2^a2)^(a3)^(a4^a4)
//        	  = 0^0^a3^0
//        	  = a3
        return (x1 ^ x2);
	}
	 public static int count = 0;
	    public static int position = 0;
	    public static boolean flag = false;

	static void findMissingNumbers(int a[],int position) {
		if (position == a.length - 1)
            return;

        for (; position < a[a.length - 1]; position++) {

            if ((a[position] - count) != position) {
                System.out.println("Missing Number: " + (position + count));
                flag = true;
                count++;
                break;
            }
        }

        if (flag) {
            flag = false;
            findMissingNumbers(a, position);
        }
	}
	public static void main(String[] args) {
		int a[] = {1,2,3,5,6,7,8};
		//naiveSol(a);
		// usingXOR(a);
		int a1[] = { 0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 18, 20, 21, 23 };

        findMissingNumbers(a1, position);

	}

}
