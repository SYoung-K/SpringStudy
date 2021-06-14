package aop.step1;
  // step4 까지 spring을 사용하지 않고 DI생성.

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
	
	public Main() {
		ApplicationContext ac = new FileSystemXmlApplicationContext("src/main/java/aop/step1/Assembler.xml");

		AutowireByAnno aba = ac.getBean("byAnno", AutowireByAnno.class);
		
		aba.output();
	}

	
	public static void main(String[] args) {
		new Main();
}

}
