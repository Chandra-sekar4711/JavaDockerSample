package com.Basic.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class OTOpersonModel {
	
	@Id
	@Column(name="personid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer personid;
	@Column(name="name")
	String name;
	@Column(name="age")
	int age;
	@Column(name="job")
	String job;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="OTO_FK",referencedColumnName ="parentid" )
	OTOparentModel otoparentmodel;
	
	
	public OTOpersonModel() {}


	public OTOpersonModel(Integer personid, String name, int age, String job, OTOparentModel otoparentmodel) {
		super();
		this.personid = personid;
		this.name = name;
		this.age = age;
		this.job = job;
		this.otoparentmodel = otoparentmodel;
	}


	public Integer getPersonid() {
		return personid;
	}


	public void setPersonid(Integer personid) {
		this.personid = personid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public OTOparentModel getOtoparentmodel() {
		return otoparentmodel;
	}


	public void setOtoparentmodel(OTOparentModel otoparentmodel) {
		this.otoparentmodel = otoparentmodel;
	}


	@Override
	public String toString() {
		return "OTOpersonModel [personid=" + personid + ", name=" + name + ", age=" + age + ", job=" + job
				+ ", otoparentmodel=" + otoparentmodel + "]";
	}
	
	
	
	

}
