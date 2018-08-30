package exception;

import java.io.IOException;
import java.sql.SQLException;
/*
 * Flow of control in try/catch/finally blocks:

If exception occurs in try block’s body then control immediately transferred(skipping rest of the statements in try block) to the catch block. Once catch block finished execution then finally block and after that rest of the program.
If there is no exception occurred in the code which is present in try block then first, the try block gets executed completely and then control gets transferred to finally block (skipping catch blocks).
If a return statement is encountered either in try or catch block. In such case also finally runs. Control first goes to finally and then it returned back to return statement.
 */
public class ExceptionDemo {
	// method ovverloading in exception; Method which handles more specific exception will be called.
	void method(Exception e){
		System.out.println(e+" caught in Exception method");
		}
		void method(ArithmeticException ae){
		System.out.println(ae+" caught in ArithmeticException method");
		}
		
	public static void main(String[] args) throws Exception {

		ExceptionDemo ed = new ExceptionDemo();
		// System.out.println(ed.exp());
		// ed.exp1();
		 // ed.exp2();
		// ed.exp3();
		// ed.exp4();
		// ed.method(new ArithmeticException());
		//ed.method(new IOException());
	}

	public int exp() {
		/*
		 * Note: If you don't handle exception, before terminating the program,
		 * JVM executes finally block(if any).
		 */

		try {
			System.out.println("try");
			// throw new IOException();
			// throw new IndexOutOfBoundsException();
			 throw new ArrayIndexOutOfBoundsException();
			// System.out.println("try"); // unreachable code; and unreachable
			// code gives compile time exception.
			// return 1; // unrechable code.
		}/* catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("catch-1");
			return 21;
		} */catch (IndexOutOfBoundsException e) {
			System.out.println("catch0");
			return 20;
		} catch (RuntimeException e) {
			System.out.println("catch1");
			return 22;
		}
		/*
		 * catch(IOException e){ System.out.println("catch2"); }
		 */
		catch (Exception e) {
			System.out.println("catch3");
		} finally {
			System.out.println("finally");
			//return 3; // this return is commented appropriate catch retrun value print
		}
		//System.out.println("finish"); // unrechable code if finally return.
		return 3;// concept: if finally has return give compilation. 
		// if finnaly block uncommented return the catch one.
	}

	public void exp1() {
		try {
			System.out.println("outter try");
			throw new ArrayIndexOutOfBoundsException();//IOException();
		} catch (ArrayIndexOutOfBoundsException e) {
			try {
				System.out.println("inner try");
				throw new IOException();
			} catch (Exception e1) {
				System.out.println("inner catch");
			} finally {
				System.out.println("inner finally");
				// System.exit(0);
			}
		} finally {
			System.out.println("outter finally");
		}/*
		 * finally{// try can have multiple catch block but only one finally
		 * block.
		 * 
		 * }
		 */
	}

	public void exp2() {// No need to declare an Error

		try {
			throw new Error();
		} catch (Error me) {
			throw me; // We catch it, but then rethrow it
		}
	}

	/*
	 * Suppose there is 10 statements in your program and there occurs an
	 * exception at statement 5, rest of the code will not be executed i.e.
	 * statement 6 to 10 will not run. If we perform exception handling, rest of
	 * the statement will be executed. That is why we use exception handling in
	 * java.
	 */
	public void exp3() {
		try {
			String s = "abc";
			// int i = Integer.parseInt(s);// NumberFormatException
			try {
				System.out.println("going to divide");
				//int b = 39 / 10;
				int b = 39 / 0;
				System.out.println("print value of B::::"+b);
			} catch (ArithmeticException e) {
				System.out.println("print Exception:::\t"+e);
				try {
					int a[] = new int[5];
					a[5] = 4;
				} catch (ArrayIndexOutOfBoundsException e1) {
					System.out.println("print Exception:::\t"+e1);
					int b = 39 / 0;
				}
			}
			/*try {
				int a[] = new int[5];
				a[5] = 4;
			} catch (ArrayIndexOutOfBoundsException e1) {
				System.out.println("print Exception:::\t"+e1);
			}*/
			System.out.println("other statement");
		} catch (Exception e) {
			System.out.println("handeled\t" + e);
			int b = 39 / 0;
		}

		System.out.println("normal flow..");
	}

