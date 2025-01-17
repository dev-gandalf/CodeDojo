package com.groupone.shazar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupone.shazar.model.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByRoleName(String rolename);

}
