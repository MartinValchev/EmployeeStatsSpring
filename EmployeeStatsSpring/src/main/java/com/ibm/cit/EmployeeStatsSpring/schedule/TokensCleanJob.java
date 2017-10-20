package com.ibm.cit.EmployeeStatsSpring.schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TokensCleanJob extends QuartzJobBean{
	
	TokensCleanTask tokensCleanTask;

	public void setTokensCleanTask(TokensCleanTask tokensCleanTask) {
		this.tokensCleanTask = tokensCleanTask;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		tokensCleanTask.cleanTokens();
		
	}

}
