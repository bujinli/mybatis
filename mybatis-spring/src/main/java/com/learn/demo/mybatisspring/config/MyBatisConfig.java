package com.learn.demo.mybatisspring.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
// public class MyBatisConfig implements InitializingBean {
// public class MyBatisConfig extends AbstractCloudConfig {
//@Service
@Configuration
public class MyBatisConfig {
	// @Value("${vcap.services.jeff-hana.credentials.url}")
	// private String url;
	// @Value("${vcap.services.jeff-hana.credentials.user}")
	// private String user;
	// @Value("${vcap.services.jeff-hana.credentials.password}")
	// private String password;
	// @Value("${vcap.services.jeff-hana.credentials.schema}")
	// private String schema;
	// @Value("${vcap.services.jeff-hana.credentials.host}")
	// private String host;
	// @Value("${vcap.services.jeff-hana.credentials.port}")
	// private String port;
	// @Value("${vcap.services.jeff-hana.credentials.driver}")
	// private String driver;
	//
	// @Value("tess")
	// private String test;

	// private ValueTest vt;

//	public MyBatisConfig(ValueTest valueTest) {
//		this.vt = valueTest;
//	}

	public MyBatisConfig() {
	}
	
//	@Autowired
//	public void setValueTest(ValueTest valueTest) {
//		this.vt = valueTest;
//	}

	// @Bean
	// public DataSource datasouce() {
	// //
	// // MultiTenantDataSource mtDataSource = new MultiTenantDataSource();
	// //
	// this.vt.getClass();
	// System.out.println("==============" + this.vt);
	// return new
	// EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
	// }

	// public DataSource
	// datasouce(@Value("${vcap.services.jeff-hana.credentials.driver}") String
	// adriver) {
	// @Bean
	// public DataSource datasouce() {
	// //
	// // MultiTenantDataSource mtDataSource = new MultiTenantDataSource();
	// //
	// DataSource h2DS = new
	// EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
	// .addScript("classpath:database-schema.sql").build();
	//// this.valueTest.getClass();
	//
	//// valueTest1.getHide();
	//
	// //
	// // DataSource pgDS = new UnpooledDataSource("org.postgresql.Driver",
	// // "jdbc:postgresql://localhost:5432/cfdb",
	// // "cfuser", "cfpassword");
	// //
	// // Map<Object, Object> targetDataSources = new HashMap<>();
	// // targetDataSources.put(0, h2DS);
	// // targetDataSources.put(1, pgDS);
	// // mtDataSource.setTargetDataSources(targetDataSources);
	// //
	// // return mtDataSource;
	//
	// // return connectionFactory().dataSource();
	// return h2DS;
	// // String url =
	// //
	// "jdbc:sap://zeus.hana.validation.eu-central-1.whitney.dbaas.ondemand.com:22463?encrypt=true\u0026validateCertificate=true\u0026currentschema=383DB2E2E0EF4774B15A085A1D2EB2C5";
	// // String user =
	// // "383DB2E2E0EF4774B15A085A1D2EB2C5_43BUYH44LICS0NY4ZI0VTJ8C1_RT";
	// // String password =
	// //
	// "Cr5oKaZfr_QgqAPuOl4zkQsPgr04J4GMVE-N_cQg4FJ7j_dXjOPumOfAnEQnFIrFNPTO-lByIAU5h_9RuuWx_wtEhLFl-rduTNVpFtUGpfzXGBtxNslvX66m_9LRc9br";
	// // return connectionFactory().dataSource();
	// // String realUrl = url.replace("\u0026", "&");
	// // System.out.println("url " + url);
	// // System.out.println("user " + user);
	// // System.out.println("password " + password);
	// //
	// // return
	// //
	// DataSourceBuilder.create().driverClassName("com.sap.db.jdbc.Driver").url(realUrl).username(user)
	// // .password(password).build();
	//
	// // return
	// // DataSourceBuilder.create().driverClassName(driver).url(realUrl)
	// // .username(user +
	// //
	// "&ENCRYPT=true&sslValidateCertificate=false").password(password).build();
	// }

	// @Bean
	// public SqlSessionFactoryBean getSqlSessionFactory(DataSource datasouce)
	// throws IOException {
	//
	// SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
	// bean.setDataSource(datasouce);
	//
	// PathMatchingResourcePatternResolver resolver = new
	// PathMatchingResourcePatternResolver();
	// bean.setMapperLocations(resolver.getResources("classpath:**/*Mapper.xml"));
	// return bean;
	// }
	//
	// @Bean
	// public DataSourceTransactionManager
	// getTranscationMangerDataSource(DataSource datasouce) {
	// DataSourceTransactionManager tm = new
	// DataSourceTransactionManager(datasouce);
	// return tm;
	// }

	@Bean
	public MapperScannerConfigurer MapperScannerConfigurer() {
		MapperScannerConfigurer config = new MapperScannerConfigurer();
		config.setBasePackage("com.learn.demo.mybatisspring.mapper");

		return config;
	}

}
