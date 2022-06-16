/**
 * @author arindam podder
 * this model is for form page data binding.
 */


package com.nt.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class JobseekerData {

	private Integer id;
	private String name;
	private String address;
	private MultipartFile resume;
	private MultipartFile photo;

}//class end
