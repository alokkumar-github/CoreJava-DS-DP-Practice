package com.test;

public class AramStrongNumber {

	public static void main(String[] args) {
		// Armstrong number is a 3 digit number which is equal to sum of cube of
		//its digits.
		//For example: 371,153
		System.out.println(isAramStrong(153));
	}
	public static boolean isAramStrong(int n){
		boolean isAramStrong=false;
		int originalNumber=n;
		int sum=0;
		while(n!=0){
			int rem=n%10; // 1%10 gives 1;
			sum=sum+rem*rem*rem;
			n=n/10; // 1/10 gives 0
		}
		if(sum==originalNumber){
			isAramStrong=true;
		}else{
			isAramStrong=false;
		}
		return isAramStrong;
	}

}
