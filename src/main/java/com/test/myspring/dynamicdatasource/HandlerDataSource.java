package com.test.myspring.dynamicdatasource;
/**
 * 用户的请求和我们的数据源进行一一绑定
 * @author Zhang
 *
 */
public class HandlerDataSource {
	public static final ThreadLocal<String> holder=new ThreadLocal<String>();
	public static void putDataSource(String dataSource) {
		System.out.println("dataSource:"+dataSource);
		holder.set(dataSource);
	}
	public static String getDataSource() {
		return holder.get();
	}
}
