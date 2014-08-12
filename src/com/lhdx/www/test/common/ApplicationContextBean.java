package com.lhdx.www.test.common;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lhdx.www.server.dao.ReportDao;


public class ApplicationContextBean {
private static ApplicationContext context = null;
private static final String CONFIG = "config/spring.xml";
@Resource(name="reportDao")
private static ReportDao reportDao;
static {
	context = new ClassPathXmlApplicationContext(CONFIG);
}
public static void main(String[]args){
	System.out.println(reportDao.selectReports());
}
}
