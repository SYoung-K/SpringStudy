package di.board;
  // step4 까지 spring을 사용하지 않고 DI생성.

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
	BoardService BS;
	
	public Main() {
		ApplicationContext ca = new FileSystemXmlApplicationContext("src/main/java/di/board/config.xml");
		
		BS = (BoardService) ca.getBean("BT");
		
		BS.output();
	}

	
	public static void main(String[] args) {
		Object o = null;
		
		Main m = new Main();
}

}
