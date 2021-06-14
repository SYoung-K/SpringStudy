package di.anno;
  // step4 까지 spring을 사용하지 않고 DI생성.

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
	
	public Main() {
		ApplicationContext ac = new FileSystemXmlApplicationContext("src/main/java/di/anno/Assembler.xml");
		
		/*
		 * AutowireByName abn = ac.getBean("byName", AutowireByName.class); // byname으로
		 * 주입
		 * 
		 * abn.output();
		 */

		AutowireByType abt = ac.getBean("byType", AutowireByType.class);  // byname으로 주입
		
		abt.output();
		
		AutowireByAnno aba = ac.getBean("byAnno", AutowireByAnno.class);
		
		aba.output();
	}

	
	public static void main(String[] args) {
		new Main();
}

}
