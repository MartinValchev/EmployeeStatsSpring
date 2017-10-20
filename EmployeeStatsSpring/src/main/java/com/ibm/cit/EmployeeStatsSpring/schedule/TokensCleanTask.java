package com.ibm.cit.EmployeeStatsSpring.schedule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.cit.EmployeeStatsSpring.dao.LoginDao;
import com.ibm.cit.EmployeeStatsSpring.model.LoginToken;


@Transactional
public class TokensCleanTask  {

	@Autowired
	@Qualifier(value = "loginDao")
	private LoginDao loginDao;

	
	public void cleanTokens() {

		List<LoginToken> deleteList = getAllDeleteTokens();
		if (deleteList.size() > 0) {
			loginDao.deleteLoginToken(deleteList);
		}

	}
	
	
	@Transactional(readOnly=true)
	public List<LoginToken> getAllDeleteTokens() {
		List<LoginToken> loginTokens = loginDao.getAllLoginTokens();
		StringBuilder deletedTokensString = new StringBuilder();
		List<LoginToken> deleteList = new ArrayList<LoginToken>();
		for (LoginToken token : loginTokens) {
			Date expirationDate = token.getExpirationDate();
			Date currentDate = new Date();
			if (expirationDate.before(currentDate)) {
				deletedTokensString.append("Deleted token id: " + token.getLoginTokenId() + ", tokenHash"
						+ token.getHashToken() + System.getProperty("line.separator"));
				//Logger log = Logger.getLogger(TokenCleanJob.class);
				//log.info(deletedTokensString.toString());
				deleteList.add(token);
			}

		}
		return deleteList;
	}
}
