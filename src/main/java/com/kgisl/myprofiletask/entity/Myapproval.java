package com.kgisl.myprofiletask.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Myapproval {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
	private Long Id;

    @Column
	private String empId;

	@Column
	private String level;

	@Column
	private String name;

	@Column
	private String email;

    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "myprofileId", updatable = false, insertable = true)
	private Myprofile myprofile;

	public Myapproval() {
		super();
	}

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public String getEmpId() {
        return empId;
    }
    public void setEmpId(String empId) {
        this.empId = empId;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setMyprofile(Myprofile myprofile) {
		this.myprofile = myprofile;
    }
}

