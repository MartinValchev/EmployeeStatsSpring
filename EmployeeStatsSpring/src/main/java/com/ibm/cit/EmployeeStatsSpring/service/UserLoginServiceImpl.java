package com.ibm.cit.EmployeeStatsSpring.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.cit.EmployeeStatsSpring.dao.LoginDao;
import com.ibm.cit.EmployeeStatsSpring.model.Login;
import com.ibm.cit.EmployeeStatsSpring.model.LoginToken;


@Service(value="loginService")
@Transactional
public class UserLoginServiceImpl implements UserLoginService {
	
	@Autowired
	@Qualifier("loginDao")
	LoginDao loginDao;
	
	public String isLoginSuccessful(Login user) {
//		String isLoginSuccessful = "false";
//		String inputUsername = user.getUsername();
//		Login dbUser =null;
//		dbUser = loginDao.getUser(inputUsername, user.getPassword());
//	
//		if (dbUser != null) {
//			isLoginSuccessful = "true";
//		}
		return null;
	}

	public Login addUser(Login user) {
		return loginDao.addUser(user);
	}

	public void addLoginToken(String token, Date expirationDate,Login login) {
		LoginToken loginToken=  new LoginToken();
		loginToken.setExpirationDate(expirationDate);
		loginToken.setHashToken(token);
		loginDao.addLoginToken(loginToken,login);
	}
	
	public String generateMD5Hash(String password) {
		MessageDigest m =null;
		String hashtext ="";
		try {
			m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(password.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1,digest);
			hashtext = bigInt.toString(16);
			while(hashtext.length() < 32 ){
			  hashtext = "0"+hashtext;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hashtext;
	
	};

	public String generateTokenString() {		
		
		return UUID.randomUUID().toString();
	}

	public int getUserId(String username) {
		int userID = loginDao.getUserId(username);
		return userID;
	}

	public boolean isLoginValid(String tokenValue) {
		boolean isTokenValid = false;
		LoginToken loginToken = loginDao.getLoginToken(tokenValue);	
		if(loginToken !=null) {
			Date currentDate = new Date();
			Date tokenExpireDate =loginToken.getExpirationDate();
			if(tokenExpireDate.after(currentDate)) {
				isTokenValid =true;
			}else {
				List<LoginToken> loginTokens = new ArrayList<LoginToken>();
				loginTokens.add(loginToken);
				loginDao.deleteLoginToken(loginTokens);
			} 
			
		}
		return isTokenValid;
	}

	public LoginToken getLoginToken(String token) {
		LoginToken loginToken = loginDao.getLoginToken(token);
		return loginToken;	
	}

	public void deleteLoginToken(String tokenValue) {
		LoginToken loginToken = loginDao.getLoginToken(tokenValue);	
		List<LoginToken> loginTokens = new ArrayList<LoginToken>();
		loginTokens.add(loginToken);
		loginDao.deleteLoginToken(loginTokens);
		
	}

	@Override
	public List<LoginToken> getAllLoginTokens() {
		
		return loginDao.getAllLoginTokens();
	}

	@Override
	public Login getLogin(String userName, String password) {
		
		return loginDao.getUser(userName, password);
	}


}
