package com.synex.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Data
@Entity
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String documentName;
	private String documentType;
	
	@Lob
	private byte[] data;
	
	public Document() {}

	public Document(String docName, String docType, byte[] data) {
		super();
		this.documentName = docName;
		this.documentType = docType;
		this.data = data;
	}
}
