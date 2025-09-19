package com.Basic.Model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class MTMstudents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sid")
    private Integer id;

    @Column(name="sname")
    private String sname;

    @Column(name="Sage")
    private int age;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "student_course",
        joinColumns = { @JoinColumn(name = "student_fk") },
        inverseJoinColumns = { @JoinColumn(name = "courses_fk") }
    )
    private Set<MTMcourses> mtmcourses = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<MTMcourses> getMtmcourses() {
        return mtmcourses;
    }

    public void setMtmcourses(Set<MTMcourses> mtmcourses) {
        this.mtmcourses = mtmcourses;
    }

	@Override
	public String toString() {
		return "MTMstudents [id=" + id + ", sname=" + sname + ", age=" + age + ", mtmcourses=" + mtmcourses + "]";
	}
    
    
}
