package di.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class BoardService {

	@Autowired
	Dao bd;   // @autowired 쓰면 set을 만들지 않아도 자동으로 입력한다.
		
	public void setBd(BoardDao bd) {
		this.bd = bd;
	}
	
	public void output() {
		
		bd.Insert(bd);
		bd.Select(bd);
		
		
		
	}

}
