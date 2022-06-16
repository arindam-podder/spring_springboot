/**
 * @author arindam Podder
 * this model act as entity means for db persistence 
 */

package com.nt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "jobseeker")
public class Jobseeker {

	@Id
	@SequenceGenerator(name="js_generator",sequenceName="js_sequence",allocationSize=1,initialValue = 100)
	@GeneratedValue(generator="js_generator", strategy=GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private String address;
	@Column(name = "resume_path")
	private String resumePath;
	@Column(name = "photo_path")
	private String photoPath;

}//class end
