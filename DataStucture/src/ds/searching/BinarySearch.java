package ds.searching;

public class BinarySearch {

	
/*
 * Implement Binary search in java using divide and conquer technique. 
 */
	public static int binarySeach(int inputArray[],int findElement){
		int start=0;
		int end=inputArray.length-1;
		while(start<=end){
			int mid=(start+end)/2;
			if(findElement==inputArray[mid]){
				return mid;
			}
			if(findElement<inputArray[mid]){
				end=mid-1;
			}else{
				start=mid+1;
			}
		}
		return -1;
	}
	// useing recursive
	public static int recursiveBinarySearch(int[] sortedArray, int start, int end, int key) {
        
        if (start < end) {
            int mid = start + (end - start) / 2; 
            if (key < sortedArray[mid]) {
                return recursiveBinarySearch(sortedArray, start, mid, key);
                 
            } else if (key > sortedArray[mid]) {
                return recursiveBinarySearch(sortedArray, mid+1, end , key);
                 
            } else {
                return mid;  
            }
        }
        return -(start + 1); 
    }
	public void linearSearch(int inputArray[],int key) {
		int i;
		for (i = 0; i < inputArray.length-1; i++){
		if (inputArray[i] == key){ // This condition founds out whether we have found element.
		System.out.print("\nElement=" + key + " found at position=" + i);
		return; // We have found element, so exit for loop.
		}
		}
		//Reaching this part of method means element wasn't found.
		System.out.print("\nElement=" + key + " not found");
		}
	public static void main(String[] args) {
		int []a={2,4,6,8,10,12,14,16};
		System.out.println(binarySeach(a, 14));
		

	}

}
