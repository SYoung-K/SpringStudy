package aop.exam1;

import java.util.List;

public class BoardDao implements Dao {

	@Override
	public List<Object> select() {
		System.out.println("BoardDao select 실행");
		return null;
	}

	@Override
	public int insert() {
		
		System.out.println("BoardDao insert 실행");
		return 0;
	}

	@Override
	public int update() {
		System.out.println("BoardDao update 실행");
		return 0;
	}

	@Override
	public int delete() {
		System.out.println("BoardDao delete 실행");
		return 0;
	}
	
	public void output() {
		select();
		insert();
		update();
		delete();
	}

	
}
