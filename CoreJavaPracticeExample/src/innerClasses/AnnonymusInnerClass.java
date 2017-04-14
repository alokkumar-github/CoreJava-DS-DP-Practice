package innerClasses;
/*
 * Inner class define without name.. in order to define annonymusInner class we have to have
 * interface or abstract class
 */
public class AnnonymusInnerClass {
	Annony d=new Annony() {
		
		@Override
		public void f1() {
			// TODO Auto-generated method stub
			
		}
	};
	public static void main(String[] args) {
		Annony1 a1 =new Annony1();
		a1.aa.f1();
		Annony1.aa.f1();

	}

}

interface Annony{
	public void f1();
}

class Annony1{
	static Annony aa=new Annony() {
		
		@Override
		public void f1() {
			System.out.println("annyonymus inner class example");
			
		}
	};
}