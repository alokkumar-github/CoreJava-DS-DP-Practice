package dp.creationaldesignpattern.singletonpattern;


public class SingleTon1 implements Cloneable{

	private static SingleTon1 instance1=new SingleTon1();// eager
	
	private SingleTon1(){
	}
	public static SingleTon1 getInstance(){
		return instance1;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
