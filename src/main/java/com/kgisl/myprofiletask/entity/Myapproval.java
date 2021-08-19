package com.kgisl.myprofiletask.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class MyApproval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Long id;
    private String empid;
    private String approvallevel;  
    private String managername; 
    private String manageremail; 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profileid", updatable = false, insertable = true)
    private MyProfile myProfile;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmpid() {
        return empid;
    }
    public void setEmpid(String empid) {
        this.empid = empid;
    }
    public String getApprovallevel() {
        return approvallevel;
    }
    public void setApprovallevel(String approvallevel) {
        this.approvallevel = approvallevel;
    }
    public String getManagername() {
        return managername;
    }
    public void setManagername(String managername) {
        this.managername = managername;
    }
    public String getManageremail() {
        return manageremail;
    }
    public void setManageremail(String manageremail) {
        this.manageremail = manageremail;
    }
    public MyProfile getMyProfile() {
        return myProfile;
    }
    public void setMyProfile(MyProfile myProfile) {
        this.myProfile = myProfile;
    }
}