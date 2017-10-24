package com.ibm.cit.EmployeeStatsSpring.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component("contextLoader")
public class ApplicationContextProvider implements ApplicationContextAware {
	private static ApplicationContext instance;
	
	public ApplicationContext getApplicationContext() {
		return instance;
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
			instance =applicationContext;
		
	}
}
