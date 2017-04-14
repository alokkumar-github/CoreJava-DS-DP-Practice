package ds.stack;

public class ConverBinaryToDecimalUsingStack {

	public String converDecimalToBinary(int number) throws Exception{
		StringBuilder sb=new StringBuilder();
		Stack s= new Stack(10);
		if(number==0){
			sb.append(number);
		}else{
			
			while(number!=0){
				s.push(number%2);
				number=number/2;
		}
			while(!s.isEmpty()){
				sb.append(s.pop());
			}
			
		}
		return sb.toString();
	}
	
}
