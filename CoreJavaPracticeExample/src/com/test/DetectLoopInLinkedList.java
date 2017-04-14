package com.test;

import java.util.HashMap;
import java.util.Map;

public class DetectLoopInLinkedList {

	public static void main(String[] args) {
		
		Map<String,Integer> m=new HashMap<String, Integer>();
		m.put("a", 31);
		System.out.println("a".hashCode());
		m.put("b", 33);
		System.out.println(m.put("b", 33).hashCode());
		m.put("a", 32);
		System.out.println(m.put("a", 32).hashCode());
		m.put("b", 34);
		System.out.println(m.put("b", 34).hashCode());
		m.put(null, 3);
		System.out.println(m.put(null, 3).hashCode());
		m.put(null, 3);
		System.out.println(m.put(null, 3).hashCode());
		System.out.println(m);

	}

}
