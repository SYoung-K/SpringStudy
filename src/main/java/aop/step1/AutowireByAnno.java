package aop.step1;

import org.springframework.beans.factory.annotation.Autowired;

// 동일한 유형의 빈을 자동 주입
// 업무용으로 실행되는 코드
// 세터 게터 둘다 필요없음
public class AutowireByAnno{
	@Autowired
	Oracle sql;
	
	public void output() {
		sql.run();
	}
		
	
}
