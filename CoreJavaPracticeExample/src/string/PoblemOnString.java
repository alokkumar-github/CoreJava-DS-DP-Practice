package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PoblemOnString {

	public static void noOfOcurrenceAOfString(){
		String s="i am alok";
		System.out.println(s.replace("a", ""));
		int count=s.length()-s.replace("a", "").length();
		System.out.println(s+"\t"+count);
	}
	public static void understandSubString(){
		String s="RamLakhan";
		System.out.println("length Of String::\t"+s.length());
		String sSub=s.substring(3, 7);//
		//String sSub=s.substring(9, 9);
		System.out.println("substring(startIndex,endIndex = chars of startIndex to"
							+ " endIndex-1::\t"+sSub);
		System.out.println("length of the substring is {endIndex-beginIndex} \t "+sSub.length());
		//String s = "ramlakan";
    	//System.out.println("output::: "+s.substring(3,2));// exception arrayindexoutofbound
    	System.out.println("output::: "+s.substring(3));
    	System.out.println("output::: "+s.substring(0,3));
    	System.out.println("output::: "+s.substring(3,5));// index, count
		
	}
	public static void VariousImpFuntionOfString(){
		String s="RamLakhan jlkjl khkh";
		System.out.println(" charAt(index) index Range from 0 to s.length-1 \t"+s.charAt(0)); 
		char c[]=s.toCharArray();
		System.out.println("The string valueOf() method coverts given type such "
				+ "as int, long, float, double, boolean, "
				+ "char and char array into string.\t"+s.valueOf(c));
		String [] stringArray=s.split(" ");// split into array of string
		System.out.println(stringArray.length);
	}
	public static void duplicateWordsInString(){
		String s="RamLakhan abc khkh abc";
		// first spit the string into array of string.
		String [] sArr=s.split(" ");
		Map<String,Integer> m=new HashMap<String,Integer>();
		for(String s1:sArr){
			if(m.containsKey(s1.toLowerCase())){
				m.put(s1.toLowerCase(), m.get(s1.toLowerCase())+1);
			}else{
				m.put(s1.toLowerCase(), 1);
			}
		}
		Set<String> ss=m.keySet();
		for(String s2:ss){
			System.out.println("word\t"+s2+"\tvalue\t"+m.get(s2));
		}
	}
	public static void main(String[] args) {
		noOfOcurrenceAOfString();
		understandSubString();
		//VariousImpFuntionOfString();
		// duplicateWordsInString();
	}

}
