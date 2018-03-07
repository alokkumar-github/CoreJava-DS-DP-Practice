package dp.creationaldesignpattern.singletonpattern;

/*
 * When and where to use the Singleton Pattern?
 * 1.	We used the singleton pattern in our utility layers which consist of Loggging, Caching, Service host repositories, Load Balancer... If the question is on how we arrived to the design. There was a performance lag on the utility layer eg, Logging, on diagnosing we observed that there are several instance getting created which are not required in my case. So we adopted Singleton pattern.
2.	We have our DB framework that makes connections to Back end.To Avoid Dirty reads across Multiple users we have used singleton pattern to ensure we have single instance available at any point of time.
3.	logging, communication,Configuration classes reading from class [may be put in cache for performance hit] and shared resource ex.Database access.
ex. in flight tracking app. where we have multiple instance of flight, traficController but only one instance of statelite  
 */
public class DemoSigletTon {

	public static void main(String[] args) {
		
		SingleTon st1= SingleTon.getInstance();
		SingleTon st2= SingleTon.getInstance();
	
		print("st1", st1);;
		print("st2", st2);
		Logger.logMessage("This is SINGLETON");
	}

	static void print(String name , SingleTon object){
		System.out.println(String.format("Object :: %s, HashCode :: %d", name , object.hashCode()));
	}
}

//What’s the difference between a singleton class and a static class?
//We can create a class and declare it as “final” with all the methods “static”. 
// ex. Math class in Java
//In this case, you can’t create any instance of class and can call the static methods directly.
final class Logger {
	static public void logMessage(String s) {
			System.out.println(s);
		}
}