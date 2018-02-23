package java8;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import exception.NoResultException;

public class OptionalDemo {
	
	static Map<Integer, String> mapItems;
	
	static {
		mapItems = new HashMap<Integer, String>();
		mapItems.put(1, "one");
		mapItems.put(2, "two");
		mapItems.put(3, "three");
		mapItems.put(4, "four");
		mapItems.put(5, "five");
		mapItems.put(6, "six");
	}

	// In Java 9 a couple of factory-methods are added that can also be used to
	// simplify the creation of maps:
//	public class java9WayToInitializeMap {
//		private static final Map<String, String> test = Map.of("a", "b", "c", "d");
//		private static final Map<String, String> test2 = Map.ofEntries(entry("a", "b"), entry("c", "d"));
//	}

	public static String findItem(Integer key) {
		return mapItems.get(key);
	}

	public String getItemValueByKey(Integer key) {
		// case1.
		Optional<String> optionalValue = Optional.ofNullable(findItem(key));
		optionalValue.filter(s -> {
			return s.equals("one");
		}).orElseThrow(() -> {
			return new NoResultException("* value not found for key *: " + key);
		});

		if (optionalValue.isPresent()) {
			System.out.println("value for key:: " + key + " is :: " + optionalValue.get());
			return optionalValue.get();
		} else {
			throw new NoResultException("value not found for key: " + key);
		}
	}

	public static void main(String[] args) {
		new OptionalDemo().getItemValueByKey(7);
	}

}
