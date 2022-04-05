package com.synex.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.jpa.repository.Query;

import lombok.Data;

@Data
@Entity
@Table(name="UserS")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userId;
	
	@NotEmpty
	private String userName;
	
	@NotEmpty
	private String userPassword;
	
	@NotEmpty
	@Email
	private String userEmail;
	//valid emails
	//https://help.xmatters.com/ondemand/trial/valid_email_format.htm
	
	@NotEmpty
	private String phone;
	@Embedded
	private Address address;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<FamilyMember> familyMembers = new ArrayList<>();
	
	
	public void setAddress(String country, String addressLine, String city, String state, String zipCode) {
		this.address = new Address();
		
		this.address.setCountry(country);
		this.address.setAddressLine(addressLine);
		this.address.setCity(city);
		this.address.setState(state);
		this.address.setZipCode(zipCode);
		
	}

	public void setFamilyMembers(String asText, String asText2, int asInt) {
		this.familyMembers = new ArrayList<>();
		
		FamilyMember arr = new FamilyMember();
		//arr.setFamilyMemberId(1L);
		arr.setFirstName(asText);
		arr.setLastName(asText2);
		arr.setAge(asInt);
		
		this.familyMembers.add(arr);
		
	}
	
}

