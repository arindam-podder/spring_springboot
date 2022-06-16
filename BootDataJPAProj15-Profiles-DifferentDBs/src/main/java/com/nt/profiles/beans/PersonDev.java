package com.nt.profiles.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Profile("dev")
public class PersonDev implements Person {
	private String name = "Arindam Podder";
	private String role = "Developer";
}
