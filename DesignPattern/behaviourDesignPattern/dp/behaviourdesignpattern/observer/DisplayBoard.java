package dp.behaviourdesignpattern.observer;

public class DisplayBoard implements Observer{

	@Override
	public void update(Stock stock) {
	System.out.println("DISPLAYBOARD - The Price of "+stock.getStockName()+" has changed:"+stock.getStockPrice());
	}

}
