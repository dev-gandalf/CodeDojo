package soloproject.rakshith.newspaper.service;

import java.time.LocalDate;
import java.util.List;

import soloproject.rakshith.newspaper.model.Articles;
import soloproject.rakshith.newspaper.model.EndUser;

public interface ArticleService {
	
	void updateReview(int articleId);
	void saveArticle(Articles article);
	void updateNeedsEdit(int articleId);
	void publishArticle(int articleId, boolean headlines);
	void deleteArticle(int articleId);
	
	
	
	
	
	List<Articles> findByEditor(EndUser editor);
	List<Articles> findByInReview(boolean inReview);
	List<Articles> findByContributor(EndUser contributor);
	List<Articles> findByTimeOfPublish(LocalDate date);
	List<Articles> getArticlesByUserSubscriptions(EndUser subscriber);
	
	
	
	
	Articles findArticleById(int articleId);
	Articles newArticle(String category, String title);
	Articles updateArticle(int id, String category, String title, String article);
}
