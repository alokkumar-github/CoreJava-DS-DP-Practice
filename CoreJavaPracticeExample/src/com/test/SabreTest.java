package com.test;

import java.io.IOException;
/*
 * 1. find first repeating letter in a string java
 * 2. add two float value and return int
 * 3. print fixaa, fixaaaa at even loop etc.
 */
/*class SabreTest1 extends SabreTest{

	public SabreTest1() throws IOException {
		try{
			super();
		}catch(IOException e)
		{
			System.out.println("IO in SabreTest1");
		}
		// TODO Auto-generated constructor stub
	}
	
}*/
public class SabreTest {
	/*public SabreTest() throws IOException{
		throw new IOException();
	}*/
	public static void aa(){
		boolean a=false;
		if(a=true)
			System.out.println("hello");
		else
			System.out.println("goodbye");
	}
	public static void add(){
		int a=5;
		loop:for(int i=1;i<3;i++){
			for(int j=1;j<3;j++){
				if(a==5){
					break loop;
				}
				System.out.println(i*j);
			}
		}
	}
class inner{
	void test(){
		if(SabreTest.this.flag){
			sample();
		}
	}
}
private boolean flag=true;
public void sample(){
	System.out.println("sample");
}
/*public SabreTest(){
	(new inner()).test();
}*/
	public static void main(String[] args){
		
		double d=10.0/-0;
		if(d==Double.POSITIVE_INFINITY){
			System.out.println("kkk");
		}else{
			System.out.println("dsfno");
		}
		aa();
		add();
		String s1="abc";
		String s2="def";
		String s3=s1.concat(s2).toUpperCase();
		System.out.println(s1+s2+s3);
		//new SabreTest();
		int[] a={1};
		SabreTest t=new SabreTest();
		t.increment(a);
System.out.println(a[a.length-1]);
System.out.println(Math.ceil(-4.7));
String s[]={"f","j"};

try{
	int c=4/0;
	
}catch(Exception e){
	System.out.println("dgd");
	
}finally{
	System.out.println("dsfgds");
}
	}
void increment(int [] i){
	i[i.length-1]++;
}
}
