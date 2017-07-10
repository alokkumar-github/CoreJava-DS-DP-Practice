package serialization;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Product implements Serializable {

	private String name;
	private double price;
	private static String test = "test"; // static field does not participate in serialization as it is not part of
											// object state.
	private transient static String test1 = "test1"; // declaring static field as transient does not make any sense, as
														// static field is not part of object state.
	private final int final1 = 10; // final variable participate in serialization directly by their values.
	private transient final int final2 = 20; // so declaring final as transient is of no use, as JVM has no variable to
												// check weather it is transiet or not.
	public final Map<Integer, Integer> final3;

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
		this.test = "test2";
		this.test1 = "test11";
		this.final3 = new HashMap<Integer, Integer>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public static String getTest() {
		return test;
	}

	public static void setTest(String test) {
		Product.test = test;
	}

	public static String getTest1() {
		return test1;
	}

	public static void setTest1(String test1) {
		Product.test1 = test1;
	}

	public int getFinal1() {
		return final1;
	}

	public int getFinal2() {
		return final2;
	}
}