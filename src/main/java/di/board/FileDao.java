package di.board;

import java.util.List;

public class FileDao implements Dao {

	@Override
	public List<Object> Select(Object o) {
		System.out.println("FileDao select 실행됨");
		return null;
	}

	@Override
	public int Insert(Object o) {
		System.out.println("FileDao Insert 실행됨");
		return 0;
	}

	@Override
	public int Update(Object o) {
		System.out.println("FileDao Update 실행됨");
		return 0;
	}

	@Override
	public int Delete(Object o) {
		System.out.println("FileDao Delete 실행됨");
		return 0;
	}

	
}
