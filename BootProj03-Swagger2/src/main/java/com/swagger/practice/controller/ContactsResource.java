package com.swagger.practice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.practice.model.Contact;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@RestController
@RequestMapping("/contact")
public class ContactsResource {

	ConcurrentHashMap<String, Contact> contacts = new ConcurrentHashMap<>();
	
	@GetMapping("/")
	public List<Contact> getAllContact(){
		//return (List<Contact>) contacts.values();
		return new ArrayList<>(contacts.values());
	}
	
	@GetMapping("/{id}")
	public Contact getContact(@PathVariable String id) {
		return contacts.get(id);
	}
	
	@PostMapping("/")
	public Contact addContact(@RequestBody Contact contact) {
		contacts.put(contact.getId(), contact);
		return contact;
	}
	
	
}
