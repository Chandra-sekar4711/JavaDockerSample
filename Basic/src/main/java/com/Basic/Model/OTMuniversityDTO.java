package com.Basic.Model;

import java.util.List;

public class OTMuniversityDTO {

    private Integer universityid;
    private String universityname;
    private int universityrank;
    private String universitylocation;
    private List<String> collegename;
    private List<String> empdept;
    

    // Constructors
    public OTMuniversityDTO() {}

    public OTMuniversityDTO(Integer universityid, String universityname, int universityrank, String universitylocation,List<String> collegename,List<String> empdept ) {
        this.universityid = universityid;
        this.universityname = universityname;
        this.universityrank = universityrank;
        this.universitylocation = universitylocation;
        this.collegename = collegename;
        this.empdept = empdept;
    }

    // Getters and Setters
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
    
    public List<String> getCollegename() {
    	return collegename;
    }
    
    public void setCollegename(List<String> collegename)
    {
    	this.collegename = collegename;
    }

	public List<String> getEmpdept() {
		return empdept;
	}

	public void setEmpdept(List<String> empdept) {
		this.empdept = empdept;
	}
    
    
}