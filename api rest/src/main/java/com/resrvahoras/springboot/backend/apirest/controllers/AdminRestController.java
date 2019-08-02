package com.resrvahoras.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resrvahoras.springboot.backend.apirest.models.entity.Admin;
import com.resrvahoras.springboot.backend.apirest.models.services.IAdminService;

@CrossOrigin (origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class AdminRestController {
	
	@Autowired
	private IAdminService adminService;
	@GetMapping("/admins")
	public List<Admin> index(){
		return adminService.findAll();
	}

}
