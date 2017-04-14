package dp.creationaldesignpattern.singletonpattern;

import java.io.ObjectStreamException;

public class Singleton2 {
	private static Singleton2 instance2 = null;// lazily

	private Singleton2() {
	}
	
	public static Singleton2 getInstance() {
		if (instance2 == null) {
			instance2 = new Singleton2();
		}
		return instance2;
	}
	/*public static Singleton2 getInstatnce(){ // singleton holder . this is also one way to create single ton
		return Holder.instance;
	}
	static class Holder{
		private static final Singleton2 instance=new Singleton2();
	}*/
}

// half initialze object may occurr in double check lock. ; to resolve this use voletile. ; make sure change to a volatile variable is to be publish/read when change is completed.
// here in this case private static volatile Singleton2 instance2 = null;// lazily

// to resolve for multi thread environment.
/*public static Singleton2 getInstance() { // this is double check lock.
	if (instance2 == null) { // check 1
		synchronized (Singleton2.class) {
			if (instance2 == null) { //check2 
				instance2 = new Singleton2();
			}
		}
	}
	return instance2;
}*/

// singleton holder .

