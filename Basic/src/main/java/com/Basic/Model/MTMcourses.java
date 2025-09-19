package com.Basic.Model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class MTMcourses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="courseid")
    private Integer courseid;

    @Column(name="coursename")
    private String coursename;

    @Column(name="courseprice")
    private int courseprice;

    @ManyToMany(mappedBy = "mtmcourses", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<MTMstudents> mtmstudents = new HashSet<>();

    // Getters and Setters
    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getCourseprice() {
        return courseprice;
    }

    public void setCourseprice(int courseprice) {
        this.courseprice = courseprice;
    }

    public Set<MTMstudents> getMtmstudents() {
        return mtmstudents;
    }

    public void setMtmstudents(Set<MTMstudents> mtmstudents) {
        this.mtmstudents = mtmstudents;
    }

	@Override
	public String toString() {
		return "MTMcourses [courseid=" + courseid + ", coursename=" + coursename + ", courseprice=" + courseprice
				+ ", mtmstudents=" + mtmstudents + "]";
	}
    
    
}
