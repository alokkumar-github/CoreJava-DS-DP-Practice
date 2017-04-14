package dp.creationaldesignpattern.abstractfactroypattern;

public class DemoAbstractFactory {

	public static void main(String[] args) {
		// factory of factories.
		AbstractFactory af=new FactoryProducer().getFactory("Color");
		Color red=af.getColor("Red");
		red.fill();
		
		AbstractFactory af1=new FactoryProducer().getFactory("Shape");
		Shape circle=af1.getShape("circle");
		circle.draw();
	}

}
