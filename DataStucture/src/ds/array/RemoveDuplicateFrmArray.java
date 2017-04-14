package ds.array;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicateFrmArray {

	public static void main(String[] args) {
		int arr[] = new int[] {2, 2, 3, 3, 5, 16,8, 76, 8 };
		int a[]=null;
		a=arr;
		System.out.println("dfdf"+Arrays.toString(a));
		/*Arrays.sort(arr);
		// should be in sorted
		int current = 0;
		for (int i = 0; i < arr.length; i++) {
			if (current != arr[i]) {
				current = arr[i];
				//System.out.println(current);
			} else {
				// System.out.println(current);
			}

		}*/
		getrepeatedElement(arr,arr.length-1);
		//dupl();
	}

	/*
	 * if (listWithoutDuplicates.contains(i)){
	 * 
	 * }
	 */
	// this is using util package.
	private static void dupl() {
		int[] input = { 2, 9, 3, 8, 4, 8, 32, 98, 22, 9, 1 };

		Set outputSet = new TreeSet<Integer>();
		for (int i : input) {
			if (!outputSet.add(i))
				System.out.println(i); // Duplicate(s)
		}
	}
	
	// logic is loop the element and marking the index in the array equal to that number as negative . 
	static void getrepeatedElement(int arr[], int size)
	{
	    int i;    

	    for(i = 0; i < size; i++)
	    {
	    	System.out.println(Math.abs(arr[i]));
	    	System.out.println(Math.abs(arr[i])-1);
	    	System.out.println(arr[Math.abs(arr[i])-1]);
	        if(arr[Math.abs(arr[i])-1] > 0){
	            arr[Math.abs(arr[i])-1] = -arr[Math.abs(arr[i])-1];
	        }
	        else{
	        	System.out.println("Duplicate value:::"+Math.abs(arr[i]));
	        }
	    }
	}
}
