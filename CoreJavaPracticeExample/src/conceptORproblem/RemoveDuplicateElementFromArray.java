package conceptORproblem;
import java.util.Arrays;

public class RemoveDuplicateElementFromArray {
	// first sort the array. remove duplicate and replace duplicate element to 1 and then reverse the array.
	public static int removeRepeat(int arr[]) {
		int n = arr.length; 
		Arrays.sort(arr);
		 if (n==0 || n==1){  
	            return n;  
	        }  
	        int[] temp = new int[n];  
	        int j = 0;  
	        for (int i=0; i<n-1; i++){  
	            if (arr[i] != arr[i+1]){  
	                temp[j++] = arr[i];  
	            }  
	         }  
	        temp[j++] = arr[n-1];     
	        // Changing original array  
	        for (int i=0; i<j; i++){  
	            arr[i] = temp[i];  
	        }  
	        for (int i=j;i<n;i++) {
	        	arr[i] = 1;
	        }
	        new ReverseArrayElement().reverseArray(arr);
	        return j;  
		
	}
	 static void display(int a[]) {
		 
	 }
	public static void main(String[] args) {
		int arr[] = new int[] {2,3,0,3,8,10,5,10,0};
		// int length = removeRepeat(arr);
		removeRepeat(arr);
		// for(int i=0;i<length;i++) {
		for(int i=0;i<arr.length;i++) {
			 System.out.println(arr[i]);
		 }
	}

}
