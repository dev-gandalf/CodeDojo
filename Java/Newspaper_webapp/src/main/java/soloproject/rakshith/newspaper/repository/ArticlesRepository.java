package soloproject.rakshith.newspaper.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import soloproject.rakshith.newspaper.model.Articles;
import soloproject.rakshith.newspaper.model.Category;
import soloproject.rakshith.newspaper.model.EndUser;



@Repository
public interface ArticlesRepository extends JpaRepository<Articles, Integer> {
	
	List<Articles> findByContributor(EndUser contributor);
	List<Articles> findByInReview(boolean inReview);
	List<Articles> findByEditor(EndUser editor);
	List<Articles> findByCategory(Category category);
	List<Articles> findByTimeOfPublish(LocalDate date);

}
