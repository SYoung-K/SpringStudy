package di.anno;

import org.springframework.beans.factory.annotation.Autowired;

// 동일한 유형의 빈을 자동 주입
// 업무용으로 실행되는 코드
public class AutowireByAnno{
	Mysql sql;
	
	public void output() {
		sql.run();
	}

	public Mysql getSql() {  // 게터는 안만들어도 상관 없음.
		return sql;
	}
	
	@Autowired  // 자동으로 등록되게 해줌.
	public void setSql(Mysql sql) {
		this.sql = sql;
	}

		
	
}
