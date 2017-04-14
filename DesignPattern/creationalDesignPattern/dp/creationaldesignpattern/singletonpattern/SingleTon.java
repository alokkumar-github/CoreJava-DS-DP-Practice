package dp.creationaldesignpattern.singletonpattern;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SingleTon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -412191174612055240L;
	private static SingleTon instance=new SingleTon();// eagerly creating the instance ie. class loading phase
	
	private SingleTon(){
	}
	public static SingleTon getInstance(){
		return instance;
	}
	// use lazily instantce then deseialization give same hashcode.
	private Object readReslove() throws ObjectStreamException{
		System.out.println("readResolve");
		return instance;
	}
}
