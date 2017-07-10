package serialization.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * The problem with the serialized singleton class is that whenever we deserialize it, it will create a new instance of the class.
 * This is not what singleton object is supposed to do. To avoid this add the readResolve() method in singleton class as below.
 */
public class SingletonLazyLoad implements Serializable{

	private static SingletonLazyLoad instance;
	
	private SingletonLazyLoad(){}
	
	public static synchronized SingletonLazyLoad getInstance() {
		if (instance == null) {
			instance = new SingletonLazyLoad();
		}
		return instance;
	}
	
	public static SingletonLazyLoad getInstanceWithDoubleCheckedLocking() {
		if (instance == null) {
			synchronized (SingletonLazyLoad.class) {
				if(instance == null) {
					instance = new SingletonLazyLoad();
				}
			}
		}
		return instance;
	}
	
	public void display() {
		System.out.println("Hello from Singleton Lazy Load Instance...");
	}

	//In order to make serialization and singleton work properly,we have to introduce readResolve() method in the singleton class.
	//readResolve() method lets developer control what object should be returned  on deserialization.
	private Object readResolve() throws ObjectStreamException{
		return instance;
	}
}
