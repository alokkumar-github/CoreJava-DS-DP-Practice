package dp.behaviourdesignpattern.observer;

/**
 * Design Pattern series by http://java9s.com
 * @author java9s.com
 *
 */
public class Exec {
	public static void main(String[] args) {
		//Create stocks
		IBM ibm = new IBM();
		Microsoft microsoft = new Microsoft();
		Apple apple = new Apple();
		
		//Create Observers
		Mobile mobile = new Mobile();
		DisplayBoard displayBoard = new DisplayBoard();
		
		//Register Observers for stocks
		ibm.registerObserver(mobile);
		ibm.registerObserver(displayBoard);
		
		microsoft.registerObserver(mobile);
		microsoft.registerObserver(displayBoard);
		
		apple.registerObserver(mobile);
		apple.registerObserver(displayBoard);
		
		//Set some random stock prices
		for(int i =0; i<300; i++){
			ibm.updateStockPrice((int)(Math.random()*101)+1);
			microsoft.updateStockPrice((int)(Math.random()*101)+1);
			apple.updateStockPrice((int)(Math.random()*101)+1);
		}
		
	}
}
