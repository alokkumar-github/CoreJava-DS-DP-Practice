package enum_demo;

public class EnumDemo {
	enum Color {RED, BLUE}
	public static void main(String[] args) {
		switchDemo();
		switchDemo1();
		iterateEnum();
	}
	static void iterateEnum(){
	for (Size s : Size.values()){  
		System.out.println(s+" "+s.getAbbv()+" \t"+s.f());  
	}
	}
	/*
	 * The case labels must be integers or enumerated constants. You cannot test
	 * strings
	 * i)  you should not repeat case '1' twice if so compilation error.
	ii) break is optional. no compilation or no runtime error. 
	The statements from that call will be executed until a break takes place or end.
	iii) default is also optional but from that full execution will be done.
	iv) switch() we can place int or short or byte or char or enumerated  type only as an argument.
	 no other type is possible to take if so compilation error.
	v) How to give multiple cases:
	All cases should have in the range of switch othereise compilation error

	 */
	public static void switchDemo() {
		//Size s = (Size) Enum.valueOf(Size.class, "S"); //Size.SMALL.toString(); // java.lang.IllegalArgumentException: No enum const class com.test.Size.S
		Size s = (Size) Enum.valueOf(Size.class, "LARGE"); 
		int i=s.MEDIUM.ordinal();
		//Size[] values = Size.values();
		switch(s){ //switch() we can place int or short or byte or char or enumerated  type only as an argument.
		//case 0||1: //is compilation error.
		case SMALL:
		case MEDIUM : System.out.println("ok"); //to give multiple cases:
						break;
		default: System.out.println("default");			
		case LARGE: break;
		//case SMALL:  //you should not repeat case  twice if so compilation error.
		
		}
		
	}
	
	public static void switchDemo1() {
		Color c=Color.valueOf("RED");
		Color c1=Color.valueOf("RED");
		switch(c){
			case RED : System.out.println(c);
						switch(c1){
						case RED: if(c==c1)System.out.println("==");
								  if(c.equals(c1)) System.out.println("equal");
						case BLUE: System.out.println("sf");
						}
		}
	}
}

// How to call enum, which is defined inside a class?

class MyEnumInsideClass {
    
    private MyWrapper.Fruit myFruit;
     
    public MyEnumInsideClass(MyWrapper.Fruit fruit){
        this.myFruit = fruit;
    }
     
    public void getFruitDesc(){
         
        switch (myFruit) {
            case GRAPE:
                System.out.println("A grape is a non-climacteric fruit.");
                break;
                     
            case APPLE:
                System.out.println("The apple is the pomaceous fruit.");
                break;
                          
            case MANGO:
                System.out.println("The mango is a fleshy stone fruit.");
                break;
              
            case LEMON:
                System.out.println("Lemons are slow growing varieties of citrus.");
                break;
                 
            default:
                System.out.println("No desc available.");
                break;
        }
    }
     
    public static void main(String a[]){
        MyEnumInsideClass grape = new MyEnumInsideClass(MyWrapper.Fruit.GRAPE);
        grape.getFruitDesc();
        MyEnumInsideClass apple = new MyEnumInsideClass(MyWrapper.Fruit.APPLE);
        apple.getFruitDesc();
        MyEnumInsideClass lemon = new MyEnumInsideClass(MyWrapper.Fruit.LEMON);
        lemon.getFruitDesc();
        MyEnumInsideClass guava = new MyEnumInsideClass(MyWrapper.Fruit.GUAVA);
        guava.getFruitDesc();
    }
}
 
class MyWrapper{
     
    enum Fruit {
        GRAPE, APPLE, MANGO, LEMON,GUAVA
    }
}

// basic examle..
class MyBasicEnum {
	 
    private Fruits myFruit;
     
    public MyBasicEnum(Fruits fruit){
        this.myFruit = fruit;
    }
     
    public void getFruitDesc(){
         
        switch (myFruit) {
            case GRAPE:
                System.out.println("A grape is a non-climacteric fruit.");
                break;
                     
            case APPLE:
                System.out.println("The apple is the pomaceous fruit.");
                break;
                          
            case MANGO:
                System.out.println("The mango is a fleshy stone fruit.");
                break;
              
            case LEMON:
                System.out.println("Lemons are slow growing varieties of citrus.");
                break;
                 
            default:
                System.out.println("No desc available.");
                break;
        }
    }
     
    public static void main(String a[]){
        MyBasicEnum grape = new MyBasicEnum(Fruits.GRAPE);
        grape.getFruitDesc();
        MyBasicEnum apple = new MyBasicEnum(Fruits.APPLE);
        apple.getFruitDesc();
        MyBasicEnum lemon = new MyBasicEnum(Fruits.LEMON);
        lemon.getFruitDesc();
        MyBasicEnum guava = new MyBasicEnum(Fruits.GUAVA);
        guava.getFruitDesc();
    }
}
 
enum Fruits {
    GRAPE, APPLE, MANGO, LEMON,GUAVA
}

// How to override toString() method with enum?

class MyEnumtoString {
	 
    enum Fruit {
        GRAPE{
            public String toString(){
                return "A grape is a non-climacteric fruit.";
            }
        },
        APPLE{
            public String toString(){
                return "The apple is the pomaceous fruit.";
            }
        },
        MANGO{
            public String toString(){
                return "The mango is a fleshy stone fruit.";
            }
        },
        LEMON{
            public String toString(){
                return "Lemons are slow growing varieties of citrus.";
            }
        }
    }
     
    public static void main(String a[]){
        System.out.println(Fruit.GRAPE);
        System.out.println(Fruit.APPLE);
        System.out.println(Fruit.MANGO);
    }
}

// How to create custom constructor enum?
class MyEnumCustomConstructor {
	 
    enum Department{
         
        ACCOUNT(12),HR(24),FINANCE(100),SECURITY(108);
         
        private int deptId;
         
        Department(int id){
            deptId = id;
        }
         
        public int getDeptId(){
            return deptId;
        }
    }
     
    public static void main(String a[]){
        System.out.println("Accounts dept id:"+Department.ACCOUNT.getDeptId());
        System.out.println("HR dept id:"+Department.HR.getDeptId());
        System.out.println("Security dept id:"+Department.SECURITY.getDeptId());
    }
}
