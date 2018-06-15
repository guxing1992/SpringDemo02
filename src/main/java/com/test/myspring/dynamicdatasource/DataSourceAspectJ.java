package com.test.myspring.dynamicdatasource;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;

import com.test.myspring.annotation.TargetDataSorce;
/**
 * 对我们的服务层的方法进行代理
 * 当前用户访问的线程与我们的数据源建立关系
 * @author Zhang
 *
 */
@Aspect
@Order(-1)
public class DataSourceAspectJ {
	@Before("execution(* com.test.myspring.service..*.*(..))")
	public void before(JoinPoint joinPoint) {
		System.out.println("在service执行之前拦截进行方法增强");
		Object target = joinPoint.getTarget();
		String targetMethodName=joinPoint.getSignature().getName();
		Class<?>[] interfaceszz = target.getClass().getInterfaces();
		System.out.println("targetMethodName:"+targetMethodName);
		Class<?>[] parameterTypezz = ((MethodSignature)joinPoint.getSignature()).getMethod().getParameterTypes();
		for(Class<?> interfacezz:interfaceszz) {
			try {
				Method intfMethod = interfacezz.getMethod(targetMethodName, parameterTypezz);
				if (intfMethod!=null) {
					if (intfMethod.isAnnotationPresent(TargetDataSorce.class)) {
						TargetDataSorce targetDataSorce = intfMethod.getAnnotation(TargetDataSorce.class);
						String value = targetDataSorce.value();
						//建立当前线程与数据源字符串的映射关系
						HandlerDataSource.putDataSource(value);
					}else {
						HandlerDataSource.putDataSource("read");
					}
				}else {
					continue;
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
