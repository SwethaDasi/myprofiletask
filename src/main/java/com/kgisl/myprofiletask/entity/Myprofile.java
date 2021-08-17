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
    private Long Id;

	@Column
	private String myprofileId;

    @Column
	private String myprofilename;

	@Column
	private String designation;

	@Column
	private String bussinessvertical;

	@Column
	private String project;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "myprofileId")
	private List<Myapproval> myapproval; 
	
	public Myprofile() {
		super();
	}

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public String getMyprofileId() {
        return myprofileId;
    }
    public void setMyprofileId(String myprofileId) {
        this.myprofileId = myprofileId;
    }
    public String getMyprofilename() {
        return myprofilename;
    }
    public void setmyprofilename(String myprofilename) {
        this.myprofilename = myprofilename;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getBussinessvertical() {
        return bussinessvertical;
    }
    public void setBussinessvertical(String bussinessvertical) {
        this.bussinessvertical = bussinessvertical;
    }
    public String getProject() {
        return project;
    }
    public void setProject(String project) {
        this.project = project;
    }
    
    public List<Myapproval> getMyapproval() {
		return myapproval;
	}

	public void setMyapproval(List<Myapproval> myapproval) {
		this.myapproval = myapproval;
	}

}
