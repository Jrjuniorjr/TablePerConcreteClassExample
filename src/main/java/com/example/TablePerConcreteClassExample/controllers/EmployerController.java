package com.example.TablePerConcreteClassExample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TablePerConcreteClassExample.services.EmployerService;


@RestController
@RequestMapping("/employer")
public class EmployerController {
	
	@Autowired
	private EmployerService employerService;
	
	
	@PostMapping("/save")
	public ResponseEntity<?> saveEmployer(@RequestParam("empNo") int empNo,
			@RequestParam("eName") String eName, @RequestParam("annualSalary") double annualSalary){
		return employerService.saveEmployer(empNo, eName, annualSalary); 
	}

	@GetMapping("/findByEmpNo/{empNo}")
	public ResponseEntity<?> findEmployerByEmpNo(@PathVariable("empNo") int empNo){
		return employerService.findByEmpNo(empNo);
	}
}
