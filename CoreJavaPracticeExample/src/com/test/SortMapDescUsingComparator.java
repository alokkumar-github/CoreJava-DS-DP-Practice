package com.test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortMapDescUsingComparator {

	public static void main(String[] args) {
		Map<String, Integer> lMap=new HashMap<String, Integer>();
	    lMap.put("A", 35);
	    lMap.put("B", 25);
	    lMap.put("C", 50);

	    MyComparator comp=new MyComparator(lMap);
	    System.out.println(comp);

	}

}
class MyComparator implements Comparator {

Map map;

public MyComparator(Map map) {
    this.map = map;
}

public int compare(Object o1, Object o2) {

    return ((Integer) map.get(o2)).compareTo((Integer) map.get(o1));

}
}