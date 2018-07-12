package com.learn.demo.mybatisspring.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
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

	@Bean
	public SqlSessionFactoryBean getSqlSessionFactory(DataSource datasouce) throws IOException {

		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(datasouce);

		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setMapperLocations(resolver.getResources("classpath:**/*Mapper.xml"));
		return bean;

	}

	@Bean
	public MapperScannerConfigurer MapperScannerConfigurer() {
		MapperScannerConfigurer config = new MapperScannerConfigurer();
		config.setBasePackage("com.learn.demo.mybatisspring.mapper");

		return config;
	}

}
