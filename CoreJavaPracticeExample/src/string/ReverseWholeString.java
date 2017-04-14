package string;

import java.math.BigDecimal;
import java.util.Arrays;

public class ReverseWholeString {

	public static void main(String[] args) {
		//System.out.println(reverseString("i am alok"));
		/*Double d1=156.90;
		BigDecimal d = new BigDecimal(d1);
		BigDecimal i[]=new BigDecimal[7];
		BigDecimal ii=0;
		while(d!=0){
			i[ii]=d%10.00;
			d=(double) Math.p(d/10.00);
			ii++;
		}
		System.out.println(Arrays.toString(i));*/

	}
	
	public static String reverseString(String str){
		int start=0,end=0,length;
		char s []=str.toCharArray();
		length=s.length;
		revString(s,start,length-1);
		while( end < length ){
				if( s[end] != ' ' ){
				start = end;
				while( end < length && s[end] != ' ' )
				end++;
				end--;
				revString( s, start, end );
				}
				end++;
			}
		return String.valueOf(s);
	}
	public static void revString(char s[],int start,int end){
		char temp;
		while(end>start){
			temp=s[start];
			s[start]=s[end];
			s[end]=temp;
			start++; end--;
		}
	}
	public static void revd(char s[],int start,int end){
		char temp;
		while(end>start){
			temp=s[start];
			s[start]=s[end];
			s[end]=temp;
			start++; end--;
		}
	}

}
