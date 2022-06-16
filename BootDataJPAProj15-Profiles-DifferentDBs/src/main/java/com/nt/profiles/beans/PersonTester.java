package com.nt.profiles.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Profile("test")
public class PersonTester implements Person {
	private String name = "Arjun Podder";
	private String role = "Tester";
}
