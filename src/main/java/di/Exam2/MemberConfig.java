package di.Exam2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// exam1 에 있는 member.xml 파일 대신 java 파일로 사용가능 이기능을 대체로 많이 사용함.
@Configuration
public class MemberConfig {

	@Bean
	public Member rMember() {  // 메서드 이름이 xml 파일에서 id 역활을 한다.
		return new RegisterMember();
	}
	
	@Bean
	public Member gMember() {
		return new GuestMember();
		
	}
}
