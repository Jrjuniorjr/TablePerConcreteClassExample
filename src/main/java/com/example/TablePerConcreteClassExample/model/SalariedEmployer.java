package com.example.TablePerConcreteClassExample.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.SessionAttributes;

@Entity
public class SalariedEmployer extends Employer{

	protected double annualSalary;

	
	public SalariedEmployer(int empNo, String eName, double annualSalary) {
		super(empNo, eName);
		this.annualSalary = annualSalary;
	}

	public SalariedEmployer() {
		
	}
	
	public double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}
	
}
