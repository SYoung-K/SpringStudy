package di.Exam2;

import java.util.List;

public interface Member {
	
	public List<Object> select(Object o);  // Read
	public int insert(Object o);  //Creat
	public int update(Object o);  //Update
	public int delete(Object o);  //Delete
}
