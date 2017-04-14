package ds.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {
List<String>fl=new ArrayList<String>();
	private static void sort(int arr[]){
		int k;
		int l=arr.length;
		for(int i=0;i<=l-1;i++){
			for(int j=0;j<l-1;j++){
				k=j+1;
				if(arr[j]>arr[k]){
					int temp=arr[j];
					arr[j]=arr[k];
					arr[k]=temp;
				}
				print("fff:::",arr);
			}
			//print("ss::",arr);
		}
		print("ss::",arr);
	}
	
	private static void print(String s,int arr[]){
		/*System.out.println(s);
		
		for(int i=0;i<=arr.length-1;i++){
			System.out.println(arr[i]+" "+"\t");
		}
		System.out.println("\n");*/
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		int b[]={4,2,9,6,23,12,34,0,1};
		sort(b);

	}

}
