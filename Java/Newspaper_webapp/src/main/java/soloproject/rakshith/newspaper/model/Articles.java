package soloproject.rakshith.newspaper.model;


import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Articles {
	
	@Id
	@GeneratedValue
	@Column(name = "ARTICLE_ID")
	private Integer id;
	
	@Column(length = 5000)
	private String article;
	
	private String title;
	private boolean inReview, reEdit, published, headlines;
	private LocalDate timeOfPublish;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private EndUser contributor, editor;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Category category;

	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isInReview() {
		return inReview;
	}

	public void setInReview(boolean inReview) {
		this.inReview = inReview;
	}

	public boolean isReEdit() {
		return reEdit;
	}

	public void setReEdit(boolean reEdit) {
		this.reEdit = reEdit;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public boolean isHeadlines() {
		return headlines;
	}

	public void setHeadlines(boolean headlines) {
		this.headlines = headlines;
	}

	public LocalDate getTimeOfPublish() {
		return timeOfPublish;
	}

	public void setTimeOfPublish(LocalDate timeOfPublish) {
		this.timeOfPublish = timeOfPublish;
	}

	public EndUser getContributor() {
		return contributor;
	}

	public void setContributor(EndUser contributor) {
		this.contributor = contributor;
	}

	public EndUser getEditor() {
		return editor;
	}

	public void setEditor(EndUser editor) {
		this.editor = editor;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	

	
	

}
