package conceptORproblem;
// use KMP to reduce time complecity
// use for pattern matching
public class BrouteForceAlgoForStringPatternMatch {
	
	public static int bruteforce(String text,String tobematched){
		int length = text.length();//length of the text
		int plength = tobematched.length();//length of the pattern;
		System.out.println("length::"+length+" pl:  "+plength);
		//loop condition
		for(int i=0;i<=length-plength;i++){
			//initialization of j
			int j=0;
			while((j < plength) && (text.charAt(i+j) == tobematched.charAt(j))){
				j++;
			}
			if(j == plength){
				return i;
			}
		}

		return -1;
	}
	
	public static void main(String[] args) {
		String text = "12345900" ; //"abcbcfgm";
		String pattern = "900";//bcfg";
		System.out.println(bruteforce(text, pattern));

	}

}
