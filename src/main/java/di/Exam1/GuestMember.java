package di.Exam1;

import java.util.List;

public class GuestMember implements member {
	
	public GuestMember() {
		System.out.println("GuestMember 생성");
	}
	
	@Override
	public List<Object> select(Object o) {
		// TODO Auto-generated method stub
		System.out.println("GuestMember select");
		return null;
	}

	
	@Override
	public int insert(Object o) {
		// TODO Auto-generated method stub
		System.out.println("GuestMember insert");
		return 0;
	}
	
	@Override
	public int update(Object o) {
		// TODO Auto-generated method stub
		System.out.println("GuestMember update");
		return 0;
	}

	@Override
	public int delete(Object o) {
		// TODO Auto-generated method stub
		System.out.println("GuestMember delete");
		return 0;
	}
}
