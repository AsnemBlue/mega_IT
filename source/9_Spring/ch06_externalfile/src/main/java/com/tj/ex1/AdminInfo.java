package com.tj.ex1;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
public class AdminInfo implements EnvironmentAware, InitializingBean{
	private String adminId;
	private String adminPw;
	private Environment env;
	@Override
	public void setEnvironment(Environment environment) {
		env = environment;		
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		adminId = env.getProperty("admin.id");
		adminPw = env.getProperty("admin.pw");
	}
	public String getAdminId() {return adminId;}
	public String getAdminPw() {return adminPw;}
}










