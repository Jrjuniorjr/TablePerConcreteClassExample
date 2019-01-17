package com.example.TablePerConcreteClassExample.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.SessionAttributes;

@Entity
@Table(name = "SalariedEmployer")
@AttributeOverrides({
	@AttributeOverride(name="empNo", column=@Column(name="empNo")),
    @AttributeOverride(name="eName", column=@Column(name="eName"))
})
public class SalariedEmployer extends Employer{

	@Column(name="annualSalary")
	private double annualSalary;

	
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
