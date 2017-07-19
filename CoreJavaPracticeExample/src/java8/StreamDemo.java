package com.test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
	public static void main(String[] args) {
		joiningDemo();
	}

	public static void mapDemo() {
		List<String> collection = Arrays.asList("My", "name", "is", "John", "Doe");
		System.err.println(collection.stream().map(String::toUpperCase).collect(Collectors.toList()));
	}

	public static void flatMapDemo() {
		List<List<String>> collection = Arrays.asList(Arrays.asList("My", "name", "is"), Arrays.asList("John", "Doe"));
		System.err.println(collection.stream().flatMap(List::stream).collect(Collectors.toList()));
	}

	public static void filterDemo() {
		List<String> collection = Arrays.asList("My", "name", "is", "John", "Doe");
		System.err.println(collection.stream().filter((elem) -> elem.length() <= 3).collect(Collectors.toList()));
	}

	public static void comparatorDemo() {
		List<Person> collection = Arrays.asList(new Person("A", 10), new Person("B", 20), new Person("C", 30), new Person("D", 40), new Person("E", 30));
		System.err.println(collection.stream().max((p1, p2) -> Integer.compare(p1.age, p2.age)));
	}

	public static void sumDemo() {
		List<Integer> collection = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		System.err.println(collection.stream().reduce((i1, i2) -> i1 + i2).get());
		System.err.println(collection.stream().reduce(0, (i1, i2) -> i1 + i2));
	}

	public static void summaryStatisticsDemo() {
		List<Integer> collection = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		System.err.println(collection.stream().mapToInt(Integer::intValue).summaryStatistics());
	}

	public static void partitionByDemo() {
		List<Person> collection = Arrays.asList(new Person("A", 10), new Person("B", 20), new Person("C", 30), new Person("D", 40), new Person("E", 30));
		System.err.println(collection.stream().collect(Collectors.partitioningBy((Person p) -> p.age >= 18)));
	}

	public static void toMapByDemo() {
		List<Person> collection = Arrays.asList(new Person("A", 10), new Person("B", 20), new Person("C", 30), new Person("D", 40), new Person("E", 50));
		System.err.println(collection.stream().collect(Collectors.toMap((Person p) -> p.age, p -> p)));
	}

	public static void groupByDemo() {
		List<Person> collection = Arrays.asList(new Person("A", 10), new Person("B", 20), new Person("C", 20), new Person("D", 40), new Person("E", 10));
		System.err.println(collection.stream().collect(Collectors.groupingBy((Person p) -> p.age)));
	}

	public static void joiningDemo() {
		List<Person> collection = Arrays.asList(new Person("A", 10), new Person("B", 20), new Person("C", 20), new Person("D", 40), new Person("E", 10));
		System.err.println(collection.stream().map(p -> p.getName()).collect(Collectors.joining(",", "Names: ", ".")));
	}

	interface Transaction {
		default String getType() {
			return "";
		}

		String getID();
	}

	private static List<Transaction> comparing(Transaction transaction) {
		return null;
	}

	private static void shortCircuitDemo() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		List<Integer> twoEvenSquares = numbers.stream().filter(n -> {
			System.out.println("filtering " + n);
			return n % 2 == 0;
		}).map(n -> {
			System.out.println("mapping " + n);
			return n * n;
		}).limit(2).collect(Collectors.toList());

		// this will print only two elements
	}

	private static void createStreams() {
		Stream<Integer> a = Stream.of(12, 12, 12, 12);
		int[] numbers = { 1, 2, 3, 4 };
		IntStream numbersFromArray = Arrays.stream(numbers);
		Stream<Integer> numberStream = Stream.iterate(0, n -> n + 10);
		numberStream.limit(10).forEach(System.out::println);
	}

	private static void filterMapReduceDemo() {
		List<Transaction> transactions = new ArrayList<Transaction>();
		List<String> transactionsIds = transactions.stream().filter(t -> t.getType() == "GROCERY")
		// .sorted(comparing(Transaction::getID).reversed())
				.map(Transaction::getID).collect(Collectors.toList());
	}

	static class Person {
		private String name;
		private int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + "]";
		}

	}
}
