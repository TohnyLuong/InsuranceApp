package com.synex.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.synex.domain.Document;
import com.synex.repository.DocumentRepository;

@Service
public class DocumentServicesImpl implements DocumentServices{

	@Autowired
	private DocumentRepository documentRepository;
	
	public Document saveFile(JsonNode file) {
		String docname = file.get("OGfileName").asText();
		String contentType = file.get("contentType").asText();
		String stringFileBytes = file.get("fileBytes").asText();
		byte[] fileByteArr = stringFileBytes.getBytes();
		Document doc = new Document(docname,contentType,fileByteArr);
	    System.out.println("Doc:"+doc);
	    
		  try {
			  return documentRepository.save(doc);
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  return null;
	}
	
	public Optional<Document> getFile(Long fileId) {
	  return documentRepository.findById(fileId);
	}
 	
	public List<Document> getFiles(){
	  return documentRepository.findAll();
 	}
}