	/*
	 * Rule: For each try block there can be zero or more catch blocks, but only
	 * one finally block. Note: The finally block will not be executed if
	 * program exits(either by calling System.exit() or by causing a fatal error
	 * that causes the process to abort).
	 * 
	 * Rule: By default Unchecked Exceptions are forwarded in calling chain
	 * (propagated).
	 * 
	 * Whenever methods are called stack is formed and an exception is first thrown from the top of
the stack and if it is not caught, it starts coming down the stack to previous methods until it is not caught.
If exception remains uncaught even after reaching bottom of the stack it is propagated to JVM and program is
terminated

	 */
	public void exp4() {
		Boolean b=null;
		try {
			String s = "abc"; // s variable is local to try block
			int i = Integer.parseInt(s);// NumberFormatException // unchecked
										// Exception
			b=true;
			throw new NumberFormatException();
		} finally {
			System.out.println("statment");
			try {
				int a[] = new int[5];
				a[5] = 4;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/*
	 * Rule: By default, Checked Exceptions are not forwarded in calling chain
	 * (propagated).
	 * 
	 * Which exception should be declared
	 * 
	 * Ans) checked exception only, because:
	 * 
	 * unchecked Exception: under your control so correct your code. error:
	 * beyond your control e.g. you are unable to do anything if there occurs
	 * VirtualMachineError or StackOverflowError.
	 * 
	 * Advantage of Java throws keyword Ans ) Now Checked Exception can be
	 * propagated (forwarded in call stack).
	 * 
	 * Throws provides information to the caller of the method about the
	 * exception.
	 * 
	 * In the above example exception occurs in m() method where it is not
	 * handled,so it is propagated to previous n() method where it is not
	 * handled, again it is propagated to p() method where exception is handled.
	 * 
	 * Exception can be handled in any method in call stack either in main()
	 * method,p() method,n() method or m() method.
	 */
	void m() throws IOException, SQLException {
		throw new IOException("device error");// checked exception
	}

	void n() throws IOException, SQLException { // if thows only IOException
												// give compile time error
		m();
	}

	void p() {
		try {
			n();
		} catch(IOException | SQLException ex){//multi catch syntax
			//code . . . . .
		}catch (Exception e) {
			System.out.println("exception handled");
		}
	}

	/*an explanation as to what it means to pass an exception up the calling chain by declaring the exception
	 *  in my methods throws clause and why I would want to do that.
	 *  When an exception occurs in the code, it interrupts the current method and gives the control back to the previous method on the stack trace. If this method can handle the exception (with a catch), the catch will be executed, the exception will stop bubbling up. If not, the exception will bubble up the stack trace. Ultimately, if it arrives in the main and the main cannot handle it, the program will stop with an error.
	 *  
	 * Give complie time error bcz By default, 
	 * Checked Exceptions are not forwarded in calling chain(propagated)
	 * in order to propagate forwaded in calling chain, ,thorws the excetion ex. void m()thorws IOException
	 * void m(){ 
	 *  throw new java.io.IOException("device error");//checked exception 
	 *  } 
	 *  void n(){
	 *   m();
	 * } 
	 * void p(){ try{ n(); }catch(Exception
	 * e){System.out.println("exception handeled");} }
	 */
	
	/*This will not give compilation error since By default, 
	 * Checked Exceptions are  forwarded in calling chain. so not need to provide throws
	 * 	void m(){  
		    int data=50/0;  // unchecked exception occurred
        // exception propagated to n()
		  }  
		  void n(){  
		    m();  // exception propagated to p()
		  }  
		  void p(){  
		   try{  
		    n();  // exception handled
		   }catch(Exception e){System.out.println("exception handled");}  
		  } 
		  public static void main(String args[])
		    {
		        Simple obj = new Simple();
		        obj.p();
		        System.out.println("normal flow...");
		    } 
	 */

	/*
	 * ExceptionHandling with MethodOverriding in Java
	 */
	class Parent {
		void msg() {
			System.out.println("parent");
		}
	}

	/*
	 * 1) Rule: If the superclass method does not declare an exception, subclass
	 * overridden method cannot declare the checked exception but it can declare
	 * unchecked exception. or not at all
	 */
	
	class Parent1 {
		void msg() throws ArithmeticException {
			System.out.println("parent");
		}
		void msg1(){
			
		}
		void msg2() throws Exception { // no exception
			System.out.println("child");
		}
	}
	class Child14 extends Parent1 {
		void msg() throws NullPointerException{ // subclass exception 
			System.out.println("child");
		} 
		/*void msg1() throws SQLException{ // will get error since SQLException is checked exception.follow  Rule no 1 above
			
		}*/
		void msg1() throws NullPointerException { // no compile error NullPointerException is unchedked exception; follow  Rule no 1 above
			System.out.println("TestExceptionChild");
		}
		/*void msg2() throws Exception { // no exception
			System.out.println("child");
		}*/
	}
	
	class Child1 extends Parent {
		void msg() /* throws IOException */{ // give compile error 'void throws
												// IOException msg()'
			System.out.println("TestExceptionChild");
		}
	}

	class Child2 extends Parent {
		void msg() throws NullPointerException { // no compile error
			System.out.println("TestExceptionChild");
		}
	}
		
		/*
		 * Rule 2 :If the superclass method declares an exception,
		 *  subclass overridden method can declare 
		 *  same , subclass Exception class object or no exception but cannot declare parent Exception class.
		 */
	
	class Child11 extends Parent {
		void msg()/* throws Exception */{ // no exception
			System.out.println("child");
		} // compile error
	}

	class Child12 extends Parent {
		void msg() throws ArithmeticException{ // same exception as parent
			System.out.println("child");
		} 
	}
	class Child13 extends Parent {
		void msg() throws NullPointerException{ // subclass exception
			System.out.println("child");
		} 
	}
	
	/*
	 * throw custom exception
	 */
	 static void validate(int age)throws InvalidAgeException{  
	     if(age<18)  
	      throw new InvalidAgeException("not valid");  
	     else  
	      System.out.println("welcome to vote");  
	   }  
}
/*
 * custom Exception ::
 *  
 */
class InvalidAgeException extends Exception{  
	public InvalidAgeException(String s){  
	  super(s);  // why we call super in own created custom exception.
	  /*
	   * In the case of custom exceptions, it is common to use super to initialize the exception's error message;
	   *  by passing the message into the base class constructor, 
	   *  the base class will take care of the work of setting the message up correctly.
	   */
	 }  
	// In java why custom exceptions should also have a constructor with arg as 'Throwable cause'
	// This allows you to chain the exceptions.
	public InvalidAgeException(String message, Throwable cause) {
	    super(message, cause);
	}
	 public String toString(){
		 String s="invalide age .";
		return s;
		 
	 }
	}  
