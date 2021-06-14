package di.Exam1;

import java.util.List;

public interface member {
	
	public List<Object> select(Object o);  // Read
	public int insert(Object o);  //Creat
	public int update(Object o);  //Update
	public int delete(Object o);  //Delete
}
