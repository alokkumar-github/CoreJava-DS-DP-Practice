package dp.behaviourdesignpattern.chainofresposiblity;

import dp.behaviourdesignpattern.chainofresposiblity.Handler;
import dp.behaviourdesignpattern.chainofresposiblity.Request;

public class ConcreteHandlerOne extends Handler
{	@Override
	public void handleRequest(Request request)
	{
		if (request.getValue() < 0)
		{           //if request is eligible handle it
			System.out.println("Negative values are handled by ConcreteHandlerOne:");
			System.out.println("\tConcreteHandlerOne.HandleRequest : " + request.getDescription()
						 + request.getValue());
		}
		else
		{
			handleRequest(request);
		}
	}
 }
