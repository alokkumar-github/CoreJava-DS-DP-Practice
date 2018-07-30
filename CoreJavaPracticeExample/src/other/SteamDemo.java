import java.net.HttpCookie;
import java.security.MessageDigest;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.bouncycastle.crypto.CryptoException;
import org.springframework.util.Base64Utils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import rx.Observable;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

public class SteamDemo {
	static List<Hosting> hostings = new ArrayList<>();
	static {
		hostings.add(new Hosting(1, "liquidweb.com", 80000));
		hostings.add(new Hosting(2, "linode.com", 90000));
		hostings.add(new Hosting(3, "digitalocean.com", 120000));
		hostings.add(new Hosting(4, "aws.amazon.com", 200000));
		hostings.add(new Hosting(5, "mkyong.com", 1));
	}

	public static void findScheduleBySeriesOrSationOrListing(String... ids) {
		final String IVOD_DATABASE_SCHEDULE_API_FIND = "%s/%s/%s=%s";
		String endpoint = "";
		for (String id : ids) {
			endpoint = endpoint + id + ",";
		}
		endpoint = endpoint.substring(0, endpoint.length() - 1);
		endpoint = String.format(IVOD_DATABASE_SCHEDULE_API_FIND, endpoint.split(","));
		System.out.println("endpoint::::::::::::: " + endpoint);
	}

	public static LocalDateTime convert(Long source) {
		LocalDateTime time = null;

		if (source != null)
			time = Instant.ofEpochMilli(source).atZone(ZoneId.of("Z")).toLocalDateTime();
		System.out.println("time::: " + time);
		return time;
	}

	class CryptoUtils {

		private final String TRANSFORMATION = "AES";
		private final String encodekey = "uD06Y1V69908H79W958hBH38tV5G66IB";

		public String encrypt(String inputFile) throws CryptoException {
			return doEncrypt(encodekey, inputFile);
		}

		public String decrypt(String input) throws CryptoException {
			// return doCrypto(Cipher.DECRYPT_MODE, key, inputFile);
			return doDecrypt(encodekey, input);
		}

		private String doEncrypt(String encodekey, String inputStr) throws CryptoException {
			try {

				Cipher cipher = Cipher.getInstance(TRANSFORMATION);

				byte[] key = encodekey.getBytes("UTF-8");
				MessageDigest sha = MessageDigest.getInstance("SHA-1");
				key = sha.digest(key);
				key = Arrays.copyOf(key, 16); // use only first 128 bit

				SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

				cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

				byte[] inputBytes = inputStr.getBytes();
				byte[] outputBytes = cipher.doFinal(inputBytes);

				return Base64Utils.encodeToString(outputBytes);

			} catch (Exception ex) {
				throw new CryptoException("Error encrypting/decrypting file");
			}
		}

		public String doDecrypt(String encodekey, String encrptedStr) {
			try {

				Cipher dcipher = Cipher.getInstance(TRANSFORMATION);
				dcipher = Cipher.getInstance("AES");
				byte[] key = encodekey.getBytes("UTF-8");
				MessageDigest sha = MessageDigest.getInstance("SHA-1");
				key = sha.digest(key);
				key = Arrays.copyOf(key, 16); // use only first 128 bit

				SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

				dcipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
				// decode with base64 to get bytes

				// byte[] dec = Base64Utils.decode(encrptedStr.getBytes());

				byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(encrptedStr);
				byte[] utf8 = dcipher.doFinal(dec);

				// StringBuilder rep = new StringBuilder();
				// for (byte b : dec.getBytes) {
				// rep.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
				// }
				// System.out.println(rep);

				byte[] utf81 = dcipher.doFinal(dec);

				// create new string based on the specified charset
				System.out.println("codddddddddddddv:::::::: " + new String(utf81, "UTF8"));
				return new String(utf81, "UTF8");

			} catch (Exception e) {

				e.printStackTrace();

			}
			return null;
		}
	}

	public static void filter(List<String> numbers, List<String> oddNumbers, List<String> evenNumbers) {
		Map<Boolean, List<String>> partitions = numbers.stream()
				.collect(Collectors.partitioningBy(n -> !"abc".equals(n)));
		evenNumbers.addAll(partitions.get(true));
		oddNumbers.addAll(partitions.get(false));

		// public List<Integer> oddNumbers(List<Integer> numbers) {
		// return numbers.stream().filter(n -> (n % 2) !=
		// 0).collect(Collectors.toList());
		// }
		//
		// public List<Integer> evenNumbers(List<Integer> numbers) {
		// return numbers.stream().filter(n -> (n % 2) ==
		// 0).collect(Collectors.toList());
		// }
	}

