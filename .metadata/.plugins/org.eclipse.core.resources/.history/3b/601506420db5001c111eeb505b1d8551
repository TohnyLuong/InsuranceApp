package com.synex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.synex.domain.User;
import com.synex.model.InsuranceModel;
import com.synex.repository.UserRepository;
import com.synex.restclient.BookingClient;
import com.synex.restclient.HotelClient;
import com.synex.services.InsuranceService;
import com.synex.services.InsuranceServiceImpl;


@RestController
public class GatewayController {

	@Autowired
	HotelClient hotelClient;
	
	@Autowired
	BookingClient bookingClient;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	InsuranceServiceImpl insuranceService;
	
	@PostMapping(value="/searchHotel")
	public ResponseEntity<JsonNode> searchHotel(@RequestBody JsonNode node) {
		JsonNode responseNode = hotelClient.searchHotel(node);
		
		/////// hi this is tohnyxxxxx
		return new ResponseEntity<JsonNode>(responseNode,HttpStatus.OK);
	}
	
	@PostMapping(value="/getHotelRoom")
	public ResponseEntity<JsonNode> getHotelRoom(@RequestBody JsonNode node) {
		JsonNode responseNode = hotelClient.getHotelRoom(node);
		return new ResponseEntity<JsonNode>(responseNode,HttpStatus.OK);
	}
	
	@PostMapping(value="/saveBooking")
	public ResponseEntity<JsonNode> saveBooking(@RequestBody JsonNode node,Authentication authentication) {
		String userName = authentication.getName();
		User user = userRepository.findByUserName(userName);
		((ObjectNode) node).put("userName", userName);
		((ObjectNode) node).put("userEmail", user.getUserEmail());
		
		JsonNode responseNode = bookingClient.saveBooking(node);
		return new ResponseEntity<JsonNode>(responseNode,HttpStatus.OK);
	}
	
	@PostMapping(value="/saveInsurance")
	public ResponseEntity<String> saveInsurance(@RequestBody InsuranceModel insuranceModel,Authentication authentication) {
		String userName = authentication.getName();
		String response = insuranceService.saveInsurance(insuraceModel);
		return new ResponseEntity<JsonNode>(responseNode,HttpStatus.OK);
	}
	
}
