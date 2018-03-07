package dp.behaviourdesignpattern.chainofresposiblity;

import dp.behaviourdesignpattern.chainofresposiblity.ConcreteHandlerOne;
import dp.behaviourdesignpattern.chainofresposiblity.ConcreteHandlerThree;
import dp.behaviourdesignpattern.chainofresposiblity.ConcreteHandlerTwo;
import dp.behaviourdesignpattern.chainofresposiblity.Handler;
import dp.behaviourdesignpattern.chainofresposiblity.Request;

public class ChainOfResposiblity {
		public static void main(String[] args) 
		{
			// Setup Chain of Responsibility
			Handler h1 = new ConcreteHandlerOne();
			Handler h2 = new ConcreteHandlerTwo();
			Handler h3 = new ConcreteHandlerThree();
			h1.setSuccessor(h2);
			h2.setSuccessor(h3);

			// Send requests to the chain
			h1.handleRequest(new Request("Negative Value ", -1));
			h1.handleRequest(new Request("Negative Value ",  0));
			h1.handleRequest(new Request("Negative Value ",  1));
			h1.handleRequest(new Request("Negative Value ",  2));
			h1.handleRequest(new Request("Negative Value ", -5));	    
		}
}




 

 

 


