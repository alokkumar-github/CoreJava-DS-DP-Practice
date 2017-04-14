package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class HashMapDemo {

	private static void hashSetTest() {
		Set<String> hm = new HashSet<String>(2);
		hm.add("a");
		hm.add("b");
		hm.add("a");
		hm.add(null);
		System.out.println("sizeNow  1 ::" + hm.size());
		hm.add("c");
		System.out.println("sizeNow   2 ::" + hm.size());
		hm.add("a");
		System.out.println("sizeNow   3 ::" + hm.size());
		hm.add("d");
		System.out.println("sizeNow   4 ::" + hm.size());
		hm.add(null);
		System.out.println(hm);
		Iterator<String> itr=hm.iterator();
		while(itr.hasNext()){
			String str=(String)itr.next();
			System.out.println(str);
		}
	}

	public static void concurentModificationException(){
		//concept 6: we concurrent modificationException 
		//occur if we remove element while iterate list.
		List<Integer> ls=new ArrayList<Integer>();
		for(int i=1;i<10;i++){
			ls.add(i);
		}
		System.out.println("Before Deleting List::"+ls);
		Iterator<Integer> itr=ls.iterator();
		while(itr.hasNext()){
			int i=4, j=4;
			if(i==4)
				ls.remove(i);
				
		} //or
		/*for(Integer i:ls){
			if(i==1)
				ls.remove(i);
		}*/
		// using iter we can remove the element
		for (Iterator<Integer> iter = ls.iterator(); iter.hasNext();) {
		      Integer s = iter.next();
		      if (s==1) {
		        iter.remove();
		      }
		      else {
		        System.out.println(s);
		      }
		    }
		System.out.println("After Deleting List ::: "+ls);
	}
	public static void main(String str[]) {
		//hashSetTest();
		//concurentModificationException();
	
		 //hashSetTest();
		 //hashSetCoustomKey();
		// hashMapT();
		 hashMapCoustomKey();
		// treemap();
		//treemapCustomKey();
		//terreMapCusomkeyByComparator();
		//concurentModificationException();
		//sortByValues();
	}
	private static void terreMapCusomkeyByComparator() {
		// Concept 4:By using name comparator (String comparison);
		TreeMap<Empl, Integer> tm = new TreeMap<Empl, Integer>(new MyNameComp());
		tm.put(new Empl("A"), 9); // pass the comparator constructor;
		tm.put(new Empl("L"), 90);
		tm.put(new Empl("R"), 80);
		tm.put(new Empl("B"), 99);
		Set<Empl> keys = tm.keySet();
		for (Empl key : keys) {
			System.out.println(key + " ==> " + tm.get(key));
		}
	}

	private static void sortbyvalue(){
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
	      hmap.put(5, "A");
	      hmap.put(11, "C");
	      hmap.put(4, "Z");
	      hmap.put(77, "Y");
	      hmap.put(9, "P");
	      hmap.put(66, "Q");
	      hmap.put(0, "R");
	      System.out.println("Before Sorting:");
	      Set set = hmap.entrySet();
	      Iterator iterator = set.iterator();
	      while(iterator.hasNext()) {
	           Map.Entry me = (Map.Entry)iterator.next();
	           System.out.print(me.getKey() + ": ");
	           System.out.println(me.getValue());
	      }
	      Map<Integer, String> map = sortByValues(hmap); 
	      System.out.println("After Sorting:");
	      Set set2 = map.entrySet();
	      Iterator iterator2 = set2.iterator();
	      while(iterator2.hasNext()) {
	           Map.Entry me2 = (Map.Entry)iterator2.next();
	           System.out.print(me2.getKey() + ": ");
	           System.out.println(me2.getValue());
	      }
	}
	private static HashMap sortByValues(HashMap map) { 
	       List list = new LinkedList(map.entrySet());
	       // Defined Custom Comparator here
	       Collections.sort(list, new Comparator() {
	            public int compare(Object o1, Object o2) {
	               return ((Comparable) ((Map.Entry) (o1)).getValue())
	                  .compareTo(((Map.Entry) (o2)).getValue());
	            }
	       });

	       // Here I am copying the sorted list in HashMap
	       // using LinkedHashMap to preserve the insertion order
	       HashMap sortedHashMap = new LinkedHashMap();
	       for (Iterator it = list.iterator(); it.hasNext();) {
	              Map.Entry entry = (Map.Entry) it.next();
	              sortedHashMap.put(entry.getKey(), entry.getValue());
	       } 
	       return sortedHashMap;
	  }
	private static void SortByKey() {
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		hmap.put(5, "A");
		hmap.put(11, "C");
		hmap.put(4, "Z");
		hmap.put(77, "Y");
		hmap.put(9, "P");
		hmap.put(66, "Q");
		hmap.put(0, "R");

		System.out.println("Before Sorting:");
		Set set = hmap.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry me = (Map.Entry) iterator.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
		/*
		 * for(Entry<String, String> entry : entries){
		 * System.out.println(entry.getKey() + " ==> " + entry.getValue()); }
		 */
		Map<Integer, String> map = new TreeMap<Integer, String>(hmap);
		System.out.println("After Sorting:");
		Set set2 = map.entrySet();
		Iterator iterator2 = set2.iterator();
		while (iterator2.hasNext()) {
			Map.Entry me2 = (Map.Entry) iterator2.next();
			System.out.print(me2.getKey() + ": ");
			System.out.println(me2.getValue());
		}
	}

	private static void arryrlist() {

	}

	private static void linkeeedlist() {

	}

	private static void CopyOnWriteArrayListll() {
		List ll = new CopyOnWriteArrayList();
	}

	private static void CopyOnWritesetll() {
		Set ll = new CopyOnWriteArraySet();
	}
/*
 *  1. TreeMap in Java using natural ordering of keys
	TreeMap naturalOrderMap = new TreeMap();
	
	2. TreeMap with custom sorting order
	TreeMap customSortingMap = new TreeMap(Comparator comparator)
	Objects stored in this TreeMap will be ordered according to given Comparator.
	
	3. TreeMap from existing SortedMap
	
	TreeMap sameOrderMap = new TreeMap(SortedMap sm)
	

 */
	private static void treemapCustomKey() {
		Map<Employee, Integer> ll = new TreeMap<Employee, Integer>();
		ll.put(new Employee("a"), 3);// Concept 1 ::
										// java.lang.ClassCastException:
										// collection.Employee cannot be cast to
										// java.lang.Comparable.
										// so employee class should implements
										// Comparable interface or use Comparator
										// (see  .terreMapCusomkeyByComparator example)
		ll.put(new Employee("b"), 0);
		ll.put(new Employee("c"), 8);
		ll.put(new Employee("d"), 10);
		ll.put(new Employee("d"), null);
		ll.put(new Employee("d"), 6);
		// ll.put(null, 6); does not allow null
		System.out.println(ll);
	}

	private static void hashMapCoustomKey() {
		Map map = new HashMap();
		map.put(new Employee("a"), 1);
		map.put(new Employee("b"), 1);
		map.put(new Employee("c"), 1);
		map.put(new Employee("d"), 6);
		map.put(new Employee("e"), 1);
		map.put(new Employee("a"), 19);
		// and duplicate key will be added.
		System.out.println(map);
		System.out.println(map.get(new Employee("d")));
		// **Concept 2. this will return null .if we have not to ovrride
		// hashcode and equal method

	}

	private static void hashMapT() {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		Integer m1 = hm.put("a1", 21);
		Integer m2 = hm.put(null, 11);
		Integer m3 = hm.put(null, null);
		Integer m4 = hm.put("b1", 31);
		Integer m5 = hm.put("a1", 32);
		Integer m6 = hm.put("a1", 51);
		Integer m7 = hm.put(null, 53);//
		Integer m8 = hm.put(null, null);//
		Integer m9 = hm.put("a1", 52);
		Integer m10 = hm.put("a1", 50);
		
		System.out.println("m1="+m1 + "\t" + "m2="+m2 + "\t" + "m3="+m3 + 
				"\t" + "m4="+m4 + "\t" + "m5="+m5 + "\t" + "m6="+m6 + "\t" 
				+ "m7="+m7 + "\t" + "m8="+m8 + "\t"+ "m9="+m9 + "\t"+ "m10="+m10 + "\t");
		System.out.println(hm);
		
		HashMap newmap = new HashMap();
	      
		   // populate hash map
		   newmap.put(1, "tutorials");
		   newmap.put(2, "point");
		   String newvalue= (String) newmap.put(3, "is best");
		   System.out.println("Map value before change: "+ newmap);
		      
		   // put new values at key 3
		   String prevvalue=(String)newmap.put(3,"is great");
		      
		   // check returned previous value
		   System.out.println("newvalue\t"+newvalue+"\tReturned previous value: "+ prevvalue);
		      
		   System.out.println("Map value after change: "+ newmap);
	}

	private static void hashSetCoustomKey() {
		Set map = new HashSet();
		map.add(new Employee("a"));
		map.add(new Employee("b"));
		map.add(new Employee("c"));
		map.add(new Employee("a"));
		// Concept 3 :: Set will add duplicate value . if you don't override
		// hashcode and equal
		System.out.println(map);
	}

	private static void identiyhashmapTest() {
		Map ihm = new IdentityHashMap<>();
	}

	private void weakMapTest() {
		Map weak = new WeakHashMap();

		Map map = new HashMap();
		{
			String weakkey = new String("weakkey");
			weak.put(weakkey, 3);
			String key1 = new String("key");
			map.put(key1, 5);
			weakkey = null;
			key1 = null;
		}
		System.gc();
		/*
		 * Concept 4 :: You can see that there is no entry in weak Map. reason
		 * is that as we make weakkey as null the corresponsing value is no
		 * longer referred from any part of program and eligible for GC. But in
		 * case of map key and value remain seated present in map.
		 */
	}
}

class Employee implements Comparable<Employee> {
	private String name;
	private String jobTitle;
	private int age;
	private int salary;

	public Employee(String name) {
		this.name = name;
	}

	public Employee(String name, String jobTitle, int age, int salary) {
		this.name = name;
		this.jobTitle = jobTitle;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}*/

	public String toString() {
		return String.format("%s\t%s\t%d\t%d", name, jobTitle, age, salary);
	}

	@Override
	public int compareTo(Employee o) {
		return this.name.compareTo(o.getName());
	}
}

class EmployeeNameCompartor implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}

}

class MyNameComp implements Comparator<Empl> {

	/*
	 * @Override // accending order public int compare(Empl e1, Empl e2) {
	 * return e1.getName().compareTo(e2.getName()); }
	 */
	@Override // Decending Order
	public int compare(Empl e1, Empl e2) {
		return e2.getName().compareTo(e1.getName());
	}
}

class Empl {

	private String name;

	Empl(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Empl [name=" + name + "]";
	}

}