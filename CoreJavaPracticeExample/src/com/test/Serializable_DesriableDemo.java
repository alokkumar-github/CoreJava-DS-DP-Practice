package com.test;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serializable_DesriableDemo {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
			//Create FileOutputStream to create file
	        FileOutputStream out = new FileOutputStream("employee.dat");
	        //Create ObjectOutputStream
	        ObjectOutputStream outputStream = new ObjectOutputStream(out);
	 
	        //Create objects
	        Studentinfo obj = new Studentinfo("jhon",66,"897",1000,"dfg");
	      //Write objects to stream
            outputStream.writeObject(obj);
     
            //Always close the stream
            outputStream.close();
            
            FileInputStream in = new FileInputStream("employee.dat");
	        //Create ObjectOutputStream
	        ObjectInputStream inputStream = new ObjectInputStream(in);
	   
	        Studentinfo sinfo=(Studentinfo)inputStream.readObject();
            
	        System.out.println(sinfo.toString()+"\t"+sinfo.contact);
	        Employee empNew = null;
	         
	}

}
class Employee{
	private String ename;

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

}
/*
 * If a class is Serializable but its super class in not, 
 * what will be the state of the instance variables inherited 
 * from super class after deserialization?

 */
class Studentinfo extends Employee implements Serializable/*, Externalizable*/
{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String name;
 int rid;
 static String contact;
 transient private int salary;
 transient private String salaryi;
 Studentinfo(String n, int r, String c,int salary,String salaryi )
 {
  this.name = n;
  this.rid = r;
  this.contact = c;
  this.salary=salary;
  this.salaryi=salaryi;
 }
@Override
public String toString() {
	return "Studentinfo [name=" + name + ", rid=" + rid + ", salary=" + salary + ", salaryi=" + salaryi
			+ ", getEname()=" + getEname() + "]";
}
 
/*@Override
public void writeExternal(ObjectOutput out) throws IOException {
     out.writeObject(name+"xyz");
	
}
@Override
public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    //read in the same order as written
    name=(String) in.readObject();
    if(!name.endsWith("xyz")) throw new IOException("corrupted data");
    name=name.substring(0, name.length()-3);
	
}
*/

 
}