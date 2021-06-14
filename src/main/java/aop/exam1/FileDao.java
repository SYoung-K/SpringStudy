package aop.exam1;

import java.util.List;

public class FileDao implements Dao {

	@Override
	public List<Object> select() {
		System.out.println("FileDao select 실행");
		return null;
	}

	@Override
	public int insert() {
		System.out.println("FileDao insert 실행");
		return 0;
	}

	@Override
	public int update() {
		System.out.println("FileDao update 실행");
		return 0;
	}

	@Override
	public int delete() {
		System.out.println("FileDao delete 실행");
		return 0;
	}

	public void output() {
		select();
		insert();
		update();
		delete();
	}
	
}
