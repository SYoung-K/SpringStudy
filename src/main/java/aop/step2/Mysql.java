package aop.step2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Mysql implements DB{
	
	public Mysql() {
		System.out.println("Mysql database가 실행됨.");
	}

	@Override
	public void run() {
		
		System.out.println("Mysql에서 회원정보가 검색됨");
		// TODO Auto-generated method stub
		
	}
}
