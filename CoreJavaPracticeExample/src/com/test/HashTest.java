package com.test;

public class HashTest {

	public static void main(String[] args) {
		System.out.println(getIndex("alok"));
		
	}

	public static int getIndex(String st){
		int n=16;
		int hash=st.hashCode();
		return hash & (n-1);
	}
}
