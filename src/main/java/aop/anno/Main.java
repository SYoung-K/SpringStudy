package aop.anno;
  // step4 까지 spring을 사용하지 않고 DI생성.

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
	
	public Main() {
		ApplicationContext ac = new FileSystemXmlApplicationContext("src/main/java/aop/anno/Assembler.xml");
		
		Dao dao = ac.getBean("bd", Dao.class);
		
		System.out.println("-------------------");
		dao.select();
		System.out.println("-------------------");
		dao.insert();
		System.out.println("-------------------");
		dao.update();
		System.out.println("-------------------");
		dao.delete();
		System.out.println("-------------------");
		
	}

	
	public static void main(String[] args) {
		new Main();
}

}
