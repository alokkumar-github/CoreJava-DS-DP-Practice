package ds.array;

public class ArrayRotation {

	public static void main(String[] args) {
		Integer arr[]=new Integer[]{1,2,3,4,5,6,7};
		int arr1[]=new int[]{1,2,3,45,4,5,6,71};
			displayArr(rotateArray(arr, 2));
			System.out.println("Second Largest No:" + new Example().getSecondLargestNo(arr1));
	}
	
 private static <T> T[] rotateArray(Integer arr[], int n){
	 /*
	  * Bouble Rotate Logic
	  * 
	  * i=1 and j=7
	  * 
	  * 1 2 3 4 5 6 7
	  * 1 2 3 4 5 7 6
	  * 1 2 3 4 7 5 6
	  * 1 2 3 7 4 5 6
	  * 1 2 7 3 4 5 6
	  * 1 7 2 3 4 5 6
	  * 7 1 2 3 4 5 6
	  * 
	  * 
	  */
	 for(int i=0; i <n;i++){
		 for(int j=arr.length-1;j>0;j--){
			 int temp = arr[j-1];
			 arr[j-1]=arr[j];
			 arr[j]=temp;
		 }
	 }
	 return (T[])arr;
 }
 
 private static <T> void  displayArr(T arr[]){
	 for(int i=0;i<arr.length;i++){
		 System.out.println(arr[i]);
	 }
 }

}
 class Example {
    public int getSecondLargestNo(int values[] ){
              int lagestnumber = values[0];
            int secondlargest = values[0];
            for (int i = 0; i < values.length; i++) {
                if (values[i] > lagestnumber) {
                      secondlargest = lagestnumber;
                      lagestnumber = values[i];
                } else if (values[i] > secondlargest) {
                      secondlargest = values[i];
                }
            }
            return secondlargest;
    }
}