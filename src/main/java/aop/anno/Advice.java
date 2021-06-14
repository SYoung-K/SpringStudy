package aop.anno;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

// 횡단적 관심사가 분리된 코드
@Aspect
public class Advice {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd(E)hh:mm:ss:SS");

	
	@Before("execution(* insert(..))|| execution(* update(..))") // 지점 설정
	public Object before(JoinPoint point){
		
		System.out.println("log :"+sdf.format(new Date()));
			
	
		
		return null;
	}
	
	@Around("execution(* delete(..))")
	public Object around(ProceedingJoinPoint point) {
		Object o = null;
		System.out.println("log :"+sdf.format(new Date()));
		try {
		o=	point.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("log :"+sdf.format(new Date()));
		
		return o;
	}
	
	
}
