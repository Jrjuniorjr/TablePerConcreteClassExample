package com.example.TablePerConcreteClassExample.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class HourlyEmployer extends Employer{

	private int noHoursPerDay;	
	private double hourlyRate;
	public int getNoHoursPerDay() {
		return noHoursPerDay;
	}
	public void setNoHoursPerDay(int noHoursPerDay) {
		this.noHoursPerDay = noHoursPerDay;
	}
	public double getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	
	
}
