package com.example.TablePerConcreteClassExample.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="Employer")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Employer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="empNo")
	private int empNo;
	@Column(name="eName")
	private String eName;
	
	
	
	public Employer(int empNo, String eName) {
		super();
		this.empNo = empNo;
		this.eName = eName;
	}

	public Employer() {
		
	}
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	
	
}
