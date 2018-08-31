package comparator_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/*
 * Comparable provides single sorting sequence ,Comparable affects the original class i.e. actual class is modified.,
 * java.lang ,We can sort the list elements of Comparable type by Collections.sort(List) method.,
 * int compareTo(obj)
 * 
 *  java.util , We can sort the list elements of Comparator type by Collections.sort(List,Comparator) method., int compare(obj o1,obj o2)
 */
public class ComparatorComparableDemo {

	public static void main(String[] args) {
		List<Student> stdList=new ArrayList<Student>();
		stdList.add(new Student("A",8));
		stdList.add(new Student("H",7));
		stdList.add(new Student("M",9));
		stdList.add(new Student("B",0));
		stdList.add(new Student("I",-1));
		
		System.out.println("Before Sort:::"+stdList);
		
		
		Student s1=new Student("A", 1);
		Student s2=new Student("A", 1);
		//Concept 1::  if equals not overrided then return false
		// as default behavirou of equls is ==
		System.out.println(s1.equals(s2));
		// concept 2::  Collections.sort(stdList); give complier error if you don't implement comparable. 
		//If any class implement Comparable interface in Java then 
		//collection of that object either List or Array and object will be sorted 
		//based on there natural order defined by CompareTo(Object) method.
		// if 

		Collections.sort(stdList);
		
		System.out.println("After Comparable Sort:::"+stdList);
		
		//concept 3:: what is we don't have source code of class not available 
						//or class defined as final.
						// and if give flexiblity to sort with 
						// diffrent attribute without touching the original class.
		// concept 4:: Comparator is self descriptive , we can define own logic to sort
		// by overriding equal method. and also can sort by mutiple attribute orders.
		// ex order by sid,sanme. see ex: SortByMultipleAttributeDemo.java
		Collections.sort(stdList,new SortStudentBySid());
		System.out.println("Before Comparator Sort:::"+stdList);

	}

}

interface A{}// error only default or public or abstruct modifier can be applied
class B {}

class SortStudentBySid implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getSid()-o2.getSid();
	}
	
}

class Student implements Comparable{
	private int sid;
	private String sname;
	public Student(String sname, int sid) {
		this.sid=sid;
		this.sname= sname;
	}
	
	public int getSid() {
		return sid;
	}

	public String getSname() {
		return sname;
	}

	//
	// hashCode is not required here becz we are not doing any think with hashMap or set
	// here is list to compare
	/*@Override 
	public boolean equals(Object obj){
		if(obj instanceof Student){
			Student s=(Student)obj;
			return this.sid==s.sid && (null!=this.sname && !this.sname.isEmpty())? this.sname.equals(s.sname):false; 
		}
		
		return false;
		
	}*/
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + "]";
	}
	@Override
	public int compareTo(Object o) {
		Student s=(Student)o;
		/*if(this.sid==s.sid)return 0;
		else if(this.sid>s.sid) return 1;
		else return -1;*/
		// if we don't want to write these above 3 line simply write below one line code.
		return s.sid-this.sid;// desending order;
		// return this.sid-s.sid; // asending order
	}
	/*@Override
	public int compareTo(Object o) {
		Student s=(Student)o;
		return this.sname.compareTo(s.sname);
	}*/
	
}