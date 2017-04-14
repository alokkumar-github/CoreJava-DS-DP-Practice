package ds.stack;

public class DemoStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack s=new Stack(5);
		try{
		s.push('A');
		s.push('L');
		s.push('O');
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		try{
			s.pop();
			s.pop();
			s.peek();
			s.pop();
			s.pop();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}
