package neustadt.contacts;

public class User implements Comparable<User> {

	private String name;
	private Address address;
	private String email;

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;

	}

	public String getSuite() {
		return address.getSuite();
	}

	public String getStreet() {
		return address.getStreet();
	}

	public String getCity() {
		return address.getCity();
	}

	public String getZipcode() {
		return address.getZipcode();
	}

	@Override
	public int compareTo(User user) {
		String[] tempArray1 = this.name.split(" ");
		String[] tempArray2 = user.name.split(" ");
		if (tempArray1[tempArray1.length - 1].equals("V")) {
			return tempArray1[1].compareTo(tempArray2[tempArray2.length - 1]);
		} else if (tempArray2[tempArray2.length - 1].equals("V")) {
			return tempArray1[tempArray1.length - 1].compareTo(tempArray2[1]);
		} else {
			return tempArray1[tempArray1.length - 1].compareTo(tempArray2[tempArray2.length - 1]);
		}
	}
}