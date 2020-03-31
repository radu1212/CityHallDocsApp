package entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@Column(name = "UUID", unique = true)
	private String id;

	@Column(name = "username", unique = true, nullable = false)
	private String username;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "role", nullable = false)
	private Boolean role; // if role == true then admin, else user

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany( mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<Address> addresses = new ArrayList<>();

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany( mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<Request> requests = new ArrayList<>();

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = Boolean.FALSE;
	}

	public User(String username, String email, String password, Boolean role) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public User(String username) {
		this.username = username;
	}
	
	public User() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getRole() {
		return role;
	}

	public void setRole(Boolean role) {
		this.role = role;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
}
