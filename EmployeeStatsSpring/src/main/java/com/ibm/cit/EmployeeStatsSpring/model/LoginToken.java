package com.ibm.cit.EmployeeStatsSpring.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "logintoken")
@NamedQueries({
		@NamedQuery(name = "Token.getLoginToken", query = "SELECT s FROM LoginToken s WHERE s.hashToken=:hashToken"),
		@NamedQuery(name = "Token.allLoginTokens", query = "Select e from LoginToken e"), })
public class LoginToken implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -798429852436638262L;
	private int loginTokenId;
	private String hashToken;
	private Date expirationDate;
	private Login login;

	@Column(name = "hash_token")
	public String getHashToken() {
		return hashToken;
	}

	public void setHashToken(String token) {
		this.hashToken = token;
	}

	@Column(name = "expiration_date")
	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "login_token_id")
	public int getLoginTokenId() {
		return loginTokenId;
	}

	public void setLoginTokenId(int id) {
		this.loginTokenId = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "login_id")
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}
