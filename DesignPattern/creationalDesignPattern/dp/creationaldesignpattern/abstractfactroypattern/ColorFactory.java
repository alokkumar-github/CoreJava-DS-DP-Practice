package dp.creationaldesignpattern.abstractfactroypattern;

public class ColorFactory extends AbstractFactory{
	
	@Override
	public Color getColor(String colorType){
		if(colorType.equalsIgnoreCase("red")){
			return new Red();
		}else if(colorType.equalsIgnoreCase("green")){
			return new Green();
		}else{
			return null;
		}
	}

	@Override
	public Shape getShape(String shapeType) {
		// TODO Auto-generated method stub
		return null;
	}
}
