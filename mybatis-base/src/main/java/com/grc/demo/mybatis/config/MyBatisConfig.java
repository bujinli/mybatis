package com.grc.demo.mybatis.config;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class MyBatisConfig {

	@Bean
	public DataSource dataSource() {
		// System.out.println(MyBatisConfig.class.getClassLoader()
		// .getResource("com/grc/demo/mybatis/db/database-schema.sql").toString());

		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				// .addScript("classpath:database-schema.sql")
				.addScript("classpath:database-schema.sql").build();
	}

	// @Bean
	// public PlatformTransactionManager transactionalManager() {
	// return new DataSourceTransactionManager(dataSource());
	// }

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource());
		org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration(environment);

		config.addMappers("com.grc.demo.mybatis.mapper");
		// config.addMappers("mapper");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
		return ssf;
	}

}
