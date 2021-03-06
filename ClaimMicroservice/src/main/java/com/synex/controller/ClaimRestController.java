package com.synex.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.synex.domain.Claim;
import com.synex.domain.Document;
import com.synex.services.ClaimServices;
import com.synex.services.DocumentServices;

@RestController
public class ClaimRestController {
	@Autowired 
	private DocumentServices documentServices;
	
	@Autowired
	private ClaimServices claimServices;
	
	@GetMapping("/")
	public String get(Model model) {
		List<Document> docs = documentServices.getFiles();
		model.addAttribute("docs", docs);
		return "doc";
	}
	
	@PostMapping("/uploadFiles")
	public JsonNode uploadMultipleFiles(@RequestBody JsonNode data) {
		System.out.println("/uploadFiles : "+data);
		
		JsonNode node = JsonNodeFactory.instance.objectNode();
		int numFiles=data.get("numFiles").asInt();
		for(int i=0; i<numFiles; i++) {
			((ObjectNode) node)
				.put("OGfileName", data.get("OGfileName"+i).asText())
				.put("contentType", data.get("contentType"+i).asText())
				.put("fileBytes", data.get("fileBytes"+i).asText());
			
			documentServices.saveFile(node);
		}
		return data;
	}
	
	
	@PostMapping("/displayFile")
	public ResponseEntity<ByteArrayResource> displayFile(@RequestParam int fileId) throws IOException{
			System.out.println(fileId);
		
			
			Document doc = documentServices.getFile(Long.valueOf(fileId)).get();
			System.out.println(doc);
			File file = new File("test");
			
			FileOutputStream fileStream = new FileOutputStream(file);
			fileStream.write(doc.getData());
			
			
			return ResponseEntity.ok()
					.contentType(MediaType.parseMediaType(doc.getDocumentType()))
					.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getDocumentName()+"\"")
					.body(new ByteArrayResource(doc.getData()));
		
	}
	
	@PostMapping("/downloadFile")
	public JsonNode downloadFile(@RequestBody JsonNode data){
		
		Claim claim = claimServices.getClaimById(data.get("userId").asLong());
		
		List <Document> docs = claim.getDocuments();
		for(Document docc : docs) {
			Document doc = documentServices.getFile(docc.getId()).get();
			JsonNode node = JsonNodeFactory.instance.objectNode();
			((ObjectNode) node)
				.put("OGfileName", doc.getDocumentName())
				.put("contentType", doc.getDocumentType())
				.put("fileBytes", doc.getData());
			return node;
		}
		return data;
	}
	
//	@GetMapping("/downloadFile")
//	public ResponseEntity<ByteArrayResource> downloadFile(@RequestBody JsonNode data){
//		
//		Claim claim = claimServices.getClaimById(data.get("userId").asLong());
//		
//		List <Document> docs = claim.getDocuments();
//		for(Document docc : docs) {
//			Document doc = documentServices.getFile(docc.getId()).get();
//			return ResponseEntity.ok()
//					.contentType(MediaType.parseMediaType(doc.getDocumentType()))
//					.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getDocumentName()+"\"")
//					.body(new ByteArrayResource(doc.getData()));
//		}
//	}
}
