package di.step3;

public class Mysql implements DB{
	public Mysql() {
		System.out.println("Mysql database가 실행됨.");
	}

	@Override
	public void run() {
		System.out.println("Mysql에서 회원정보를 추가함");
		// TODO Auto-generated method stub
		
	}
}
