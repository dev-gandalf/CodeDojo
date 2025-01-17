package soloproject.rakshith.newspaper.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soloproject.rakshith.newspaper.model.Articles;
import soloproject.rakshith.newspaper.model.Category;
import soloproject.rakshith.newspaper.model.EndUser;
import soloproject.rakshith.newspaper.repository.ArticlesRepository;
import soloproject.rakshith.newspaper.repository.CategoryRepository;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticlesRepository repo;
	@Autowired
	CategoryRepository catRepo;

	@Override
	public void saveArticle(Articles article) {
		repo.save(article);

	}

	@Override
	public List<Articles> findByContributor(EndUser contributor) {

		return repo.findByContributor(contributor);
	}

	public Articles findArticleById(int articleId) {

		return repo.findById(articleId).get();
	}

	@Override
	public Articles updateArticle(int id, String category, String title, String article) {
		Articles updatedArticle = repo.findById(id).get();
		updatedArticle.setArticle(article);
		updatedArticle.setTitle(title);

		Category newCategory = new Category();
		if (catRepo.findByNameIgnoreCase(category).isPresent()) {

			newCategory = catRepo.findByNameIgnoreCase(category).get();

		} else {
			newCategory.setName(category);
		}

		updatedArticle.setCategory(newCategory);

		repo.saveAndFlush(updatedArticle);
		return updatedArticle;

	}

	@Override
	public void updateReview(int articleId) {
		Articles updatedArticle = repo.findById(articleId).get();
		updatedArticle.setInReview(true);
		updatedArticle.setReEdit(false);
		repo.saveAndFlush(updatedArticle);

	}

	@Override
	public void updateNeedsEdit(int articleId) {
		Articles updatedArticle = repo.findById(articleId).get();
		updatedArticle.setReEdit(true);
		repo.saveAndFlush(updatedArticle);

	}

	@Override
	public List<Articles> findByInReview(boolean inReview) {

		return repo.findByInReview(inReview);
	}

	@Override
	public List<Articles> findByEditor(EndUser editor) {

		return repo.findByEditor(editor);
	}

	@Override
	public void publishArticle(int articleId, boolean headlines) {
		Articles updatedArticle = repo.findById(articleId).get();
		updatedArticle.setReEdit(false);
		updatedArticle.setInReview(false);
		updatedArticle.setPublished(true);
		updatedArticle.setHeadlines(headlines);
		updatedArticle.setTimeOfPublish(LocalDate.now());
		repo.saveAndFlush(updatedArticle);

	}

	@Override
	public Articles newArticle(String category, String title) {

		Category newCategory = new Category();
		Articles newArticle = new Articles();

		if (catRepo.findByNameIgnoreCase(category).isPresent()) {

			newCategory = catRepo.findByNameIgnoreCase(category).get();

		} else {
			newCategory.setName(category);
		}

		newArticle.setTitle(title);
		newArticle.setCategory(newCategory);
		return newArticle;

	}

	@Override
	public List<Articles> getArticlesByUserSubscriptions(EndUser subscriber) {
		List<Category> subscriptions = subscriber.getSubscriptions();
		List<Articles> subbedArticles = new ArrayList<Articles>();

		for (Category category : subscriptions) {
			subbedArticles.addAll(repo.findByCategory(category));

		}

		subbedArticles = subbedArticles.stream().filter(s -> s.isPublished() == true && s.getTimeOfPublish() != null
				&& s.getTimeOfPublish().equals(LocalDate.now())).collect(Collectors.toList());
		return subbedArticles;
	}

	@Override
	public List<Articles> findByTimeOfPublish(LocalDate date) {

		return repo.findByTimeOfPublish(date);
	}

	@Override
	public void deleteArticle(int articleId) {
		repo.deleteById(articleId);
		
	}

}
