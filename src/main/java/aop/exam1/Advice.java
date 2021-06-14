package aop.exam1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;

// 횡단적 관심사가 분리된 코드
public class Advice implements MethodInterceptor {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd(E)hh:mm:ss:SS");

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println("Class : "+invocation.getThis().getClass().getSimpleName());
		System.out.println("Method : "+invocation.getMethod().getName());
		beforeLog();		
		Object o = invocation.proceed();
		
		return o;
	}
	
	
	public void beforeLog() {
		
		System.out.println("log :"+sdf.format(new Date()));
	}
	
}
