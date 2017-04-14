package dp.creationaldesignpattern.abstractfactroypattern;

public abstract class AbstractFactory {
	public abstract Color getColor(String colorType);
	public abstract Shape getShape(String shapeType);
}
