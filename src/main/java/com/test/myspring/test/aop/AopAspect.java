package com.test.myspring.test.aop;

import java.lang.reflect.Modifier;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class AopAspect {
	@Pointcut("execution(* com.test.myspring.test.*.*(..))")
	public void declareJoinPointerExpression() {
	}

	@Before("declareJoinPointerExpression()")
	public void beforeMethod(JoinPoint joinPoint) {
		System.out.println("目标方法名为:" + joinPoint.getSignature().getName());
		System.out.println("目标方法所属类的简单类名:" + joinPoint.getSignature().getDeclaringType().getSimpleName());
		System.out.println("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
		System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
		System.out.println("目标方法tt:" + joinPoint.getTarget().getClass().getInterfaces());
		// 获取传入目标方法的参数
		Object[] args = joinPoint.getArgs();
		for (int i = 0; i < args.length; i++) {
			System.out.println("第" + (i + 1) + "个参数为:" + args[i]);
		}
		System.out.println("被代理的对象:" + joinPoint.getTarget());
		System.out.println("代理对象自己:" + joinPoint.getThis());
	}

	@Around("declareJoinPointerExpression()")
	public Object aroundMethod(ProceedingJoinPoint pjd) {
		Object result = null;

		try {
			// 前置通知
			System.out.println("目标方法执行前...");
			// 执行目标方法
			// result = pjd.proeed();
			// 用新的参数值执行目标方法
			result = pjd.proceed(new Object[] { "newSpring", "newAop" });
			// 返回通知
			System.out.println("目标方法返回结果后...");
		} catch (Throwable e) {
			// 异常通知
			System.out.println("执行目标方法异常后...");
			throw new RuntimeException(e);
		}
		// 后置通知
		System.out.println("目标方法执行后...");

		return result;
	}
}
