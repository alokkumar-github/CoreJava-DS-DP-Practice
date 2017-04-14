package string;

import java.util.Comparator;
import java.util.Locale;
import java.util.StringTokenizer;

public class StringTest implements Comparator{
	
	int id;
	String name;

	public StringTest(){
		
	}
	
	public StringTest(int id , String name){
		this.id=id;
		this.name=name;
	}
	public StringTest(StringTest st){ // Copy Constructor
		System.out.println("Copy constructor called");
		id=st.id;
		name=st.name;
	}
	
	public boolean equals(Object obj){
		if(this==obj) {
			return true;
		}
		if((obj==null)||(this.getClass()!=obj.getClass())){
			return false;
		}
		StringTest st=(StringTest)obj;
		return id==st.id && (name==st.name ||(name!=null&&name.equals(st.name)));
	}
	
	public int hasCode(){
		int hash = 9;
		hash = (31 * hash) + id;
		hash = (31 * hash) + (null == name ? 0 : name.hashCode());
		//System.out.println("jjj:"+name.hashCode());
		return hash;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("id=").append(id);
		sb.append("name=").append(name);
		return sb.toString();
		}
	
	//static factory method
	public static StringTest newInstance(StringTest stringTestToCopy){
		return new StringTest();
	}
	
	public void AddNum(Object ...args){//Varray
		int sum=0;
		for(Object o:args){
			Integer i=(Integer)o;
			sum+=i;
		}
		System.out.println("Sum::"+sum);
	}
	public static void main(String str[]){
		StringTest st5=new StringTest(2,"B");
		StringTest st=new StringTest(1,"AA");
		System.out.println(st);
		StringTest st1=new StringTest(st);
		System.out.println(st1);
		StringTest st3=st1;// st3 is not copy constructor.
		System.out.println(st3);
		StringTest st4=new StringTest();
		st4.AddNum(2,5,6);
		System.out.println("hashCode::"+st1.hasCode());
		
		System.out.println("hashCode::"+st3.hasCode());
		System.out.println("hashCode::"+st.hasCode());
		System.out.println("hashCode::"+st4.hasCode());
		System.out.println("hascode::"+st5.hasCode());
		
		if(st.compare(st, st5)==0);{
			System.out.println(st.equals(st5));//true
		}
		//It follows that for any two 
		//strings s and t, s.intern() == t.intern() is true
		//if and only if s.equals(t) is true.
		String s1="A";
		Integer i=new Integer(0);
		String s2="AAA";
		String s3=new String("AAA");
		StringBuffer sb=new StringBuffer("AAA");
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println(sb.hashCode());
		System.out.println(i.hashCode());
		System.out.println(s3.intern());
		System.out.println("euql 1:::s::"+st.equals(st1));
		System.out.println("euql 2:::s::"+st1.equals(st));
		
		
		
		String strr="Bcv";
		System.out.println(strr.charAt(0));
		System.out.println(strr.intern());
		
		
		
		int a=5;
		int b=5;
		if(a==b){//true
			System.out.println("aaa::");
		}
		
		
		String s7="RAMLAKHAN";
		System.out.println(s7.substring(1, 3));// see in copy for logic
		
		System.out.println(s7.charAt(3));
		
		s7.concat("f");
		System.out.println(s7); // RAMLAKHAN
		char c []={'f','g','h'};
		String s8= s7.copyValueOf(c);
		System.out.println(s8);// fgh
		String s9= s7.copyValueOf(c, 1, c.length-1);
		System.out.println(s9);
		System.out.println(s7);// RAMLAKHAN
		String cdf = new String(c); // 
		System.out.println(cdf);
		// How to convert Character array to String object?
		char ch[] = {'M','y',' ','J','a','v','a',' ','e','x','a','m','p','l','e'};
        /**
         * We can copy a char array to a string by using
         * copyValueOf() method.
         */
        String chStr = String.copyValueOf(ch);
        System.out.println(chStr);
        /**
         * We can also copy only range of charactors in a
         * char array by copyValueOf() method.
         */
        String subStr = String.copyValueOf(ch,3,4);// note
        System.out.println(subStr);
		
		System.out.println(s8.compareTo(s9));
		
		 String c1 = "We are comparing the content with a StringBuffer content";
	        StringBuffer sb8 =
	            new StringBuffer("We are comparing the content with a StringBuffer content");
	        /**
	         * We can use contentEquals() method to compare content with a StringBuffer.
	         * It returns boolean value.
	         */
	        if(c1.contentEquals(sb8)){
	            System.out.println("The content is equal"); // this will execute
	        } else {
	            System.out.println("The content is not equal");
	        }
	        String str0 = "core java api";
	        byte[] b0 = str0.getBytes();
	        System.out.println("String length: "+str0.length());
	        System.out.println("Byte array length: "+b0.length);
	        
	        
		String str1 = "Use this string for testing this";
        System.out.println("Basic lastIndexOf() example");
        System.out.println("Char 's' at last occurance: "+str1.lastIndexOf('s'));
        
        System.out.println("First occurance of char 's' from 4th index onwards : "
                +str1.indexOf('s',4));
        
        System.out.println("String \"this\" at last occurance: "+str1.lastIndexOf("this"));
        /**
         * Returns the last occurance from specified start index,
         * searching backward starting at the specified index.
         */
        System.out.println("first occurance of char 's' from 24th index backwards: "
                            +str1.lastIndexOf('s',24));
        System.out.println("First occurance of String \"this\" from 26th index backwards: "
                            +str1.lastIndexOf("this",26));
        
        String str11 = "This is an example string.";
        System.out.println("Is this string starts with \"This\"? "
                        +str11.startsWith("This"));
        System.out.println("Is this string starts with \"is\"? "
                        +str11.startsWith("is"));
        System.out.println("Is this string starts with \"is\" after index 5? "
                        +str11.startsWith("is", 5));
        String str12 = "This is a java string example";
        if(str12.endsWith("example")){
            System.out.println("This String ends with example");
        } else {
            System.out.println("This String is not ending with example");
        }
        
        String[] tokens = str11.split(" ");
        String str13 = "This     program  splits a string based on space";
        tokens = str13.split("\\s+"); // or str11.split(" ");
        for( String s:tokens){
            System.out.println(s);
        }
		
        // How to extract Char Array From String in java?
        String str14 = "Copy chars from this string";
        char[] ch23 = new char[5];
        /**
         * The getChars() method accepts 4 parameters
         * first one is the start index from string
         * second one is the end index from string
         * third one is the destination char array
         * forth one is the start index to append in the
         * char array.
         */
        str14	.getChars(5, 10, ch, 0);
        System.out.println(ch23);
	
        // How to replace string characters in java? http://www.java2novice.com/java_string_examples
        
        String str15 = "This is an example string";
        System.out.println("Replace char 's' with 'o':"
                    +str15.replace('s', 'o'));
                     
        System.out.println("Replace first occurance of string\"is\" with \"ui\":"
                    +str15.replaceFirst("is", "ui"));
                     
        System.out.println("Replacing \"is\" every where with \"no\":"
                    +str15.replaceAll("is", "no"));
        System.out.println("Upper Case: "+str14.toUpperCase());
        System.out.println("Lower Case: "+str15.toLowerCase().trim());
        
        
        //How to format given string in java?
        String str22 = "This is %s format example";
        System.out.println(String.format(str22, "string"));
        String str21 = "We are displaying no %d";
        System.out.println(String.format(str21, 10));
        /**
         * String format by specifying Locale details
         */
        System.out.println("String format with Locale info:");
        System.out.println(String.format(Locale.US, str21, 10));
        
        ///How to remove multiple spaces in a string in Java?
        
        String str44 = "String    With Multiple      Spaces";
        StringTokenizer st44 = new StringTokenizer(str44, " ");
        StringBuffer sb4 = new StringBuffer();
        while(st44.hasMoreElements()){
            sb4.append(st44.nextElement()).append(" ");
        }
        System.out.println(sb4.toString().trim());
        
        // How to remove non-ascii characters from a string?
        String str6 = "Bj��rk����oacute�";
        System.out.println(str);
        str6 = str6.replaceAll("[^\\p{ASCII}]", "");
        System.out.println("After removing non ASCII chars:");
        System.out.println(str6);
        
        // How to remove html tags from a string?
        
        String text = "<B>I don't want this to be bold<\\B>";
        System.out.println(text);
        text = text.replaceAll("\\<.*?\\>", "");
        System.out.println(text);

        // How to get line count from a string?
        
        String str77 = "line1\nline2\nline3\rline4";
        System.out.println(str77);
        int count = getLineCount(str77);
        System.out.println("line count: "+count);
        
        
        // How to match a format in string using regular expression? - See more at: http://www.java2novice.com/java_string_examples/regular_expression/#sthash.pk8E5fWW.dpuf
        
        String[] str8 = {"www.java2novice.com", "http://java2novice.com"};
        for(int ii=0;ii < str8.length;ii++){
            if(str8[ii].matches("^www\\.(.+)")){
                System.out.println(str8[ii]+" Starts with 'www'");
            } else {
                System.out.println(str8[ii]+" is not starts with 'www'");
            }
        }
        
		StringBuilder sb7=new StringBuilder("ss");
		//System.out.println(sb7.append("asd").append(5).insert(1, 7));
		sb7.append("asd").append(5).insert(1, 7).reverse();
		System.out.println(sb7);
		
		/*
		 * StringBuffer doesn't override equals(); its equals() method is the one inherited from java.lang.Object,
		 *  which returns true if and only if "==" would be true. String, on the other hand, does override equals();
		 *   its definition returns true of the two objects contain the same sequence of characters.
		 */
		String s11 = new String("Hello"); 
		String s22 = new String("Hello"); 

		StringBuffer sb1 = new StringBuffer("Hello"); 
		StringBuffer sb2 = new StringBuffer("Hello"); 
		
		StringBuffer sb3 =new StringBuffer(sb2);//  
		System.out.println(sb3);
		
		System.out.println(sb1 == sb2); 
		System.out.println(s11 == s22); 
		System.out.println(s11.equals(s22)); 
		System.out.println(sb1.equals(sb2)); // false why ?
		/*System.out.println(sb1.hashCode());
		System.out.println(sb2.hashCode());*/
		
		
		///
		 int xx=9;
		String r5= xx+8+"l";
		System.out.println(r5);
		System.out.println(r5+xx+8);
	}
	 public static int getLineCount(String text){
         
	        return text.split("[\n|\r]").length;
	    }
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		StringTest s1=(StringTest)o1;
		StringTest s2=(StringTest)o2;
		System.out.println(s1.name);
		System.out.println(s2.name);
		int i=s1.name.compareTo(s2.name);
		System.out.println(i);
		return i;
	}
}
