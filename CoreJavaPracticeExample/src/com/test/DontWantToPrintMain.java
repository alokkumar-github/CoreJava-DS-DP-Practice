package com.test;

public class DontWantToPrintMain {

	static{
		System.out.println("Don't want to print Main , print this only");
		System.exit(0);
	}
	
	public static void main(String[] args) {
		System.out.println("print main");
	}

}
