package com.Basic.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OTMcollege_employee {
	
	@Id
	@Column(name="empid")
	Integer empid; 
	
	@Column(name="empname")
	String empnamae;
	
	@Column(name="emdept")
	String empdept;
	
	@Column(name="empaddress")
	String empaddress;
	
	@ManyToOne 
	@JoinColumn(name="OTMcollege_fk")
	@JsonIgnoreProperties(value = "*",allowSetters = true)
	OTMcollege otmcollege;

	public OTMcollege_employee() {}
	
	public OTMcollege_employee(Integer empid, String empnamae, String empdept, String empaddress,
			OTMcollege otmcollege) {
		super();
		this.empid = empid;
		this.empnamae = empnamae;
		this.empdept = empdept;
		this.empaddress = empaddress;
		this.otmcollege = otmcollege;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getEmpnamae() {
		return empnamae;
	}

	public void setEmpnamae(String empnamae) {
		this.empnamae = empnamae;
	}

	public String getEmpdept() {
		return empdept;
	}

	public void setEmpdept(String empdept) {
		this.empdept = empdept;
	}

	public String getEmpaddress() {
		return empaddress;
	}

	public void setEmpaddress(String empaddress) {
		this.empaddress = empaddress;
	}

	public OTMcollege getOtmcollege() {
		return otmcollege;
	}

	public void setOtmcollege(OTMcollege otmcollege) {
		this.otmcollege = otmcollege;
	}

	@Override
	public String toString() {
		return "OTMcollege_employee [empid=" + empid + ", empnamae=" + empnamae + ", empdept=" + empdept
				+ ", empaddress=" + empaddress + ", otmcollege=" + otmcollege + "]";
	}

	

     
	
	
}
