package com.kgisl.myprofiletask.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Myprofile {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long myprofileId;

    @Column
	private String empname;

	@Column
	private String designation;

	@Column
	private String bussiness;

	@Column
	private Boolean project;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "myprofileId")
	private List<Employee> employee; 
	
	public Myprofile() {
		super();
	}

    public Long getId() {
        return myprofileId;
    }
    public void setId(Long myprofileId) {
        this.myprofileId = myprofileId;
    }
    public String getEmpname() {
        return empname;
    }
    public void setEmpname(String empname) {
        this.empname = empname;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getBussiness() {
        return bussiness;
    }
    public void setBussiness(String bussiness) {
        this.bussiness = bussiness;
    }
    public Boolean getProject() {
        return project;
    }
    public void setProject(Boolean project) {
        this.project = project;
    }
    
    public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

}
