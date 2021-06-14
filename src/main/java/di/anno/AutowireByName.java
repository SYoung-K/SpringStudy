package di.anno;

// 동일한 이름을 갖고 있는 빈을 주입
// 업무용으로 실행되는 코드
public class AutowireByName{
	Oracle ti;
	
	public void output() {
		ti.run();
	}

	public Oracle getOr() {
		return ti;
	}

	public void setOr(Oracle ti) {
		this.ti = ti;
	}
	
	
}
