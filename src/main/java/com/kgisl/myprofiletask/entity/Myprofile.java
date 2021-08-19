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
public class MyProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long profileid;
    private String empid; 
    private String empname;
    private String designation;
    private String business;
    private String project;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "profileid")
    private List<MyApproval> myApproval;
    public Long getProfileid() {
        return profileid;
    }
    public void setProfileid(Long profileid) {
        this.profileid = profileid;
    }
    public String getEmpid() {
        return empid;
    }
    public void setEmpid(String empid) {
        this.empid = empid;
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
    public String getBusiness() {
        return business;
    }
    public void setBusiness(String business) {
        this.business = business;
    }
    public String getProject() {
        return project;
    }
    public void setProject(String project) {
        this.project = project;
    }
    public List<MyApproval> getMyApproval() {
        return myApproval;
    }
    public void setMyApproval(List<MyApproval> myApproval) {
        this.myApproval = myApproval;
    }
}
