package dp.creationaldesignpattern.singletonpattern;


public class DemoSigletTon {

	public static void main(String[] args) {
		
		SingleTon st1= SingleTon.getInstance();
		SingleTon st2= SingleTon.getInstance();
	
		print("st1", st1);;
		print("st2", st2);
	}

	static void print(String name , SingleTon object){
		System.out.println(String.format("Object :: %s, HashCode :: %d", name , object.hashCode()));
	}
}
