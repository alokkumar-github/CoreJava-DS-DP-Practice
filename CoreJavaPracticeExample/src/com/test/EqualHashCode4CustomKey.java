package com.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EqualHashCode4CustomKey {

	public static void main(String[] args) {
	
		//EmployeeKey ek1=new EmployeeKey(100,"10101984");
		//System.out.println(empCache().get(ek1)); // This will be null if you comment hashCode implementation.
		empchache1();
		

	}
	
	static void empchache1(){
		
		EmployeeKey ek2=new EmployeeKey(101,"14101984");
		EmployeeKey ek3=new EmployeeKey(102,"13101984");
		EmployeeKey ek4=new EmployeeKey(104,"12101984");
		EmployeeKey ek5=new EmployeeKey(101,"14101984");
		EmployeeKey ek6=new EmployeeKey(102,"13101984");
		EmployeeKey ek7=new EmployeeKey(106,"12101984");
		
		Set<EmployeeKey> s=new HashSet<EmployeeKey>();
		s.add(ek2);
		s.add(ek3);
		s.add(ek4);
		s.add(ek5);
		s.add(ek6);
		s.add(ek7);
		System.out.println(s); // this will include the duplicate key if you comment hashcode implementaion.
	}
	
	static Map<EmployeeKey,String> empCache(){
		Map<EmployeeKey, String> map=new HashMap<EmployeeKey, String>();
		EmployeeKey ek1=new EmployeeKey(100,"10101984");
		EmployeeKey ek2=new EmployeeKey(101,"14101984");
		EmployeeKey ek3=new EmployeeKey(102,"13101984");
		EmployeeKey ek4=new EmployeeKey(104,"12101984");
		map.put(ek1, "alok");
		map.put(ek2, "kumar");
		map.put(ek3, "ak");
		map.put(ek4, "akumar");
		System.out.println(map);
		return map;
	}

}
class EmployeeKey{
	int id;
	String dob;
	public EmployeeKey(int id,String dob) {
		this.id=id;
		this.dob=dob;
	}
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + id;
		return result;
	}*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeKey other = (EmployeeKey) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EmployeeKey [id=" + id + ", dob=" + dob + "]";
	}
	
}