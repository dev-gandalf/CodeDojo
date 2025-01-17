package soloproject.rakshith.newspaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soloproject.rakshith.newspaper.model.Role;
import soloproject.rakshith.newspaper.repository.RoleRepository;



@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository repo;
	
	@Override
	public Role findByRoleName(String rolename) {
		return repo.findByRoleName(rolename);
	}

	@Override
	public List<Role> findAllRoles() {
		
		return repo.findAll();
	}
	
}
