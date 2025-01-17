package soloproject.rakshith.newspaper.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class EndUser {
	@Id
	@GeneratedValue
	@Column(name = "EndUser_ID")
	private Integer id;
	
	private String username;
	
	private String password;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Role role;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	List<Category> subscriptions;

	public EndUser() {
		super();
	}

	public EndUser(String username, String password, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	

	public List<Category> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<Category> subscriptions) {
		this.subscriptions = subscriptions;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, role, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EndUser other = (EndUser) obj;
		return Objects.equals(password, other.password) && Objects.equals(role, other.role)
				&& Objects.equals(username, other.username);
	}
}
