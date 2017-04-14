package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/*
 * A retention policy determines at what point annotation should be discarded.
Java defined 3 types of retention policies through java.lang.annotation.RetentionPolicy 
enumeration. It has SOURCE, CLASS and RUNTIME.
Annotation with retention policy SOURCE will be retained only with source code, and discarded during compile time.
Annotation with retention policy CLASS will be retained till compiling the code, and discarded during runtime.
Annotation with retention policy RUNTIME will be available to the JVM through runtime.
The retention policy will be specified by using java built-in annotation @Retention,
 and we have to pass the retention policy type.
The default retention policy type is CLASS.
 */

/*
 * Java Annotation is a tag that represents the metadata i.e.
 *  attached with class, interface, methods or fields 
 *  to indicate some additional information which can be used by java compiler and JVM.

 Annotations in java are used to provide additional information, 
 so it is an alternative option for XML and java marker interfaces.

 Understanding Built-In Annotations in java
 @Override
 @Override annotation assures that the subclass method is overriding the parent class method.
  If it is not so, compile time error occurs.
 Sometimes, we does the silly mistake such as spelling mistakes etc. 
 So, it is better to mark @Override annotation that provides assurity that method is overridden.

 */
/*
 * Points to remember for java custom annotation signature

 There are few points that should be remembered by the programmer.

 Method should not have any throws clauses
 Method should return one of the following: primitive data types, String,
  									Class, enum or array of these data types.
 Method should not have any parameter.
 We should attach @ just before interface keyword to define annotation.
 It may assign a default value to the method.

 Types of Annotation

 There are three types of annotations.

 Marker Annotation
 Single-Value Annotation
 Multi-Value Annotation
 
 Built-in Annotations used in custom annotations in java
	@Target
	@Retention
	@Inherited  
	-- By default, annotations are not inherited to subclasses. 
	The @Inherited annotation marks the annotation to be inherited to subclasses.
	@Documented
	If Target meta-annotation is not present, then annotation can be used on any program element.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

@interface MyAnnotation {
	
	int i=0;
	int value1() default 1;
	String comments();
	/*
	 * String value2(); String value3() default "xyz";
	 */

}

// Applying annotation
class Hello {
	@MyAnnotation(comments = "lkhsf") // if method has no default the we must give the value
	public void sayHello() {
		int i=9;
		System.out.println("hello annotation"+i);
	}
}

// Accessing annotation 
/*
 * We will use Reflection to parse java annotations from a class. Please note that Annotation Retention Policy should be RUNTIME otherwise it’s information will not be available at runtime and we wont be able to fetch any data from it.
 */
class TestCustomAnnotation1 {
	public static void main(String args[]) throws Exception {

		Hello h = new Hello();
		h.sayHello();
		Method m = h.getClass().getMethod("sayHello");

		MyAnnotation manno = m.getAnnotation(MyAnnotation.class);
		System.out.println("value is: " + manno.value1());
	}
}

////////////////////////
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotn{
     
    String value();
}
 
class MySingleMembAnnotation {
 
    @MyAnnotn("java2novice.com")
    public void myAnnotationTestMethod(){
         
        try {
            Class<? extends MySingleMembAnnotation> cls = this.getClass();
            Method mth = cls.getMethod("myAnnotationTestMethod");
            MyAnnotn myAnno = mth.getAnnotation(MyAnnotn.class);
            System.out.println("value: "+myAnno.value());
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
     
    public static void main(String a[]){
         
        MySingleMembAnnotation mat = new MySingleMembAnnotation();
        mat.myAnnotationTestMethod();
    }
}

@interface MySampleAnn {
	 
    String name();
    String desc();
}
 
class MyAnnTest{
     
    @MySampleAnn(name = "test1", desc = "testing annotations")
    public void myTestMethod(){
        //method implementation
    }
}

///How to assign default values to custom annotations? -
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnot{
     
    String key() default "site";
    String value() default "java2novice.com";
}
 
class MyAnnotDefaultValues {
 
    @MyAnnot()
    public void myAnnotationTestMethod(){
         
        try {
            Class<? extends MyAnnotDefaultValues> cls = this.getClass();
            Method mth = cls.getMethod("myAnnotationTestMethod");
            MyAnnot myAnno = mth.getAnnotation(MyAnnot.class);
            System.out.println("key: "+myAnno.key());
            System.out.println("value: "+myAnno.value());
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
     
    public static void main(String a[]){
         
        MyAnnotDefaultValues mat = new MyAnnotDefaultValues();
        mat.myAnnotationTestMethod();
    }
}
