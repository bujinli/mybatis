package com.learn.demo.mybatisspring.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class ConfigurationTest {

//	private ValueTest valueTest;

	public ConfigurationTest() {
	}

//	@Autowired
//	public void setValueTest(ValueTest valueTest) {
//		this.valueTest = valueTest;
//	}

	// @Autowired
	// public ConfigurationTest(ValueTest valueTest) {
	// this.valueTest = valueTest;
	// }

	@Bean
	public DataSource datasouce() {
		//
		// MultiTenantDataSource mtDataSource = new MultiTenantDataSource();
		//
//		this.valueTest.getClass();
//		System.out.println("==============" + this.valueTest);
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
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
	public DataSourceTransactionManager getTranscationMangerDataSource(DataSource datasouce) {
		DataSourceTransactionManager tm = new DataSourceTransactionManager(datasouce);
		return tm;
	}

	// @Bean
	// public MapperScannerConfigurer mapperScannerConfigurer() {
	// MapperScannerConfigurer config = new MapperScannerConfigurer();
	// config.setBasePackage("com.learn.demo.mybatisspring.mapper");
	// return config;
	// }

}
