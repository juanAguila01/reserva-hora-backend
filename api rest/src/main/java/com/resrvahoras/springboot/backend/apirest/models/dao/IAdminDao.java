package com.resrvahoras.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.resrvahoras.springboot.backend.apirest.models.entity.Admin;

public interface IAdminDao extends CrudRepository<Admin, Long>{

}
