package com.nt.service;

import java.util.List;

import com.nt.model.Jobseeker;


public interface IJobseekerManagementService {
	
	public String registerJobseeker(Jobseeker jobseeker);
	
	public List<Jobseeker> getAllJobseeker();
	
	public String getResumePath(Integer id);
	
	public String getPhotoPath(Integer id);
	
}
