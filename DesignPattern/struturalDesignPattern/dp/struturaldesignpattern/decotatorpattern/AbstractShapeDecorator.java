package dp.struturaldesignpattern.decotatorpattern;

public abstract class AbstractShapeDecorator implements Shape {

	protected Shape decoratedShape;
	
	public AbstractShapeDecorator(Shape shapeDecorator){
		this.decoratedShape=shapeDecorator;
	}
	
	public void getShape() {
		this.decoratedShape.getShape();
	}

}
