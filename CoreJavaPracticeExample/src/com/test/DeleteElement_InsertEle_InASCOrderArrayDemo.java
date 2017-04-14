package com.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class DeleteElement_InsertEle_InASCOrderArrayDemo {

	public static void main(String[] args) {
		
		int a[]=new int[]{6,7,9,37,00,5,3};
		int currentSize=a.length;
		deleteOrderedArray(a, 2, currentSize);
		System.out.println(Arrays.toString(a));
	}
	public static void deleteUNOrderedArray(int[]a,int positon,int currentSize){
		a[positon]=a[a.length-1];
		currentSize--;
	}
	public static void deleteOrderedArray(int[]a,int positon,int currentSize){
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		for(int i=0;i<a.length;i++){
			if(a[i]==a[positon]){
				currentSize--;
				for(int j=positon;j<currentSize;j++){
					a[j]=a[j+1];
				}
			}
		}
		
	}

}
