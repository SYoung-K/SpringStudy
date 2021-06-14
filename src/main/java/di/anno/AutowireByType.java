package di.anno;

// 동일한 유형의 빈을 주입
// 업무용으로 실행되는 코드
public class AutowireByType{
	Oracle tizen;
	
	public void output() {
		tizen.run();
	}

	
	public Oracle getTizen() {
		return tizen;
	}

	public void setTizen(Oracle tizen) {
		this.tizen = tizen;
	}
	
	
}
