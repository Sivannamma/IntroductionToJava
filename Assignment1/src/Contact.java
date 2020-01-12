
public class Contact {
	String name;
	String MobileNumber;

	public Contact(String name, String Mobile) {
		this.name = name;
		MobileNumber = Mobile;
	}

	public Contact(Contact c) {
		this.name = c.name;
		this.MobileNumber = c.MobileNumber;
	}

	public String toString() {
		return "Name: " + name + ", Mobile number: " + MobileNumber;
	}
}
