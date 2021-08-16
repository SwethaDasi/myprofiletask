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
public class Employee {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;

	@Column
	private String level;

	@Column
	private String name;

	@Column
	private String email;

    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "myprofileId", updatable = false, insertable = true)
	private Myprofile myprofile;

	public Employee() {
		super();
	}

    public Long getEId() {
        return employeeId;
    }
    public void setEId(Long employeeId) {
        this.employeeId = employeeId;
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

