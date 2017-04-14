package ds.sorting;

public class Selectionsort {
public static int[] doSelectionSort(int[] arr){
		
	    for (int i = 0; i < arr.length - 1; i++)
	    {
	        int index = i;
	        for (int j = i + 1; j < arr.length; j++){
	            if (arr[j] < arr[index]) 
	                index = j;
	        }
	 
	        int smallerNumber = arr[index];  
	        arr[index] = arr[i];
	        arr[i] = smallerNumber;
	    }
	    return arr;
	}
	
	public static void main(String a[]){
		
		int[] arr1 = {5,1,12,-5,16,2,12,14};
		int[] arr2 = doSelectionSort(arr1);
		for(int i:arr2){
			System.out.print(i);
			System.out.print(", ");
		}
		System.out.println((char)'A'-0);
	}

}
