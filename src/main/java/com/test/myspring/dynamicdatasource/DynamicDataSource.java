package com.test.myspring.dynamicdatasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
	//返回字符串，与key一致
	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return HandlerDataSource.getDataSource();
	}

}
