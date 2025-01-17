package soloproject.rakshith.newspaper.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import soloproject.rakshith.newspaper.model.Category;



@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	
	Optional<Category> findByNameIgnoreCase(String name);
}
