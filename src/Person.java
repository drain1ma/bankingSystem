
public class Person {

	private String firstName; 
	private String lastName; 
	private String licenseNumber;
	
	/**
	 * @param firstName - allows for a person's first name
	 * @param lastName - allows for a person's last name
	 * @param licenseNumber - the license number of that person
	 */
	public Person(String firstName, String lastName, String licenseNumber) {
		this.firstName = firstName;
		this.lastName = lastName; 
		this.licenseNumber = licenseNumber; 
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	} 
	
	
}