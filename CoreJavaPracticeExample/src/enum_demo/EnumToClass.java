package Enum;

enum enumdemoA{

	KO, KF, KOs(10), KFs(20);

	enumdemoA(){
		System.out.println("Hello DC");
	}

	enumdemoA(int a){
		System.out.println("Hello ARG-Cons "+a);
	}

	public static void main(String[] args) {
		System.out.println("Hello main()...");
	}

}
// is equivalent of above enum
public class EnumToClass {
	
	public static final EnumToClass KO=new EnumToClass();
	public static final EnumToClass KF=new EnumToClass();
	public static final EnumToClass KOs=new EnumToClass(10);
	public static final EnumToClass KFs=new EnumToClass(20);
	public EnumToClass(int i) {
		System.out.println("Hello ARG-Cons "+i);
	}
	public EnumToClass() {
		System.out.println("Hello DC");
	}
	public static void main(String[] args) {
		System.out.println("Hello main()...");
	}

}
