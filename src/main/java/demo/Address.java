package demo;

public class Address {
	public String street;
	public String city;
	public String state;
	public Integer zip;

	// Constructors
	public Address(){}
	
	public Address(String street, String city, String state, Integer zip) { 
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
}
