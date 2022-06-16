package com.nt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Jobseeker;
import com.nt.repository.IJobseekerRepository;
import com.nt.service.IJobseekerManagementService;

@Service
public class JobseekerManagementServiceImpl implements IJobseekerManagementService {

	@Autowired
	private IJobseekerRepository jobseekerRepository;
	
	@Override
	public String registerJobseeker(Jobseeker jobseeker) {
		Jobseeker savedJobseeker = jobseekerRepository.save(jobseeker);
		return "Job seeker data saved  with the id value "+savedJobseeker.getId();
	}
	
	@Override
	public List<Jobseeker> getAllJobseeker() {
		return jobseekerRepository.findAll();
	}
	
	@Override
	public String getResumePath(Integer id) {
		return jobseekerRepository.getResumePathById(id);
	}
	
	@Override
	public String getPhotoPath(Integer id) {
		return jobseekerRepository.getPhotoPathById(id);				
	}
	
}//class end
