package dp.behaviourdesignpattern.chainofresposiblity;

import dp.behaviourdesignpattern.chainofresposiblity.Handler;
import dp.behaviourdesignpattern.chainofresposiblity.Request;

public class ConcreteHandlerThree extends Handler
{
	public void handleRequest(Request request)
	{
		if (request.getValue() >= 0)
		{           //if request is eligible handle it
			System.out.println("Zero values are handled by ConcreteHandlerThree:");
			System.out.println("\tConcreteHandlerThree.HandleRequest : " + request.getDescription()
						 + request.getValue());
		}
        else
		{
			handleRequest(request);
		}
	}
}
