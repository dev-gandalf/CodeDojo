package soloproject.rakshith.newspaper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
	@GeneratedValue
	@Column(name="CATEGORY_ID")
	private Integer id;
	
	private String name;
	
	public Category(){
		super();
	}




	public Category(String name) {
		super();
		this.name = name;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
