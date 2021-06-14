package di.step4;

public class Oracle implements DB{
	public Oracle() {
		System.out.println("oracle database가 실행됨.");
	}

	@Override
	public void run() {
		System.out.println("오라클에서 회원정보가 검색됨");
		// TODO Auto-generated method stub
		
	}
	
}


