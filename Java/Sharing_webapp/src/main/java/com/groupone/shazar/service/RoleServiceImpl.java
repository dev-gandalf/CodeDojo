package com.groupone.shazar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupone.shazar.model.Role;
import com.groupone.shazar.repository.RoleRepository;



@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository repo;
	
	@Override
	public Role findByRoleName(String rolename) {
		return repo.findByRoleName(rolename);
	}
	
}
