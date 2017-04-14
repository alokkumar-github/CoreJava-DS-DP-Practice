package fileiooperation;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.SequenceInputStream;
import java.io.Serializable;
import java.util.Scanner;

public class ReadWriteFileDemo {

	public static void main(String[] args) throws IOException {
		File f = File.createTempFile("MyTempFile", ".tmp");
		//File f=new File(filePath.getParentFile() + File.separator + "Decrypted.txt");
		//System.out.println(f.getName());
		//System.out.println(f.getAbsolutePath());
		 //  System.out.println(f.mkdir());// true
		 // System.out.println(f.createNewFile());//
		
		 String obj  = "abc";
         byte b[] = obj.getBytes();
         ByteArrayInputStream obj1 = new ByteArrayInputStream(b);
         int c;
         // read
         while ((c = obj1.read()) != -1) {
      	      // System.out.print((char)c); 
         }
         // write
         FileOutputStream fos=new FileOutputStream(f.getAbsolutePath());
         fos.write(b);
         
        // writeTomultiplefile();
        // readDataFromMultipleSteam();
         pilelineDemo();
	}
	/*
	 * Java ByteArrayOutputStream class is used to write data into multiple files. In this stream, the data is written into a byte array that can be written to multiple stream.
	The ByteArrayOutputStream holds a copy of data and forwards it to multiple streams.
	The buffer of ByteArrayOutputStream automatically grows according to data.
	 */
	public static void writeTomultiplefile() throws IOException{
		FileOutputStream fout1=new FileOutputStream("f1.txt");  
		  FileOutputStream fout2=new FileOutputStream("f2.txt");  
		  
		  ByteArrayOutputStream bout=new ByteArrayOutputStream();  
		  bout.write(139);  
		  bout.writeTo(fout1);  
		  bout.writeTo(fout2);  
		  
		  bout.flush();  
		  bout.close();//has no effect  
		  System.out.println("success...");  
	}
	/*
	 * Java SequenceInputStream class is used to read data from multiple streams. It reads data of streams one by one.
	 */
	public static void readDataFromMultipleSteam() throws IOException{
		 FileInputStream fin1=new FileInputStream("f1.txt");  
		 FileInputStream fin2=new FileInputStream("f2.txt");  
		  
		   SequenceInputStream sis=new SequenceInputStream(fin1,fin2);  
		   int i;  
		   while((i=sis.read())!=-1){  
		    System.out.println((char)i);  
		   }  
		   sis.close();  
		   fin1.close();  
		   fin2.close();  
	}
	/*
	 * Java BufferedInputStream class is used to read information from stream. It internally uses buffer mechanism to make the performance fast.
	 */
	public static void readFromBufferForPer() throws IOException{
		FileInputStream fin=new FileInputStream("f1.txt");  
	    BufferedInputStream bin=new BufferedInputStream(fin);  
	    int i;  
	    while((i=bin.read())!=-1){  
	     System.out.println((char)i);  
	    }  
	    bin.close();  
	    fin.close();  
	}
	/*
	 * There are many ways to read data from the keyboard. For example:
		InputStreamReader
		Console
		Scanner
		DataInputStream etc.
		
		InputStreamReader class can be used to read data from keyboard.It performs two tasks:
		connects to input stream of keyboard
		converts the byte-oriented stream into character-oriented stream
	 */
	public static void inputStringFromKeyBoard() throws IOException{
		InputStreamReader r=new InputStreamReader(System.in);  
		BufferedReader br=new BufferedReader(r); // act as adopter pattern 
		  
		System.out.println("Enter your name");  
		String name=br.readLine();  
		System.out.println("Welcome "+name);  
	}
	
	public static void scccaner(){
		
		// simillarly Console class
		Scanner sc=new Scanner(System.in);  
	     
		   System.out.println("Enter your rollno");  
		   int rollno=sc.nextInt();  
		   System.out.println("Enter your name");  
		   String name=sc.next();  
		   System.out.println("Enter your fee");  
		   double fee=sc.nextDouble();  
		   System.out.println("Rollno:"+rollno+" name:"+name+" fee:"+fee);  
		   sc.close();  
	}
	/*
	 * he PipedInputStream and PipedOutputStream classes can be used to read and write
	 *  data simultaneously. Both streams are connected with each other 
	 *  using the connect() method of the PipedOutputStream class.


	 */
	public static void pilelineDemo() throws IOException{
		final PipedOutputStream pout=new PipedOutputStream();  
		final PipedInputStream pin=new PipedInputStream();  
		  
		pout.connect(pin);//connecting the streams  
		//creating one thread t1 which writes the data  
		Thread t1=new Thread(){  
		public void run(){  
		for(int i=65;i<=90;i++){  
		try{  
		pout.write(i);  
		Thread.sleep(1000);  
		}catch(Exception e){}  
		}  
		}  
		};  
		//creating another thread t2 which reads the data  
		Thread t2=new Thread(){  
		public void run(){  
		try{   
		for(int i=65;i<=90;i++)  
		System.out.println(pin.read());  
		}catch(Exception e){}  
		}  
		};  
		//starting both threads  
		t1.start();  
		t2.start();
	}
	/*
	 * Serialization in java is a mechanism of writing the state of an object into a byte stream.
	 * It is mainly used to travel object's state on the network (known as marshaling).
	 * 
	 * Java Serialization with Inheritance (IS-A Relationship)
	 * If a class implements serializable then all its sub classes will also be serializable.
	 * 
	 * Java Serialization with Aggregation (HAS-A Relationship)
		If a class has a reference of another class, 
		all the references must be Serializable otherwise serialization process
		 will not be performed. In such case, NotSerializableException is
		  thrown at runtime.
		  
		  Java Serialization with array or collection

	Rule: In case of array or collection, all the objects of array or 
	collection must be serializable. If any object is not serialiizable,
	 serialization will be failed.
	 */
	public static void writeData() throws IOException{
		Student s1 =new Student(211,"ravi");  
		  
		  FileOutputStream fout=new FileOutputStream("f.txt");  
		  ObjectOutputStream out=new ObjectOutputStream(fout);  
		  
		  out.writeObject(s1);  
		  out.flush();  
		  System.out.println("success");  
	}
	//An ObjectInputStream deserializes objects and primitive data written using an ObjectOutputStream.
	public static void readData() throws Exception, IOException{
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));  
		  Student s=(Student)in.readObject();  
		  System.out.println(s.id+" "+s.name);  
		  in.close();  
	}
}

class Student implements Serializable{  
int id;  
String name;  
public Student(int id, String name) {  
 this.id = id;  
 this.name = name;  
}  
}  

// you can not serailize since student1 is serialized and has a relation with 
// Address class , so this class should also be serialize(ie implements Serializable)
//Note: All the objects within an object must be Serializable.
class Address{  
	 String addressLine,city,state;  
	 public Address(String addressLine, String city, String state) {  
	  this.addressLine=addressLine;  
	  this.city=city;  
	  this.state=state;  
	 }  
	}  
class Student1 implements Serializable{  
	 int id;  
	 String name;  
	 static String company="SSS IT Pvt Ltd";//it won't be serialized
	 transient String ccc="jklsjg";//it won't be serialized
	 Address address;//HAS-A  
	 public Student1(int id, String name) {  
	  this.id = id;  
	  this.name = name;  
	 }  
	 
	}  
/*
 * Externalizable in java

The Externalizable interface provides the facility of writing the state of an object into a byte stream in compress format. It is not a marker interface.

The Externalizable interface provides two methods:

public void writeExternal(ObjectOutput out) throws IOException
public void readExternal(ObjectInput in) throws IOException
*/
