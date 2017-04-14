package shallow_Deep_Clone;
/*
 * Deep copy: Clone this object and every reference to every other object it has
	Shallow copy: Clone this object and keep its references
	Object clone() throws CloneNotSupportedException: 
	It is not specified whether this should return
	 a deep or shallow copy, but at the very least: o.clone() != o
 */
public class Shallow_Deep_Clone {

	public static void main(String[] args) throws CloneNotSupportedException {

		// Shallow Copy
		ABC a1=new ABC();
		a1.i=9;
		System.out.println(a1);
		ABC a2=a1;
		System.out.println(a2);
		a2.i=8;
		System.out.println(a1);
		System.out.println(a2);
		//
		// Deep copy
		ABC a3=new ABC();
		System.out.println(a1);
		a3.i=12;
		System.out.println(a3);
		//
		// Clone
		
		ABC a4=(ABC) a1.clone();
		System.out.println(a4); // this give java.lang.CloneNotSupportedException. 
									// if we don't implement cloneable
		/*Defensive copy and shallow copy.
		 * 
		 * Defensive copying is concerned with protecting mutable objects e.g.
		 *  objects who’s state can be modified by the user. 
		 *  If you were pass back the reference of an object any changes a user made
		 *   to that copy of the object would effect your object because you are
		 *    only passes a reference to the object and not the actual object itself.
		 *     This is known as a shallow copy.

		* To avoid users being able to change the values of your object you can pass back a
			defensive copy. This means that instead of passing back a reference to your object 
			it passes back a new object but with the same values.
		This means that any changes the user makes to that copy of the object doesn’t 
		change the value/state of your object.
		 */
		
		// A simple point.
		Point p1 = new Point(3,42);
		// A new point at the same place as p1 but a completely different object.
		Point p2 = new Point(p1);
	}

}

class ABC implements Cloneable{
	int i;
	int j;
	@Override
	public String toString() {
		return "ABC [i=" + i + ", j=" + j + "]";
	}
	@Override
	 public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
}
class Point {
	  final int x;
	  final int y;

	  Point(int x, int y) {
	    this.x = x;
	    this.y = y;
	  }
	/*
	 * Note how the constructor Point(Point p) takes a Point and makes a copy of it - 
	 * that's a copy constructor.
	
	This is a defensive copy because the original Point is protected from change by taking a copy of it.
	 */
	  Point(Point p) { 
	    this(p.x, p.y);
	  }

	}