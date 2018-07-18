package com.learn.demo.mybatisspring.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class MyBatisConfig {

	@Bean
	public DataSource datasouce() {

		MultiTenantDataSource mtDataSource = new MultiTenantDataSource();

		DataSource h2DS = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScript("classpath:database-schema.sql").build();

		DataSource pgDS = new UnpooledDataSource("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/cfdb",
				"cfuser", "cfpassword");

		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put(0, h2DS);
		targetDataSources.put(1, pgDS);
		mtDataSource.setTargetDataSources(targetDataSources);

		return mtDataSource;
		// return h2DS;
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

	@Bean
	public MapperScannerConfigurer MapperScannerConfigurer() {
		MapperScannerConfigurer config = new MapperScannerConfigurer();
		config.setBasePackage("com.learn.demo.mybatisspring.mapper");

		return config;
	}

}
