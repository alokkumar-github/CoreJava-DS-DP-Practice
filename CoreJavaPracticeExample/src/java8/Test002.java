package java8;
// forEach method in java 8

import java.util.Arrays;
import java.util.List;

// External loops
// Internal loops- java 8
public class Test002 {

	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(4, 7, 6, 8);

		for (int i = 0; i < values.size(); i++) {// external loop
			System.out.println(i);
		}
		for (int i : values) {// external loop
			System.out.println(i);
		}
		values.forEach(i -> System.out.println(i));// internal loops
	}

}
