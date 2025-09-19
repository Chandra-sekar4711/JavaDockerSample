package com.Basic.Model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class OTMuniversity {

	@Id
	@Column(name="universityid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer universityid;
	@Column(name="universityname")
	String universityname;
	@Column(name="universityrank")
	int universityrank;
	@Column(name="universitylocation")
	String universitylocation;
	
	
	@OneToMany(mappedBy = "otmuniversity", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value = "otmuniversity,",allowSetters = true)
	List<OTMcollege> otmcollege = new ArrayList();
	
	
	public void addCollege(OTMcollege college) {
	    otmcollege.add(college);
	    college.setOtmuniversity(this);
	}

	public OTMuniversity() {}
	
	public OTMuniversity(Integer universityid, String universityname, int universityrank, String universitylocation,
			List<OTMcollege> otmcollege) {
		super();
		this.universityid = universityid;
		this.universityname = universityname;
		this.universityrank = universityrank;
		this.universitylocation = universitylocation;
		this.otmcollege = otmcollege;
	}

	public Integer getUniversityid() {
		return universityid;
	}

	public void setUniversityid(Integer universityid) {
		this.universityid = universityid;
	}

	public String getUniversityname() {
		return universityname;
	}

	public void setUniversityname(String universityname) {
		this.universityname = universityname;
	}

	public int getUniversityrank() {
		return universityrank;
	}

	public void setUniversityrank(int universityrank) {
		this.universityrank = universityrank;
	}

	public String getUniversitylocation() {
		return universitylocation;
	}

	public void setUniversitylocation(String universitylocation) {
		this.universitylocation = universitylocation;
	}

	public List<OTMcollege> getOtmcollege() {
		return otmcollege;
	}

	public void setOtmcollege(List<OTMcollege> otmcollege) {
		this.otmcollege = otmcollege;
	}

	@Override
	public String toString() {
		return "OTMuniversity [universityid=" + universityid + ", universityname=" + universityname
				+ ", universityrank=" + universityrank + ", universitylocation=" + universitylocation + ", otmcollege="
				+ otmcollege + "]";
	}

	

	
}
