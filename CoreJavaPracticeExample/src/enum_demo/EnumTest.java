package enum_demo;


public class EnumTest {

	public enum Direction{NORTH,SOUTH,EAST,WEST};
	
	public static void main(String[] args) {
	 System.out.println(new insert().d);

	}

}
class insert{
	EnumTest.Direction d= EnumTest.Direction.EAST;
}