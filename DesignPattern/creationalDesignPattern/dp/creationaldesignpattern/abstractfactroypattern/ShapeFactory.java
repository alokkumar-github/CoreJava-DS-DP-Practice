package dp.creationaldesignpattern.abstractfactroypattern;

public class ShapeFactory extends AbstractFactory{
	
	@Override
	public Shape getShape(String shapeType){
		if(shapeType.equalsIgnoreCase("Circle")){
			return new Circle();
		}else if(shapeType.equalsIgnoreCase("Rectangle")){
			return new Rectangle();
		}else if(shapeType.equalsIgnoreCase("Square")){
			return new Square();
		}else{
			return null;
		}
	}

	@Override
	public Color getColor(String colorType) {
		// TODO Auto-generated method stub
		return null;
	}
}
