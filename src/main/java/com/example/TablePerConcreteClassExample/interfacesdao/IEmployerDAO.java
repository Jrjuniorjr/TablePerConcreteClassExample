package com.example.TablePerConcreteClassExample.interfacesdao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TablePerConcreteClassExample.model.Employer;


public interface IEmployerDAO extends JpaRepository<Employer, Integer>{
	public Employer findByEmpNo(int empNo);
}
