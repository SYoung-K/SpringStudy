package aop.aspectj;

import java.util.List;

public interface Dao {

	public List<Object> select(); 
	public int insert(); 
	public int update(); 
	public int delete(); 
	

}