	public static void getIT(int id) {
		for (int i = 0; i < 5; i++) {
			System.out.println("find it ..." + i);
			if (id == i) {
				System.out.println("find it ..." + i);
				return;
			}
		}
		System.out.println("nooot........");
	}

	private static void continueUsingJava8() {
		ArrayList<String> stringList = new ArrayList<>();
		stringList.add("continueUsingJava8-a");
		stringList.add("continueUsingJava8-b");
		stringList.add("continueUsingJava8-c");

		stringList.stream().forEach(str -> {
			if (str.equals("continueUsingJava8-b"))
				return; // only skips this iteration.

			System.out.println(str);
		});
	}

	private static void comparing1() {

		// Hosting h1= new Hosting(1, "liquidweb.com", 80000);
		// Hosting h2=new Hosting(2, "linode.com", 90000);
		//
		// Comparator<Employee> employee_Age_Name_Comparator
		// = Comparator.comparing(Employee::getAge)
		// .thenComparing(Employee::getName);
		//
		// Objects.compare(h1, h2, Comparator.comparing(
		//
		// );
		String input1 = "{\"state\":1,\"cmd\":1, \"cmd1\":1}";
		String input2 = "{\"cmd\":1,\"state\":1}";
		ObjectMapper om = new ObjectMapper();
		try {
			Map<String, Object> m1 = (Map<String, Object>) (om.readValue(input1, Map.class));
			Map<String, Object> m2 = (Map<String, Object>) (om.readValue(input2, Map.class));
			System.out.println(m1);
			System.out.println(m2);
			System.out.println(m1.equals(m2));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// private void processInBatch() {
	// final List<String> listToBatch = new ArrayList<>();
	// final List<List<String>> batch = Lists.partition(listToBatch, 10);
	// for (List<String> list : batch) {
	// // Add your code here
	// }
	// }

	public static void getException() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");

		for (String str : list) {
			try {
				System.out.println(str);
				throw new Exception("Exception for string " + str);
			} catch (Exception ex) {
				System.out.println("Caught exception");
			}
		}
	}

	public static void findFirstAndFindAny1() {

		List<Employee> empList = new ArrayList<>();

		Employee ee1 = new Employee(1, "Nataraja G", "Accounts", false, 22222L, null);
		Employee ee2 = new Employee(2, "Nagesh Y", "Accounts", false, 22222L, null);
		Employee ee3 = new Employee(3, "Vasu V", "Admin", false, 22222L, null);
		Employee ee4 = new Employee(4, "Amar", "Security", false, 22222L, null);
		Employee ee5 = new Employee(5, "Alok", "Admin", false, 22222L, null);
		Employee ee6 = new Employee(null, "  ", "", null, null, null);
		Employee ee7 = null;
		Employee ee8 = new Employee(null, null, null, null, null, null);
		Employee ee9 = new Employee(9, "Alok", "Security", false, 22222L, null);

		empList.add(ee1);
		empList.add(ee2);
		empList.add(ee3);
		empList.add(ee4);
		empList.add(ee5);
		empList.add(ee6);
		// empList.add(ee7);
		// empList.add(ee8);
		empList.add(ee9);

		Predicate<Employee> finalPedicate = x -> "Alok1".equals(x.getEmpName());
		Employee result1 = empList.stream() // Convert to steam
				.filter(x -> "Nagesh Y".equals(x.getEmpName()) && "Accounts".equals(x.getAccount())) // we want "jack"
																										// only
				.findAny() // If 'findAny' then return found
				.orElse(null);
		System.out.println("result1::: " + result1.toString());

	}

	public static void findFirstAndFindAny() {

		List<Employee> empList = new ArrayList<>();

		Employee ee1 = new Employee(1, "Nataraja G", "Accounts", false, 22222L, null);
		Employee ee2 = new Employee(2, "Nagesh Y", "Accounts", false, 22222L, null);
		Employee ee3 = new Employee(3, "Vasu V", "Admin", false, 22222L, null);
		Employee ee4 = new Employee(4, "Amar", "Security", false, 22222L, null);
		Employee ee5 = new Employee(5, "Alok", "Admin", false, 22222L, null);
		Employee ee6 = new Employee(null, "  ", "", null, null, null);
		Employee ee7 = null;
		Employee ee8 = new Employee(null, null, null, null, null, null);
		Employee ee9 = new Employee(9, "Alok", "Security", false, 22222L, null);

		empList.add(ee1);
		empList.add(ee2);
		empList.add(ee3);
		empList.add(ee4);
		empList.add(ee5);
		empList.add(ee6);
		// empList.add(ee7);
		// empList.add(ee8);
		empList.add(ee9);

		Predicate<Employee> finalPedicate = x -> "Alok1".equals(x.getEmpName());
		Employee result1 = empList.stream() // Convert to steam
				.filter(x -> "Alok1".equals(x.getEmpName())) // we want "jack" only
				.findAny() // If 'findAny' then return found
				.orElse(null);
		// empList.stream().map(m->m.getEmpName()).collect(Collectors.toList());

		empList.stream().forEach(a -> {
			if (finalPedicate.test(a)) {
				// System.out.println("result1:::: "+a);
			}
		});

		List<Employee> result11 = empList.stream().filter(a -> finalPedicate.test(a)).collect(Collectors.toList());

		System.out.println("result1::::  " + result11);

		Predicate<Employee> nonNullPredicate = Objects::nonNull;
		Predicate<Employee> nameNotNull = p -> p.getAccount() != null;
		Predicate<Employee> adminPredicate = p -> p.getAccount().equals("Admin");
		Predicate<Employee> sequrityPredicate = p -> p.getAccount().equals("Security");
		Predicate<Employee> namePredicate = p -> p.getEmpName().equals("Alok");

		// Predicate<Employee> fullPredicate = nonNullPredicate.and(nameNotNull)
		// .and(adminPredicate).or(sequrityPredicate);
		Predicate<Employee> fullPredicate = nonNullPredicate.and(nameNotNull).and(adminPredicate).or(sequrityPredicate)
				.and(namePredicate);

		List<Employee> teams2 = empList.stream().filter(fullPredicate).collect(Collectors.toList());
		// System.out.println("nemplist::: "+teams2);
		/*
		 * Set<String> carNames = empList.stream() .map(Employee::getAccount)
		 * .collect(Collectors.toSet()); System.out.println("mappppp:::: "+carNames);
		 */

		// Set<String> roleName = new HashSet<>();
		List<String> roleName = new ArrayList<>();
		// roleName.add("Admin");
		// roleName.add("Security");

		// Set<String> empName = new HashSet<>();
		List<String> empName = new ArrayList<>();
		empName.add("Alok");
		// empName.add("Security");

		Predicate<Employee> rolePredicate = p -> {
			// return roleName!=null &&CollectionUtils.isEmpty(roleName) ? false :
			// roleName.contains(p.getAccount());
			return roleName.contains(p.getAccount());
		};

		Predicate<Employee> empPredicate = p -> empName.contains(p.getEmpName());

		Predicate<Boolean> empPredicate11 = Predicate.isEqual(roleName != null && CollectionUtils.isEmpty(roleName));

		List<Employee> listOutput1 = empList.stream().filter(rolePredicate).collect(Collectors.toList());
		// System.out.println("listOutput1:::: "+listOutput1);

		if (empPredicate11.test(true)/* CollectionUtils.isEmpty(listOutput1) */) {
			List<Employee> listOutput2 = empList.stream().filter(empPredicate).collect(Collectors.toList());
			// System.out.println("listOutput2:::: "+listOutput2);
		}
		if (empPredicate11.test(false)) {
			Predicate<Employee> fullPredicate1 = rolePredicate.and(empPredicate);
			List<Employee> listOutput = empList.stream()
					.filter(fullPredicate1/* e -> listCarName.contains(e.getAccount()) */).collect(Collectors.toList());
			// System.out.println("listOutput:::: "+listOutput);
		}

		// empList.stream().filter(emp->emp.getAccount().matches("Admin","Security"))
		// .findFirst()
		// .ifPresent(System.out::println);

		// empList.stream().filter(emp->emp.getAccount().matches("Admin"))
		// .findAny()
		// .ifPresent(System.out::println);

		// System.out.println(Stream.of(2, 3, 12).collect(allMatchingOneOf(i -> i % 2 ==
		// 0, i -> i % 3 == 0)));
	}

	public static void parseCookie() {
		String cookieAsString = "131=gM8oHmcC4QoumLgjKkR_eG26WbV_vRJf4O3hKeslMj_lsyYVqfICloK3rEpAQ7bh30ow0ZLMuAnUenpqIN-4z3bzjzdSrkwvgieERbGYYPMQz-8uKY3smodZTnoIx-sa";
		List<HttpCookie> cookiesList = HttpCookie.parse(cookieAsString);
		StringBuilder myCookieAsStringNow = new StringBuilder();
		for (HttpCookie httpCookie : cookiesList) {
			myCookieAsStringNow.append(httpCookie.getName());
			myCookieAsStringNow.append(httpCookie.getPath());
		}
		System.out.println("parsed Cookie:::: " + myCookieAsStringNow.toString());
	}

	public static <T> Object[] concate(T[] a, T[] b) {
		return Stream.of(a, b).flatMap(Stream::of).toArray();
	}

	public static Boolean getPartner() {
		String part = "comcast~ivod-test";
		String[] parts = StringUtils.split(part, "~");
		// Arrays.stream(parts).filter(p -> "comcast".equals(p)).forEach(p ->
		// System.out.println(p));
		Boolean ismatch = null;// Arrays.stream(parts)
		// .anyMatch(p -> "Comcast".equalsIgnoreCase(p) ||
		// "ivod-test".equalsIgnoreCase(p));
		System.out.println("parts::: " + parts + " match:: " + ismatch);
		return ismatch;
	}

	public static void uniqueId() {

		List<Emp> emplist = Arrays.asList(new Emp("a1", "emp1", null, null, null),
				new Emp("a2", "emp2", null, null, null), new Emp("a3", "emp3", null, null, null),
				new Emp("a1", "emp4", null, null, null), new Emp("a1", "emp5", null, null, null));

		List<Emp> unique = emplist.stream().collect(
				collectingAndThen(toCollection(() -> new TreeSet<>(comparing(Emp::getEmpNo))), ArrayList::new));
		// List<Emp> duplicateList =new ArrayList<Emp>();
		/*
		 * for (Emp o : emplist) { if (!unique.contains(o)) {
		 * System.out.println("repeatone ::: "+o); duplicateList.add(o); } }
		 */
		List<Emp> duplicateList = emplist.stream().filter(f -> !unique.contains(f)).collect(Collectors.toList());
		System.out.println("odd11 ::: " + duplicateList);

		// for(Emp d:duplicateList) {
		// int i =0;
		// for(Emp u: unique) {
		// if(d.getEmpNo().equals(u.getEmpNo())){
		// StringBuilder ename = new StringBuilder(u.getEmpName());
		// //if(i == 0) {
		//
		// ename =ename.append(d.getEmpName());
		// //}
		// System.out.println("odd::: "+u);
		// u.setEmpName(ename.toString());
		// }
		// }
		// }

		duplicateList.stream().forEach(d -> {
			unique.stream().forEach(u -> {

				if (d.getEmpNo().equals(u.getEmpNo())) {
					StringBuilder ename = new StringBuilder(u.getEmpName());
					// if(i == 0) {

					ename = ename.append(d.getEmpName());
					// }
					System.out.println("odd::: " + u);
					u.setEmpName(ename.toString());
				}
			});

		});

		// duplicateList.stream().filter(d->unique.stream().allMatch(u->{
		//
		// d.getEmpNo().equals(u.getEmpNo());
		// StringBuilder ename = new StringBuilder(u.getEmpName());
		// //if(i == 0) {
		//
		// ename =ename.append(d.getEmpName());
		// //}
		// System.out.println("odd::: "+u);
		// u.setEmpName(ename.toString());
		// })).collect(Collectors.toList());

		// Predicate<Emp> notIn2 = s -> !
		// duplicateList.stream().filter(p->p.getEmpNo().equals(anObject))
		// List<String> list3 =
		// list1.stream().filter(notIn2).collect(Collectors.toList());

		//

		System.out.println("unique::: " + unique);

	}

	private static void flatMapee() {
		String[][] data = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };
		// Stream<String[]>
		Stream<String[]> temp = Arrays.stream(data);
		// temp.forEach(System.out::println);

		// Stream<String>
		Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x));
		stringStream.forEach(System.out::println);
	}

	private static void collectVsReduce() {

	}

	private static void stat() {
		// Stream is a new abstract layer introduced in Java 8. Using stream, you can
		// process data in a declarative way similar to SQL statements
		// and leverage multicore architecture without the need to write any specific code for it.
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());

		// sorting
		Random random = new Random();
		random.ints().limit(10).sorted().forEach(System.out::println);
	}

	public static void main(String[] args) throws InterruptedException {

		System.exit(0);

		flatMapee();

		uniqueId();

		if (getPartner()) {
			System.out.println("inside getPartner()");
		}

		findFirstAndFindAny1();

		// parseCookie();

		Address[] add1 = { new Address("11", "22"), new Address("33", "44") };

		Address[] add2 = { new Address("111", "222"), new Address("333", "444"), new Address("555", "444") };
		Address[] add3 = { new Address("11", "222"), new Address("333", "222") };

		// [Address [zipcode=11, street=22], Address [zipcode=111, street=222],
		// Address [zipcode=33, street=44], Address [zipcode=333, street=444], Address
		// [zipcode=555, street=444]]
		// Address[] finalAdds = (Address[]) ArrayUtils.add(add1, null);
		// Address[] finalAdds = (Address[]) ArrayUtils.add(add2, null);

		Stream.of(add1);

		Object[] finalAdds = null;
		// finalAdds = Stream.of(add1,add2).flatMap(Stream::of).toArray();
		finalAdds = Stream.of(add1).flatMap(Stream::of).toArray();
		finalAdds = Stream.of(finalAdds, add2).flatMap(Stream::of).toArray();
		finalAdds = Stream.of(finalAdds, add3).flatMap(Stream::of).toArray();

		// Address[] finalAdds = (Address[]) ArrayUtils.addAll(ArrayUtils.add(add1,
		// null), ArrayUtils.add(add2, null));

		// Address[] finalAdds = (Address[]) ArrayUtils.addAll(add1, add2);
		// finalAdds = (Address[])finalAdds;
		Address[] stringArrayX = Arrays.copyOf(finalAdds, finalAdds.length, Address[].class);

		System.out.println("finalAdds::: " + stringArrayX);
		Stream<Address> stream1 = Arrays.stream(stringArrayX);
		// Set<Address> set =
		// stream1.filter(p->!p.getZipcode().equals(p.getZipcode())).collect(Collectors.toSet());

		Set<Address> set = stream1.collect(Collectors
				.toCollection(() -> new TreeSet<Address>((p1, p2) -> p1.getZipcode().compareTo(p2.getZipcode()))));
		System.out.println("finalAdds --- set::: " + set);
		List<Address> addresslist = new ArrayList<Address>(set);
		System.out.println("finalAdds --- aa::: " + addresslist);
		// Set<Address> set = stream1.collect(Collectors.toSet());

		// Observable.from(stream1).distinct(Address::getZipcode);
		// Observable<Address> stringArrayX1 =
		// Observable.from(stringArrayX).distinct(Address::getZipcode);
		// stringArrayX1.subscribe(
		// i -> result += i, //OnNext
		// Throwable::printStackTrace, //OnError
		// () -> result += "_Completed" //OnCompleted
		// );

		// System.out.println("finalAdds --- set::: "+stringArrayX1);

		// getException();

		findFirstAndFindAny();

		List<Employee> elist = new ArrayList<>();

		Employee ee1 = new Employee(1, "Alok1", "", false, 22222L, null);
		Employee ee2 = new Employee(2, "Alok2", "", false, 22222L, null);
		Employee ee3 = new Employee(3, "Alok1", "", false, 22222L, null);
		Employee ee4 = new Employee(4, "Alok2", "", false, 22222L, null);
		Employee ee5 = new Employee(5, "Alok3", "", false, 22222L, null);
		Employee ee6 = new Employee(null, "  ", "", null, null, null);
		Employee ee7 = null;
		Employee ee8 = new Employee(null, null, null, null, null, null);

		elist.add(ee1);
		elist.add(ee2);
		elist.add(ee6);
		elist.add(ee7);

		for (Employee e : elist) {
			if (e == null || StringUtils.isBlank(e.getEmpName())) {
				continue;
			}
			// System.out.println("sssss ::: "+e);
		}

		for (int i = 0; i < 5; i++) {
			if (i == 2 || i == 3) {
				continue;
			}

			// System.out.print("sssss ::: "+i + ",");
		}

		List<Employee> emplist1 = new ArrayList<Employee>(Arrays.asList(ee7, ee8, ee1, ee6, ee4));
		if (emplist1.isEmpty())
			System.out.println("emplist1::: " + emplist1);
		else {
			System.out.println("not empty::: " + emplist1);
		}

		emplist1 = emplist1.stream()
				.filter(c -> null != c && null != c.getEmpNo() && StringUtils.isNotBlank(c.getEmpName()))
				.collect(Collectors.toList());
		;
		System.out.println("nemplist1::: " + emplist1);

		List<String> list11 = new ArrayList<String>(Arrays.asList("A", "B", "C"));
		List<String> list22 = new ArrayList<String>(Arrays.asList("B", "C", "D", "E", "F"));

		List<String> intersect = list11.stream().filter(list22::contains).collect(Collectors.toList());

		// System.out.println("intersection::::: "+intersect);

		List<Integer> list1a = Arrays.asList(1, 2, 3);
		List<Integer> list2a = Arrays.asList(1, 2, 4, 5);

		ArrayList<Integer> intersection = new ArrayList<Integer>(list1a);
		intersection.removeAll(list2a);
		System.out.println("Remove: " + intersection); // 3

		List<Integer> diff = list1a.stream().filter(i -> !list2a.contains(i)).collect(Collectors.toList());

		System.out.println("diff: " + diff); // 3

		List<Employee> list1 = Arrays.asList(ee1, ee2);
		List<Employee> list2 = Arrays.asList(ee1, ee2, ee3, ee4, ee5);

		// List<Employee> intersectresult = list1.stream()
		// .flatMap(one -> list2.stream()
		// .filter(two -> one.getEmpName().equals(two.getEmpName()))
		// .map(two -> new Employee(one, two)))
		// .collect(Collectors.toList());

		// Map<String,List<Employee>> tmp=list1.stream()
		// .collect(Collectors.groupingBy(Employee::getEmpName));

		// List<Employee> result = list2.stream()
		// .flatMap(two -> tmp.getOrDefault(two.getEmpName(), Collections.emptyList())
		// .stream().map(one -> new RootSampleClass(one, two)))
		// .collect(Collectors.toList());

		Map<String, Employee> tmp = list1.stream().collect(Collectors.toMap(Employee::getEmpName, Function.identity()));
		System.out.println("temp::::: " + tmp);
		List<RootSampleClass> intersectresult = list2.stream().filter(two -> tmp.containsKey(two.getEmpName()))
				.map(two -> new RootSampleClass(tmp.get(two.getEmpName()), two)).collect(Collectors.toList());

		System.out.println("intersection::::: " + intersectresult);

		// List<Employee> union = Stream.concat(list1.stream(),
		// list2.stream()).distinct().collect(Collectors.toList());
		// System.out.println("union::::: "+union);

		Employee[] a = { new Employee(null, null, null, null, null, null) };

		List<Emp> emplist = Arrays.asList(new Emp("a1", null, null, null, null), new Emp("a2", null, null, null, null),
				new Emp("a3", null, null, null, null), new Emp("a1", null, null, null, null));

		long count = emplist.stream().count();
		Emp lastEmp = emplist.stream().filter(Objects::nonNull).skip(emplist.stream().count() - 1).findFirst().get();

		// System.out.println("last emp LLLLLLLL "+lastEmp);

		if (null != a && a.length > 0) {
			// System.out.println("came here");
		}

		List<String> valueList = new ArrayList<>();
		valueList.add("Joe");
		valueList.add("John");
		valueList.add("Sean");

		Stream<Emp> stream = emplist.stream();
		stream.reduce((first, second) -> second).orElse(null);
		System.out.println("lastONNNN:::: " + stream);

		// Optional.
		// Stream.of(empNo, name).allMatch(Objects::isNull);
		Emp emps = new Emp("", "ak", null, null, new Address(null, null));
		if (Arrays.asList(emps).stream().allMatch(x -> x == null)) {
			// System.out.println("came here1");
		}
		Optional<Emp> opt = Optional.ofNullable(emps);

		// System.out.println("Optional::::::::: "+opt);

		// System.out.println("isAllNull():::::: "+Emp.isAllNull(emps));

		// if(StringUtils.isBlank(Arrays.asList(a)))
		// {...}

		comparing1();
		// continueUsingJava8();

		// getIT(2);

		List<String> numbers = Arrays.asList("spring", "node", "abc", "abc");
		List<String> oddNumbers = new ArrayList<String>();
		List<String> evenNumbers = new ArrayList<String>();
		filter(numbers, oddNumbers, evenNumbers);

		// System.out.println(" filter::::::::::::: "+ numbers+" "+oddNumbers+ " "+
		// evenNumbers);

		long mill = LocalDateTime.now().atZone(ZoneOffset.UTC).toInstant().toEpochMilli();
		ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
		long mill1 = utc.toInstant().toEpochMilli();
		// System.out.println("utc::::::::::: "+utc);
		// System.out.println("milllll---::::::::::: "+mill1);
		// System.out.println("LocalDateTime.now():::::::::::
		// "+LocalDateTime.now().atZone(ZoneOffset.UTC));
		// System.out.println("milllll::::::::::: "+mill);

		new SteamDemo().new CryptoUtils().doDecrypt("uD06Y1V69908H79W958hBH38tV5G66IB",
				"9cf05b5a93604ed7828a5ba226ff7b8ce1c290c4ab5cc861a02424e70f09247f");

		// findScheduleBySeriesOrSationOrListing("https://ivod-database-api.g4.app.cloud.comcast.net",
		// "schedule/search",
		// "findByMerlinListingId?merlinListingId", "123");
		int[] ns = new int[] { 1, 2, 3, 4, 5 };
		// Arrays.stream(ns).map(n -> n * 2).forEach(n->System.out.println(n));
		int[] ms = Arrays.stream(ns).map(n -> n * 2).filter(n -> n % 4 == 0).toArray();
		// System.out.println(Arrays.toString(ms));

		Map<Integer, Hosting> map = hostings.stream().collect(Collectors.toMap(x -> x.getId(), x -> x));
		// System.out.println(map);

		String s1 = "";
		// List<Hosting> hostings=null;
		hostings.stream() // convert list to stream
				// .map(s->s.setName("AK"))
				.filter(s -> !"linode.com".equals(s.getName())) // we dont like
																// mkyong
				.forEach(s -> myMethod(s, s1)); // collect the output and
												// convert streams to a List

		// result.forEach(System.out::println);

		Employee e1 = new Employee();
		e1.setEmpNo(2);
		e1.setEmpName("Alok");
		e1.setEmpClass(false);
		e1.setEmpSal(22222L);
		e1.setEmpGender(EmpGender.valueOf("Female"));

		Employee e2 = new Employee();
		e2.setEmpNo(2);
		e2.setEmpName("Alok");
		e2.setEmpClass(false);
		e2.setEmpSal(22222L);
		e2.setEmpGender(EmpGender.valueOf("Male"));

		// System.out.println(e1.equals(e2));

		Employee e3 = e2;
		Employee e4 = e1;
		Employee e5 = e2;

		// convert(1503113400000L);

		LocalDateTime ldt = LocalDateTime.now();
		// System.out.println(ldt);
		// Employee e3 = null;
		// System.out.println("e3::::::::: " + e3.toString());

		// List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
		// 14);

		List<Employee> list = Arrays.asList(e1, e2, e3, e4, e5);

		// System.out.println("By 3:");
		batches(list, 3).forEach(System.out::println);

		// System.out.println("By 4:");
		batches(list, 4).forEach(System.out::println);

		String endpoint = String.format(IVOD_DATABASE_SCHEDULE_API_FIND_BY_STATION, url,
				"merlin:linear:station:" + stationId);
		// System.out.println("endPoint::::::: "+endpoint);
		//
		// System.out.println("sdddd:: "+ScheduleType.valueOf("STATION"));
		//
		// System.out.println("sdddd111:: "+ScheduleType.LISTING.toString());

		List<String> stationList = null;

		if (!CollectionUtils.isEmpty(stationList)) {
			// System.out.println("come");
		}
		// get();

		Long l1 = 1505445161000L;
		Long l2 = 1505445160000L;
		if (l1 > l2) {
			// System.out.println("sjfkljksadlfjdklajkl");
		}

		int page = 0;
		Long totalPage = null;
		do {
			totalPage = 2L;
			// System.out.println("totalPage {} "+totalPage+" page {} "+page);
			page = ++page;

		} while (totalPage > page);

	}

	static String url = "https://ivod-database-api.g4.app.cloud.comcast.net";
	static String stationId = "1230000";
	static String IVOD_DATABASE_SCHEDULE_API_FIND_BY_STATION = "%s/schedule?merlinStationId=%s";

	public static <T> Stream<List<T>> batches(List<T> source, int length) {
		if (length <= 0)
			throw new IllegalArgumentException("length = " + length);
		int size = source.size();
		if (size <= 0)
			return Stream.empty();
		int fullChunks = (size - 1) / length;
		return IntStream.range(0, fullChunks + 1)
				.mapToObj(n -> source.subList(n * length, n == fullChunks ? size : (n + 1) * length));
	}

	public static void myMethod(Hosting name, String s) {
		// System.out.println(name);
	}

	public static void get() {
		UriComponentsBuilder uri = UriComponentsBuilder
				.fromHttpUrl("https://ivod-database-api.g4.app.cloud.comcast.net");
		uri.pathSegment("streamRecording");
		uri.queryParam("size", 1000);
		uri.queryParam("page", 1);

		/*
		 * if (!CollectionUtils.isEmpty(null)) { String partners =
		 * partnerIds.stream().collect(Collectors.joining(","));
		 * uri.queryParam("partnerId", partners); }
		 * 
		 * if (!CollectionUtils.isEmpty(null)) { String stations =
		 * stationList.stream().collect(Collectors.joining(","));
		 * uri.queryParam("merlinStationId", stations); }
		 * 
		 * if (!CollectionUtils.isEmpty(seriesList)) { String series =
		 * seriesList.stream().collect(Collectors.joining(","));
		 * uri.queryParam("merlinSeriesId", series); }
		 * 
		 * if (!CollectionUtils.isEmpty(scheduleList)) { String schedules =
		 * scheduleList.stream().collect(Collectors.joining(","));
		 * uri.queryParam("scheduleUuid", schedules); }
		 * 
		 * if (!CollectionUtils.isEmpty(recordingList)) { String recordings =
		 * recordingList.stream().collect(Collectors.joining(","));
		 * uri.queryParam("recordingUuid", recordings); }
		 */
		if (!CollectionUtils.isEmpty(Arrays.asList("2001154110071330109"))) {
			String listings = Arrays.asList("2001154110071330109").stream().collect(Collectors.joining(","));
			uri.queryParam("merlinListingId", listings);
		}
		/*
		 * if (!CollectionUtils.isEmpty(streamList)) { String streams =
		 * streamList.stream().collect(Collectors.joining(","));
		 * uri.queryParam("merlinStreamId", streams); }
		 */
		String url = uri.toUriString();
		System.out.println("getRecordingByLimit()- final url->> " + url);
	}

}

