package dp.creationalldesignpattern.builderpattern;

public class User {
	
	private final String firstName;// required
	private final String lastName;// required
	private final int age;// optional
	private final String address;// optional
	
	// this is important
	public User(UserBuilder userBuilder) {
		this.firstName=userBuilder.firstName;
		this.lastName=userBuilder.lastName;
		this.age=userBuilder.age;
		this.address=userBuilder.address;
	}
	// step 1 // All getter to privide immutability
	public int getAge() {
		return age;
	}
	public String getAddress() {
		return address;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", address=" + address
				+ "]";
	}
	
	//step 2 create static inner class
	public static class UserBuilder{
		private final String firstName;// required
		private final String lastName;// required
		private  int age;// optional
		private  String address;// optional
		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		public UserBuilder age(int age) {
			this.age = age;
			return this;
			}
		public UserBuilder address(String address) {
			this.address = address;
			return this;
			}
		//Return the finally consrcuted User object
		public User build() {
		User user = new User(this);
		return user;
		}
	}
	public static void main(String[] args) {
		User user1=new User.UserBuilder("alok", "kumar").age(30).build();
		System.out.println(user1);
		// simillary
		User user2=new User.UserBuilder("dsfs", "dsfs").address("sdfsf").age(55).build();
		System.out.println(user2);
	}
}
