package ds.array;

import java.util.Arrays;

public class FindMissingNo1to100 {

	public static void main(String[] args) {
		int[] a={4,9,90,3,3};
		Arrays.sort(a);
		int j=0;
		for(int i=1;i<100;i++){
			if(i==a[j]){
				j++;
			}else{
				System.out.println(i);
			}
			
		}

	}

}
