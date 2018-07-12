package com.learn.demo.mybatisspring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class MyBatisConfig {

	@Bean
	public DataSource datasouce() {

		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				// .addScript("classpath:database-schema.sql")
				.addScript("classpath:database-schema.sql").build();
	}

}
