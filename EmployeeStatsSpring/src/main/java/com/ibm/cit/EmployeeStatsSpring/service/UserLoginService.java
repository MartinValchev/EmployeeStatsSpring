package com.ibm.cit.EmployeeStatsSpring.service;

import java.util.Date;
import java.util.List;

import com.ibm.cit.EmployeeStatsSpring.model.Login;
import com.ibm.cit.EmployeeStatsSpring.model.LoginToken;


public interface UserLoginService {
	public String isLoginSuccessful(Login user);

	public Login addUser(Login user);

	public boolean isLoginValid(String tokenValue);

	public void addLoginToken(String token, Date expirationDate, Login login);

	public String generateTokenString();

	public int getUserId(String username);

	public String generateMD5Hash(String password);

	public LoginToken getLoginToken(String token);
	
	public void deleteLoginToken(String tokenString);
	
	public List<LoginToken> getAllLoginTokens();
	
	public Login getLogin(String userName, String password);

}
