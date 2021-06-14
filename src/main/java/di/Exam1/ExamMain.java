package di.Exam1;
  // step4 까지 spring을 사용하지 않고 DI생성.

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ExamMain {
	ApplicationContext ac = new FileSystemXmlApplicationContext("src/main/java/di/Exam1/member.xml");  // 처음 클래스를 받아올때 생성자에 내용 사용됨.
	Object o = new Object(); 
	member mb;
	
	public ExamMain() {
		
		
	}
	
	
	public void RegisterMember() {
	mb= (member) ac.getBean("RegisterMember");  
	mb.select(o);
    mb.insert(o);
    mb.update(o);
    mb.delete(o);
	}
	
	public void GuestMember() {
	mb = (member) ac.getBean("GuestMember");
	/*
	 * member mb2 = ac.getBean("GuestMember", GuestMember.class); // 둘다 동일한 방법
	 */	
	mb.select(o);
    mb.insert(o);
    mb.update(o);
    mb.delete(o);
	}
	
	
	public static void main(String[] args) {
		ExamMain ex = new ExamMain();
		
		ex.GuestMember();
		ex.RegisterMember();
}

}
