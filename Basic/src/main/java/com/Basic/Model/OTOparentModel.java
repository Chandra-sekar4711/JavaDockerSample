package com.Basic.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OTOparentModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="parentid")
	Integer parentid ;
	@Column(name="fname")
	String fname;
	@Column(name="mname")
	String mname;
	
	
	public OTOparentModel() {}
	
	public OTOparentModel( String fname, String mname) {
		super();
		
		this.fname = fname;
		this.mname = mname;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	@Override
	public String toString() {
		return "OTOparentModel [parentid=" + parentid + ", fname=" + fname + ", mname=" + mname + "]";
	}
	
	
	

}
