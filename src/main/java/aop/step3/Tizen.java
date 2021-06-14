package aop.step3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tizen implements DB{
	
	public Tizen() {
		System.out.println("Tizen database가 실행됨.");
	}
	
	@Override
	public void run() {
		
		System.out.println("Tizen에서 회원정보를 추가함");
		// TODO Auto-generated method stub
		
	}
}

