package com.resrvahoras.springboot.backend.apirest.models.services;

import java.util.List;

import com.resrvahoras.springboot.backend.apirest.models.entity.Admin;

public interface IAdminService {

	public List<Admin> findAll();
}
