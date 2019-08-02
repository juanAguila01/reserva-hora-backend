package com.resrvahoras.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resrvahoras.springboot.backend.apirest.models.dao.IAdminDao;
import com.resrvahoras.springboot.backend.apirest.models.entity.Admin;

@Service
public class AdminServiceImpl implements IAdminService{
	
	@Autowired
	private IAdminDao adminDao;

	@Override
	@Transactional(readOnly = true)
	public List<Admin> findAll() {
		return (List<Admin>) adminDao.findAll();
	}

}
