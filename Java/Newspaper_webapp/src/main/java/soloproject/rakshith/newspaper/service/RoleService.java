package soloproject.rakshith.newspaper.service;

import java.util.List;

import soloproject.rakshith.newspaper.model.Role;

public interface RoleService {

	Role findByRoleName(String string);
	List<Role> findAllRoles();

}
