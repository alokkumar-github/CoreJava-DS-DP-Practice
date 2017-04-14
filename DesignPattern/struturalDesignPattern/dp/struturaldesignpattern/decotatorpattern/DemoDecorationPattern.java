package dp.struturaldesignpattern.decotatorpattern;

public class DemoDecorationPattern {

	public static void main(String str[]){
		
		
		/*
		 * Add new functionality to existing object with altering the structure of its object.
		 * This pattern acts as a wrapper to exiting class
		 * This pattern create a decorator class which wraps the original class keeping the 
		 * existing class method signature intact.
		 * 
		 * in this example we will decorate the shape with some color without alter 
		 * shape class.
		 */
		Circle circle=new Circle();
		RedShapeDecorator rsd=new RedShapeDecorator(circle);
		System.out.println("Cicle with normal Boarder");
		circle.getShape();
		System.out.println("\nCircle with Red Boarder");
		rsd.getShape();
	}
}
