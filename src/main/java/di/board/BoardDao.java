package di.board;

import java.util.List;

public class BoardDao implements Dao {

	@Override
	public List<Object> Select(Object o) {
		System.out.println("BoardDao select 실행됨");
		return null;
	}

	@Override
	public int Insert(Object o) {
		System.out.println("BoardDao Insert 실행됨");
		return 0;
	}

	@Override
	public int Update(Object o) {
		System.out.println("BoardDao Update 실행됨");
		return 0;
	}

	@Override
	public int Delete(Object o) {
		System.out.println("BoardDao Delete 실행됨");
		return 0;
	}

	
}
