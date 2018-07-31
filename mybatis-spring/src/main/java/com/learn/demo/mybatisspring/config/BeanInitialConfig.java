package com.learn.demo.mybatisspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInitialConfig {

	@Autowired
	private ValueTest valueTest;
	

	public BeanInitialConfig() {
	}

	@Bean
	public TestSpringBean springBean() {
		return new TestSpringBean();
	}

	@Bean
	public CreateBean create() {

		this.valueTest.getClass(); // here we go
		return new CreateBean();
	}

}
