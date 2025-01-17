package soloproject.rakshith.newspaper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import soloproject.rakshith.newspaper.model.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByRoleName(String rolename);

}
