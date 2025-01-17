package soloproject.rakshith.newspaper.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import soloproject.rakshith.newspaper.model.EndUser;



@Repository
public interface UserRepository extends JpaRepository<EndUser, Integer>{
	Optional<EndUser> findByUsername(String username);
}	
