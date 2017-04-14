package string;

public class ReverseStringWithoutAPI {

	public static void main(String[] args) {
		System.out.println(new ReverseStringWithoutAPI().revereString("125.67"));

	}
	public String revereString(String st){
		if(st.length()==0){
			return "";
		}
		//System.out.println(st.length()); //4
		//System.out.println(st.substring(0,st.length()-1));
		return st.charAt(st.length()-1)+revereString(st.substring(0,st.length()-1));
	}
	static String reverse(String str) {
		return (str.length() == 1) ? str : str.charAt(str.length() - 1)
				+ reverse(str.substring(0, str.length() - 1));
	}

	static int fact(int i) {
		if (i == 0)
			return 1;
		else
			return i * fact(i - 1);
	}
}
