package com.learn.demo.mybatisspring.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultiTenantDataSource extends AbstractRoutingDataSource {

	private static int i = -1;

	@Override
	protected Object determineCurrentLookupKey() {

		++i;
		return i % 2;
	}

}
