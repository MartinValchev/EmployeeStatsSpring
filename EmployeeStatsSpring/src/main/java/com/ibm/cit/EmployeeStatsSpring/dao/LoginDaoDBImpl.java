package com.ibm.cit.EmployeeStatsSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.cit.EmployeeStatsSpring.model.Login;
import com.ibm.cit.EmployeeStatsSpring.model.LoginToken;

@Repository("loginDao")
@Transactional
public class LoginDaoDBImpl implements LoginDao {

	@PersistenceContext
	EntityManager entityManager;

	public Login getUser(String userName, String password) {
		Login user = null;
		Query query = entityManager.createNamedQuery("Login.getLogin", Login.class);
		query.setParameter("username", userName);
		query.setParameter("password", password);
		user = (Login) query.getResultList().get(0);
		return user;
	}

	public Login addUser(Login user) {
		entityManager.persist(user);
		entityManager.flush();
		//em.flush();
		Login newLogin= user;
//		int id = user.getLoginId();
//		newLogin.setLoginId(id);
		return newLogin;
	}

	public LoginToken getLoginToken(String token) {
		Query tokenQuery = null;
		if (token.length() == 0) {
			/*tokenQuery = entityManager.createQuery("Select Select e.loginTokenId,e.hashToken,e.expirationDate from LoginToken e order by expiration_date desc");
			tokenQuery.setMaxResults(1);*/
		} else {
			tokenQuery = entityManager.createNamedQuery("Token.getLoginToken",LoginToken.class);		
			tokenQuery.setParameter("hashToken", token);
		}
		/*Object[] loginTokenObj = (Object[]) tokenQuery.getResultList().get(0);
		LoginToken loginToken = new LoginToken();
		loginToken.setLoginTokenId(Integer.parseInt((loginTokenObj[0]).toString()));
		loginToken.setHashToken((loginTokenObj[1]).toString());
		Date expirationDate=  (Timestamp)loginTokenObj[2];
		loginToken.setExpirationDate(expirationDate);*/
		LoginToken loginToken = (LoginToken) tokenQuery.getResultList().get(0);
		return loginToken;
	}

	private void addLogging(String message) {
		Logger log = Logger.getLogger(EmployeeDaoDBImpl.class);
		log.error(message);
	}

	public int getUserId(String username) {
		Query query = entityManager.createNamedQuery("Login.getId", Long.class);
		query.setParameter("username", username);
		int userId = ((Long) query.getResultList().get(0)).intValue();
		return userId;

	}

	public void addLoginToken(LoginToken loginToken, Login login) {
			loginToken.setLogin(login);
			entityManager.persist(loginToken);
	}

	public void deleteLoginToken(List<LoginToken> tokens) {
			
			for (LoginToken token : tokens) {
				entityManager.remove(token);
			}
			entityManager.flush();
	}

	@SuppressWarnings("unchecked")
	public List<LoginToken> getAllLoginTokens() {
		List<LoginToken> results = null;
		Query allTokensQuery = entityManager.createNamedQuery("Token.allLoginTokens",LoginToken.class);
		results = allTokensQuery.getResultList();
		return results;
	}

}
