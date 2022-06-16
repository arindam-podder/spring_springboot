package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.model.Jobseeker;

public interface IJobseekerRepository extends JpaRepository<Jobseeker, Integer> {

	@Query(value = "select resumePath from Jobseeker where id=:id")
	public String getResumePathById(@Param("id") Integer id);
	
	@Query(value = "select photoPath from Jobseeker where id=?1")
	public String getPhotoPathById(Integer id);
	
}
