package com.synex.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.synex.domain.Role;
import com.synex.domain.User;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserServiceImpl userService;
	
//	@Autowired
//	BookingMicroService bookingMicroService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUserName(username);
		System.out.println("user: "+user.getUserName());
		Set<GrantedAuthority> ga = new HashSet<>();
		/*** do this if user has single role
		ga.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
		*/
		System.out.println("user: "+user);
//		System.out.println("roles: ");
//		Set<Role> roles = user.getRoles();
//		for(Role role:roles) {
//			System.out.println("this is the role being printed: " + role);
//			ga.add(new SimpleGrantedAuthority(role.getRoleName()));
//		}
		
//		JsonNode userJson = JsonNodeFactory.instance.objectNode();
//		
//		JsonNode newNode = ((ObjectNode) userJson)
//				.put("userEmail", user.getUserEmail())
//				.put("userName", user.getUserName());
//
//		bookingMicroService.updateBooking(newNode);

		return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getUserPassword(),ga);
	}

}
