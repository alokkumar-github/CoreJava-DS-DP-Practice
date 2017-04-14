package dp.creationaldesignpattern.abstractfactroypattern;

public class FactoryProducer {
	
	public AbstractFactory getFactory(String choice){
		if(choice.equalsIgnoreCase("Color")){
			return new ColorFactory();
		}else if(choice.equalsIgnoreCase("shape")){
			return new ShapeFactory();
		}else{
			return null;
		}
	}

}
