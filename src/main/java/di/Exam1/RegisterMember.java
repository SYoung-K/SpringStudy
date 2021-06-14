package di.Exam1;

import java.util.List;

public class RegisterMember implements member{

	
	public RegisterMember() {
		System.out.println("RegisterMember 생성");
	}
	
	@Override
	public List<Object> select(Object o) {
		// TODO Auto-generated method stub
		System.out.println("RegisterMember select");
		return null;
	}
	
	@Override
	public int insert(Object o) {
		// TODO Auto-generated method stub
		System.out.println("RegisterMember insert");
		return 0;
	}
	
	@Override
	public int update(Object o) {
		// TODO Auto-generated method stub
		System.out.println("RegisterMember update");
		return 0;
	}

	@Override
	public int delete(Object o) {
		// TODO Auto-generated method stub
		System.out.println("RegisterMember delete");
		return 0;
	}


}