class RootSampleClass {
	Employee one;
	Employee two;

	public RootSampleClass(Employee one, Employee two) {
		super();
		this.one = one;
		this.two = two;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RootSampleClass [one=");
		builder.append(one);
		builder.append(", two=");
		builder.append(two);
		builder.append("]");
		return builder.toString();
	}

}

class Hosting {

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getWebsites() {
		return websites;
	}

	public void setWebsites(long websites) {
		this.websites = websites;
	}

	private int Id;
	private String name;
	private long websites;

	public Hosting(int id, String name, long websites) {
		Id = id;
		this.name = name;
		this.websites = websites;
	}

	@Override
	public String toString() {
		return "Hosting [Id=" + Id + ", name=" + name + ", websites=" + websites + "]";
	}

}

class Emp {

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpClass() {
		return empClass;
	}

	public void setEmpClass(String empClass) {
		this.empClass = empClass;
	}

	public String getEmpSal() {
		return empSal;
	}

	public void setEmpSal(String empSal) {
		this.empSal = empSal;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(String empNo, String empName, String empClass, String empSal, Address address) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.empClass = empClass;
		this.empSal = empSal;
		this.address = address;
	}

	private String empNo;
	private String empName;
	private String empClass;
	private String empSal;

	private Address address;

	static boolean isAllNull(final Object... values) {
		// return Stream.of(empNo,
		// empName,empClass,empSal,address).allMatch(Objects::isNull);
		if (values == null) {
			return false;
		}

		for (final Object val : values) {
			if (val == null) {
				return false;
			}
		}

		return true;
	}

	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", empName=" + empName + ", empClass=" + empClass + ", empSal=" + empSal
				+ ", address=" + address + "]";
	}

}

class Address {
	private String zipcode;
	private String street;

	public Address(String zipcode, String street) {
		super();
		this.zipcode = zipcode;
		this.street = street;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Address [zipcode=" + zipcode + ", street=" + street + "]";
	}

}
