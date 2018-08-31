//package java9;
///*

// Constant variables
//	Abstract methods
//  Default methods
//   Static methods
//  Private methods
//  Private Static methods
// * If two default methods needed to share code, a private interface method would allow them to do so,
// *  but without exposing that private method and all its "implementation details" via the interface.
// *  
// *  Simple: default methods allow you to add behavior to a class.
//
//But a default method is implicitly public.
//
//This means that it can be called and overridden in any class that implements that interface.
//
//But there might be situations where you want to put some code into an interface that only exists there to avoid code duplication. So, ideally, you don’t want to repeat these lines within each default method that needs them. But putting that specific code into a default method isn’t an option.
//
//The ability to mark interface methods as private closes that gap. Now you have a mean to express your intention of having, well, private behavior within an interface
// */
//interface myinterface {
//    default void m1(String msg){
//        msg+=" from m1";
//        printMessage(msg);
//    }
//    default void m2(String msg){
//        msg+=" from m2";
//        printMessage(msg);
//    }
//    private void printMessage(String msg){
//        System.out.println(msg);
//    }
//}
//public class Privatemethods implements myinterface {
//    public void printInterface(){
//        m1("Hello world");
//        m2("new world");
//    }
//    public static void main(String[] args){
//        Privatemethods s = new Privatemethods();
//        s.printInterface();
//    }
//}