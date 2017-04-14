package dp.creationaldesignpattern.singletonpattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * 1. Reflection.
 * 2. Serialization and Deserialization
 * 3. clone
 * 4. multiThreading
 * 5. multiple class loader :: let assume , web container and ear container , webcontainer load singleton and ear also load this class so same jvm we will get two diffrent instatnc of singleton class.
 * 
 *  why we use SingleTon:::
 *  RunTime class in jdk is singleton.when you run our application you have only one runtime available.whenever any change in runtime eveyone can see the change.
 *  LogManager.
 *  cache from diffence resources.
 *  resource manager like DBmangaer. connectionManager.
 *  
 */
public class VoiletTheSingleTon {

	public static void main(String[] args) throws Exception {
		SingleTon st1= SingleTon.getInstance();
		SingleTon st2= SingleTon.getInstance();
	
		print("st1", st1);;
		print("st2", st2);
		 //Using Reflection.....
		Class clazz=Class.forName("dp.creationaldesignpattern.singletonpattern.SingleTon");
		Constructor<SingleTon> con=clazz.getDeclaredConstructor();
		con.setAccessible(true);
		SingleTon st3=con.newInstance();
		//print("st3", st3);
		
		
		// Serializable
		ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("/temp/singleton.ss"));
		oos.writeObject(st2);
		
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("/temp/singleton.ss"));
		SingleTon st4=(SingleTon)ois.readObject();
		
		print("st4", st4);
		
		// clone // inorder to reslove throw and excepttion cloneNotsupported 
		SingleTon1 st11=SingleTon1.getInstance();
		SingleTon1 st12=(SingleTon1)st11.clone();
		
		//print("st11",st11);
		//print("st12", st12);
		
		// using MultiThread. in this example someTime it work ,sometime not.
		ExecutorService es=Executors.newFixedThreadPool(2);
		//es.submit(VoiletTheSingleTon::useSingleton2);
		es.submit( new Runnable() {
			public void run() {
				useSingleton2();
			}
		});
		es.submit( new Runnable() {
			public void run() {
				useSingleton2();
			}
		});
		es.shutdown();
	}

	static void print(String name , SingleTon object){
		System.out.println(String.format("Object :: %s, HashCode :: %d", name , object.hashCode()));
	}
	static void print(String name , SingleTon1 object){
		System.out.println(String.format("Object :: %s, HashCode :: %d", name , object.hashCode()));
	}
	static void print(String name , Singleton2 object){
		System.out.println(String.format("Object :: %s, HashCode :: %d", name , object.hashCode()));
	}
	static void print(String name , EnumToCreateSingleTon object){
		System.out.println(String.format("Object :: %s, HashCode :: %d", name , object.hashCode()));
	}
	
	static void useSingleton2(){
		//Singleton2 singleton2=Singleton2.getInstance();
		//print("singleton2::",singleton2);
		EnumToCreateSingleTon singleton2=EnumToCreateSingleTon.INSTENCE;
		print("singleton2::",singleton2);
	}
}
