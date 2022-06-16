package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nt.model.Jobseeker;
import com.nt.model.JobseekerData;
import com.nt.service.IJobseekerManagementService;

@Controller
public class JobSeekerController {

	@Autowired
	private IJobseekerManagementService service;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(path = "/")
	public String home() {
		return "home";
	}
	
	@GetMapping(path = "/register")
	public String showRegisterForm(@ModelAttribute("js") JobseekerData jobseekerData) {
		return "js_register";
	}
	
	@PostMapping(path = "/register")
	public String registerJsWithuploadedFile(@ModelAttribute("js") JobseekerData jobseekerData,
											 Map<String, Object> map) throws Exception {
		//get server side file location where uploaded file will be store
		String fileStoreLocation = environment.getRequiredProperty("upload.store");
		File file = new File(fileStoreLocation);
		if(!file.exists()) {
			file.mkdir();
		}
		
		//get uploaded file 
		MultipartFile resumeFile = jobseekerData.getResume();
		MultipartFile photoFile = jobseekerData.getPhoto();
		//get input stream representing the uploaded file content
		InputStream isResume = resumeFile.getInputStream();
		InputStream isPhoto = photoFile.getInputStream();
		//get the name of uploaded file
		String uploadedResumeFileName = resumeFile.getOriginalFilename();
		String uploadedPhotoFileName = photoFile.getOriginalFilename();
		//ctreate output stream representing emty destination file
		OutputStream osResume = new FileOutputStream(file.getAbsolutePath()+"/"+
														jobseekerData.getName()+"_"+uploadedResumeFileName);
		OutputStream osPhoto = new FileOutputStream(file.getAbsolutePath()+"/"+
													jobseekerData.getName()+"_"+uploadedPhotoFileName);
		//perform file copy operation
		IOUtils.copy(isResume, osResume);
		IOUtils.copy(isPhoto, osPhoto);
		//close the stream
		isResume.close();
		isPhoto.close();
		osResume.close();
		osPhoto.close();
		//add details to entity class object and save to db
		Jobseeker jobseeker = new Jobseeker();
		jobseeker.setName(jobseekerData.getName());
		jobseeker.setAddress(jobseekerData.getAddress());
		jobseeker.setResumePath(file.getAbsolutePath()+"/"+jobseekerData.getName()+"_"+uploadedResumeFileName);
		jobseeker.setPhotoPath(file.getAbsolutePath()+"/"+jobseekerData.getName()+"_"+uploadedPhotoFileName);
		//save the data into db 
		String registeredJobseekerMsg = service.registerJobseeker(jobseeker);
		//put require data to model 
		map.put("resultMsg", registeredJobseekerMsg);
		map.put("uploadedResumeName", uploadedResumeFileName);
		map.put("uploadedPhotoName", uploadedPhotoFileName);
		return "show_result";
	}
	
	@GetMapping(path = "/js_list")
	public String showJobseekjerReport(Map<String, Object> map) {
		List<Jobseeker> allJobseekersList = service.getAllJobseeker();
		//put js list data in model 
		map.put("jsList", allJobseekersList);
		return "show_report";
	}

	@Autowired
	private ServletContext context; 
	
	@GetMapping(path = "/download")
	public String fileDownload(@RequestParam("id") Integer id , @RequestParam("fileType") String type,
							   HttpServletResponse response)throws Exception {
		
		//get the path of the file that needs to be download
		String filePath = null;
		if(type.equals("resume")){
			filePath = service.getResumePath(id);
		}
		else {
			filePath = service.getPhotoPath(id);
		}
		
		//create a File obj representing file to be download
		File file = new File(filePath);
		//get the content length of the file and make it response content length
		long fileLength = file.length();
		response.setContentLengthLong(fileLength);
		//get MIME type of the file and make it response content type
		String fileMimeType = context.getMimeType(filePath);
		fileMimeType = fileMimeType==null?"application/octet-stream":fileMimeType;
		response.setContentType(fileMimeType);
		//instruct the browser to give file content as downloadble file
		response.setHeader("Content-Disposition", "attachment;fileName="+file.getName());
		//create inputstream pointing to the file , for read operation
		InputStream is = new FileInputStream(file);
		//create outputstrwam pointing to the response object
		ServletOutputStream outputStream = response.getOutputStream();
		//write file content to response object
		IOUtils.copy(is, outputStream);
		//close the streams
		is.close();
		outputStream.close();
		return null;
	}
	
}//class end
















