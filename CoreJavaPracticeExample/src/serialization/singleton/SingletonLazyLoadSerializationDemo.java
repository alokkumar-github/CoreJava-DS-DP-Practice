package serialization.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Singleton class serialization/deserialization demo.
 *
 */
public class SingletonLazyLoadSerializationDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		SingletonLazyLoad singleton = SingletonLazyLoad.getInstanceWithDoubleCheckedLocking();
		System.out.println(singleton + ", " + singleton.getInstanceWithDoubleCheckedLocking());
		FileOutputStream fos = new FileOutputStream(new File("singleton.ser"));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(singleton);
		oos.close();

		FileInputStream fis = new FileInputStream(new File("singleton.ser"));
		ObjectInputStream ois = new ObjectInputStream(fis);
		SingletonLazyLoad singleton1 = (SingletonLazyLoad) ois.readObject();
		System.out.println(singleton1 + ", " + singleton1.getInstanceWithDoubleCheckedLocking());
		ois.close();

		FileInputStream fis2 = new FileInputStream(new File("singleton.ser"));
		ObjectInputStream ois2 = new ObjectInputStream(fis2);
		SingletonLazyLoad singleton2 = (SingletonLazyLoad) ois2.readObject();
		System.out.println(singleton2 + ", " + singleton2.getInstanceWithDoubleCheckedLocking());
		ois2.close();
	}

}