package com.synex.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Embeddable
public class Address {
	@NotEmpty
	private String addressLine;
	@NotEmpty
	private String city;
	@NotEmpty
	private String state;
	@NotEmpty
	private String zipCode;
	@NotEmpty
	private String country;
}
