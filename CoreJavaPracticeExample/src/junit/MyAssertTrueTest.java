/*package junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyAssertTrueTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
    public void mySimpleEqualsTest(){
         
        String expectedName = "Nattu";
        assertEquals(expectedName, Employee.getEmpNameWithHighestSalary());
    }
     
    @Test
    public void myObjectEqualsTest(){
         
        Employee expectedEmpObj = new Employee(1, "Nattu", 15000);
        assertEquals(expectedEmpObj, Employee.getHighestPaidEmployee());
        assertNull(expectedEmpObj, Employee.getHighestPaidEmployee());
    }
    
    
     
    @Test
    public void evenNumberTest(){
    	MyAssertEqualsTest asft = new MyAssertTrueTest();
        assertFalse(asft.isEvenNumber(3));
        assertTrue(asft.isEvenNumber(3));
    }
    
    @Test
    public void test(){
        MyAssertNotNullTest msnt = new MyAssertNotNullTest();
        assertNotNull(msnt.getPropValue("key1"));
    }
public boolean isEvenNumber(int number){
        
        boolean result = false;
        if(number%2 == 0){
            result = true;
        }
        return result;
    }

public String getPropValue(final String key){
    Map<String, String=""> appProps = new HashMap<String, String="">();
    appProps.put("key1", "value 1");
    appProps.put("key2", "value 2");
    appProps.put("key3", "value 3");
    return appProps.get(key);
}
}
 class MyAssertNullTest {
	 
    public String getPropValue(final String key){
        Map<string, string=""> appProps = new HashMap<string, string="">();
        appProps.put("key1", "value 1");
        appProps.put("key2", "value 2");
        appProps.put("key3", "value 3");
        return appProps.get(key);
    }
     
    @Test
    public void test(){
        MyAssertNullTest msnt = new MyAssertNullTest();
        assertNotNull(msnt.getPropValue("key9"));
    }
}
 
 class MyAssertNotSameTest {
	 
	    public String getPropValue(final String key){
	        Map<string, string=""> appProps = new HashMap<string, string="">();
	        appProps.put("key1", "value 1");
	        appProps.put("key2", "value 2");
	        appProps.put("key3", "value 3");
	        return appProps.get(key);
	    }
	     
	    @Test
	    public void isSameReferenceTest(){
	         
	        MyAssertNotSameTest msnt = new MyAssertNotSameTest();
	        assertNotSame(msnt.getPropValue("key1"), msnt.getPropValue("key2"));
	    }
	}
 
 class MyAssertSameTest {
	 
	    public String getPropValue(final String key){
	        Map<string, string=""> appProps = new HashMap<string, string="">();
	        appProps.put("key1", "value 1");
	        appProps.put("key2", "value 2");
	        appProps.put("key3", "value 3");
	        return appProps.get(key);
	    }
	     
	    @Test
	    public void isSameReferenceTest(){
	         
	        MyAssertSameTest msnt = new MyAssertSameTest();
	        assertSame(msnt.getPropValue("key1"), msnt.getPropValue("key1"));
	    }
	}
class Employee {
	 
    private String name;
    private int empId;
    private int salary;
     
    public Employee(int id, String name, int sal){
        this.empId = id;
        this.name = name;
        this.salary = sal;
    }
     
    public boolean equals(Object obj){
        Employee emp = (Employee) obj;
        boolean status = false;
        if(this.name.equalsIgnoreCase(emp.name)
                && this.empId == emp.empId
                && this.salary == emp.salary){
            status = true;
        }
        return status;
    }
     
    public static String getEmpNameWithHighestSalary(){
        *//**
         * logic to get Highest paid employee
         *//*
        return "Nattu";
    }
     
    public static Employee getHighestPaidEmployee(){
        *//**
         * hiding logic to get highest paid employee
         *//*
        return new Employee(1, "Nattu", 15000);
    }
     
    public int hashCode(){
        return this.empId;
    }
     
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
}
*/