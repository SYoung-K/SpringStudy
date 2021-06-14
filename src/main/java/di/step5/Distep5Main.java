package di.step5;
  // step4 까지 spring을 사용하지 않고 DI생성.

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Distep5Main {
	
	public Distep5Main() {
		ApplicationContext ac = new FileSystemXmlApplicationContext("src/main/java/di/step5/Assembler.xml");
		
		DB db = (DB) ac.getBean("db");
		db.run();
	}

	
	public static void main(String[] args) {
		new Distep5Main();
}

}
