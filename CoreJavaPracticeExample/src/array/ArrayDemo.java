package array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
 * http://docs.oracle.com/javase/specs/
 * 
 * Colletion of similar kind of data in contiguous memory allocation.
 * Advantages of using arrays:
 * 	Arrays allow random access of elements. This makes accessing elements by position faster.
	Arrays have better cache locality that can make a pretty big difference in performance.
 * 
 * Array is object in java whose class is not exist.
 * Arrays can be one dimensional or multi-dimensional. 
 * Arrays override all the object class method except clone
 * 
 * Array of objects of class, array of primitive type , array of string type.
 * 
 *  */
public class ArrayDemo {

	public static void main(String[] args) {
		int row1[] = {5,1,2,3};
	    //int row2[] =  row1.clone();
	    int row2[]=null;
	    row2=row1;
	    int row3[]=row1;
	    System.out.println(Arrays.toString(row1));
	    System.out.println(Arrays.toString(row2));
	    System.out.println(row1[0]);
	    System.out.println(row1[0]==row2[0]);
	    
	    int table1[][]={{10,1,2,3},{11,12,13,14}};
	    int table2[][] = table1.clone();
	    System.out.println(table1[0]);
	    System.out.println(table1[0][0]);
	    System.out.println(table1[0][0]==table2[0][0]);
	    
	    Example eg1 = new Example(1, new int[]{1, 2});
	    
	    //Example eg2 = new Example(eg1.foo, eg1.bar);
	   
	    Example eg2 = new Example(eg1.foo, Arrays.copyOf(eg1.bar,2));
	    System.out.println("eg2:: "+eg2);
	    
	    // arrray declaration and initiaiztion
	    
	    int[][] num={ {1,2}, {1,2}, {1,2}, {1,2}, {1,2} };
	    String[] myStringArray = new String[3];
	    String[] myStringArray1 = {"a","b","c"};
	    String[] myStringArray2 = new String[]{"a","b","c"};
	    // useing reflection
	    int size = 3;
	    int[] intArray = (int[]) Array.newInstance(int.class, size ); 
	    
	    Example exampleArray[]=new Example[]{new Example(),new Example()};
	    
	    /*int [][] two_dimensional_array =
	    	{
	    	  { value, value, value, .. value },
	    	  { value, value, value, .. value },
	    	    ..     ..     ..        ..
	    	  { value, value, value, .. value }
	    	};*/
	    
	    /*public static void arraycopy( 
				Object source_Array, int sourcePos,Object copty_to_array, int copty_to_array_pos, int length 
				)
	     * source_Array tells which array to copy from.
			sourcePos tells the source array position to start from (index starts from 0).
			copty_to_array specifies which array to copy to.
			copt_to_array_pos specifies where to copy in the destination array.
			The length specifies the length of the destination array.
	     */
	    char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e',  
                'i', 'n', 'a', 't', 'e', 'd' };  
        char[] copyTo = new char[7];  
        System.arraycopy(copyFrom, 2, copyTo, 0, 7);  
        System.out.println(new String(copyTo));  
        
        // How to compare two arrays and confirm they are equal? - See more at: http://www.java2novice.com/java-arrays/array-deep-equal/#sthash.lTdoba6l.dpuf
        String[] strArr = {"JAVA", "C++", "PERL", "STRUTS", "PLAY"};
        String[] strArrCopy = {"JAVA", "C++", "PERL", "STRUTS", "PLAY"};
        System.out.println("Are strArr and strArrCopy same? "
                    +Arrays.deepEquals(strArr, strArrCopy));
        
        
        
        /// wapper clsss
        // we can pass either primitive data type as argumemt or string object . 
        // no wapper class contructor accept zero argument.
        //create Boolean using boolean primitive type
        // simmilaly for other primitive type  
        boolean b1 = true;
        Boolean bObj1 = new Boolean(b1);
        System.out.println("Wrapper class Boolean output: "+bObj1);
        //create Boolean using string value
        Boolean bObj2 = new Boolean("false");
        System.out.println("Wrapper class Boolean output: "+bObj2);
        //how to get primitive boolean value from wrapper class
        System.out.println(bObj1.booleanValue());
        
