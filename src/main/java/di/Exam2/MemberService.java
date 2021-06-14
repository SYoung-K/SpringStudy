package di.Exam2;
  // step4 까지 spring을 사용하지 않고 DI생성.

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MemberService {
	/* 기본 member.xml 파일을 사용하여 빈을 가져오는 방법
	 * 
	 * ApplicationContext ac = new
	 * FileSystemXmlApplicationContext("src/main/java/di/Exam1/member.xml"); // 처음
	 * 클래스를 받아올때 생성자에 내용 사용됨. Object o = new Object(); Member mb;
	 */
	
	ApplicationContext ac = new AnnotationConfigApplicationContext(MemberConfig.class);
	
	Member rM = (RegisterMember) ac.getBean("rMember");
	Member gM = ac.getBean("gMember", GuestMember.class);
	
	public static void main(String[] args) {
		Object o = null;
		MemberService ex = new MemberService();
		
		ex.rM.insert(o);
		
}

}
