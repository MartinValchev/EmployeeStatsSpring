package com.ibm.cit.EmployeeStatsSpring.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "login")
@NamedQueries({
		@NamedQuery(name = "Login.getLogin", query = "Select e from Login e where e.username =:username AND e.password =:password"),
		@NamedQuery(name = "Login.getId", query = "Select e.id from Login e where e.username =:username") })
public class Login implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -868715818388442151L;
	private int loginId;
	private String username;
	private String password;
	private Set<LoginToken> loginTokens = new HashSet<LoginToken>(0);

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "login_id")
	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int id) {
		this.loginId = id;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(mappedBy = "login",fetch = FetchType.EAGER,orphanRemoval=true )
	public Set<LoginToken> getLoginTokens() {
		return this.loginTokens;
	}

	public void setLoginTokens(Set<LoginToken> loginTokens) {
		this.loginTokens = loginTokens;
	}

}
