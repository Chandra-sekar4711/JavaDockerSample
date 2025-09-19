package com.Basic.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class OTMcollege {
	@Id
	@Column(name="collegeid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer collegeid;
	@Column(name="collegename")
	String collegename;
	@Column(name="collegelocation")
	String collegelocation;
	
	@ManyToOne
	@JoinColumn(name="OTM_fk")
	@JsonIgnoreProperties(value = "otmcollege",allowSetters = true)
	OTMuniversity otmuniversity;
	
	
	@OneToMany(mappedBy = "otmcollege", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "otmcollege",allowSetters = true)
	List<OTMcollege_employee> otmcollege_employee = new ArrayList();
	
	public void addCollege_employee(OTMcollege_employee college_employee) {
		otmcollege_employee.add(college_employee);
		college_employee.setOtmcollege(this);
	}
	
	public OTMcollege() {}


	public OTMcollege(Integer collegeid, String collegename, String collegelocation, OTMuniversity otmuniversity,
			List<OTMcollege_employee> otmcollege_employee) {
		super();
		this.collegeid = collegeid;
		this.collegename = collegename;
		this.collegelocation = collegelocation;
		this.otmuniversity = otmuniversity;
		this.otmcollege_employee = otmcollege_employee;
	}


	public Integer getCollegeid() {
		return collegeid;
	}


	public void setCollegeid(Integer collegeid) {
		this.collegeid = collegeid;
	}


	public String getCollegename() {
		return collegename;
	}


	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}


	public String getCollegelocation() {
		return collegelocation;
	}


	public void setCollegelocation(String collegelocation) {
		this.collegelocation = collegelocation;
	}


	public OTMuniversity getOtmuniversity() {
		return otmuniversity;
	}


	public void setOtmuniversity(OTMuniversity otmuniversity) {
		this.otmuniversity = otmuniversity;
	}


	public List<OTMcollege_employee> getOtmcollege_employee() {
		return otmcollege_employee;
	}


	public void setOtmcollege_employee(List<OTMcollege_employee> otmcollege_employee) {
		this.otmcollege_employee = otmcollege_employee;
	}

	@Override
	public String toString() {
		return "OTMcollege [collegeid=" + collegeid + ", collegename=" + collegename + ", collegelocation="
				+ collegelocation + ", otmuniversity=" + otmuniversity + ", otmcollege_employee=" + otmcollege_employee
				+ "]";
	}

	


	
	
	

}
