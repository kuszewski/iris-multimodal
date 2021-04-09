package demo;

import java.sql.Date;

public class Participant {
	public String name;
	public Date dob;
	public Integer cohortID;
	public Address address;
	public PhoneNum phoneNumbers[];

	// Constructors
	public Participant(){}
	
	public Participant(String name, Date dob, Address address, PhoneNum[] phoneNumbers) { 
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.phoneNumbers = phoneNumbers;
	}

}
