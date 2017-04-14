package dp.struturaldesignpattern.decotatorpattern;

public class RedShapeDecorator extends AbstractShapeDecorator{

	public RedShapeDecorator(Shape shapeDecorator) {
		super(shapeDecorator);
	}
	
	@Override
	public void getShape() {
		super.getShape();//or		decoratedShape.getShape();
		setRedBoarder(decoratedShape);
	}
	private void setRedBoarder(Shape shapeDecorator){
		System.out.println("Border color Red::: from red shape decorator");
	}
	

}