        // string to int
        String number = "78";
        Integer i3 = Integer.parseInt(number);
        System.out.println("converted integer: "+i3);
        // int to Integer
        int in = 10;
        Integer intg = new Integer(in);
        System.out.println(intg);
        // How to convert Integer to primitive types?
        Integer itr = new Integer(10);
        System.out.println("byte value: "+itr.byteValue());
        System.out.println("double value: "+itr.doubleValue());
        System.out.println("float value: "+itr.floatValue());
        System.out.println("int value: "+itr.intValue());
        System.out.println("long value: "+itr.longValue());
        System.out.println("short value: "+itr.shortValue());
        
        // back to string 
        String bactTostring=i3.toString();
        //How to convert String to Integer value?
        String str = "23";
        Integer i2 = Integer.valueOf(str);
        System.out.println("The integer value: "+i2);
        // How to convert integer to binary value?
        Integer i = new Integer(20);
        String binary = Integer.toBinaryString(i);
        System.out.println("Binary value: "+binary);
        //How to convert binary value to integer value? simillarly oct ,hexa
        String binary1 = "1101001";
        Integer i1 = Integer.parseInt(binary1,2);
        System.out.println("Integer value: "+i1);
        
        // 
        Dog d1 = new Dog(2, 50);
        Dog d2 = new Dog(1, 30);
        Dog d3 = new Dog(3, 40);
        Dog[] dogArray = {d1, d2, d3};
        //Arrays.sort(dogArray); array.Dog cannot be cast to java.lang.Comparable; 
        printDogs(dogArray);
        Arrays.sort(dogArray, new DogSizeComparator());
        printDogs(dogArray);
        
        Arrays.sort(dogArray, new DogWeightComparator());
        printDogs(dogArray);
        
        // cloning array..  https://www.geeksforgeeks.org/arrays-in-java/
       // When you clone a single dimensional array, such as Object[], a "deep copy" 
        // is performed with the new array containing copies of the original array's elements as opposed to references.
        int intArray1[] = {1,2,3};
        
        int cloneArray[] = intArray1.clone();
        
         
        // will print false as deep copy is created
        // for one-dimensional array
        System.out.println(intArray1 == cloneArray);
        System.out.println(intArray1[0] == cloneArray[0]);
        System.out.println(intArray1.equals(cloneArray));
        System.out.println(new Integer(intArray1[0]).equals(cloneArray[0]));
        
        // A clone of a multidimensional array (like Object[][]) is a "shallow copy" 
        // however, which is to say that it creates only a single new array with each element array a reference to an original element array
        // but subarrays are shared. https://www.geeksforgeeks.org/arrays-in-java/
        int intArray2[][] = {{1,2,3},{4,5}};
        
        int cloneArray2[][] = intArray2.clone();
         
        // will print false
        System.out.println("multi D...................");
        System.out.println(intArray2 == cloneArray2);
        System.out.println(intArray2.equals(cloneArray2));
         
        // will print true as shallow copy is created
        // i.e. sub-arrays are shared
        System.out.println("intArray2[0]::: "+intArray2[0]+" cloneArray2[0]:: "+cloneArray2[0]);
        System.out.println(intArray2[0] == cloneArray2[0]);
        System.out.println(intArray2[1] == cloneArray2[1]);
        
        System.out.println(intArray2[0] .equals(cloneArray2[0]));
        
        System.out.println(intArray2[1][0] == cloneArray2[1][0]);
        
	}
	public static void printDogs(Dog[] dogs){
		for(Dog d: dogs)
		System.out.print(d.size + " " );
		System.out.println();
		}
}

 class Example {
    public int foo;
    public int[] bar;
    public Example() { };
    public Example(int foo, int[] bar) { this.foo = foo; this.bar = bar; }
	@Override
	public String toString() {
		return "Example [foo=" + foo + ", bar=" + Arrays.toString(bar) + "]";
	};
}
 
 class Dog{
	 int size;
	 int weight;
	 /*
	  * String[] strArr = {"JAVA", "C++", "PERL", "STRUTS", "PLAY"};
        Arrays.sort(strArr,new Comparator<String>(){
 
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }});
         
        for(String str:strArr){
            System.out.println(str);
        }
	  */
	 // TODO do it for String 
	 String name;
	 public Dog(int s, int w){
	 size = s;
	 weight = w;
	 }
	 }
 class DogSizeComparator implements Comparator<Dog>{
	 @Override
	 public int compare(Dog o1, Dog o2) {
	 return o1.size - o2.size;
	 }
	 }
 class DogWeightComparator implements Comparator<Dog>{
	 @Override
	 public int compare(Dog o1, Dog o2) {
	 //return o1.weight - o2.weight;
	 return o2.weight - o1.weight;
	 }
	 }
 