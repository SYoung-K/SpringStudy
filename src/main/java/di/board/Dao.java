package di.board;

import java.util.List;

public interface Dao {

	public List<Object> Select(Object o);
	public int Insert(Object o);
	public int Update(Object o);
	public int Delete(Object o);
	
}
