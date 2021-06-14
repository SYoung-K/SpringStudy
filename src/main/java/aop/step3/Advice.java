package aop.step3;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

// 횡단적 관심사가 분리된 코드
public class Advice implements MethodInterceptor{
	@Autowired
	Mysql db;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd(E)hh:mm:ss:SS");
		
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		beforeLog();
		invocation.proceed(); // DB.run() 을 실행하게함.
		afterLog();
		
		Object o = invocation.proceed();
		return o;
	}
	
	
	
	// before advice type
	public void beforeLog() {
		
		System.out.println("log : "+ sdf.format(new Date()));
	}
	
	// after advice type
	public void afterLog() {
		System.out.println("log : "+ sdf.format(new Date()));
	}
	
}
