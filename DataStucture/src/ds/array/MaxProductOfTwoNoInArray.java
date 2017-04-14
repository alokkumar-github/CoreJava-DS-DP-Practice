package ds.array;

public class MaxProductOfTwoNoInArray {
/*
 * A Better Solution is to use sorting. Below are detailed steps.
1) Sort input array in increasing order.
2) If all elements are positive, then return product of last two numbers.
3) Else return maximum of products of first two and last two numbers.
Time complexity of this solution is O(nLog n). 
 */
	public static void main(String[] args) {
		int []arr=new int[]{10,5,1,6,9,2};
		int maxproduct=0;
		int a=arr[0];
		int b=arr[1];
		for(int i=0;i<arr.length;i++){//Time Complexity: O(n2)
			for(int j=i+1;j<arr.length;j++){
				int temp=arr[i]*arr[j];
				if(maxproduct>temp){
				}else{
					maxproduct=temp;
					a=arr[i];b=arr[j];
				}
			}
		}
		System.out.println(maxproduct+"\t"+"{ "+a+","+b+" }");
	}
}
