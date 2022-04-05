package com.synex.services;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;
import com.synex.domain.Document;

public interface DocumentServices {

	public Document saveFile(JsonNode file);
	
	public Optional<Document> getFile(Long fileId);
	
	public List<Document> getFiles();
}
