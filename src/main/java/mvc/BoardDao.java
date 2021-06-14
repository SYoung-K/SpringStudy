package mvc;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.MybaFactory;

public class BoardDao {
	
	SqlSession sqlSession;
	
	public BoardDao() {
		try { 
			sqlSession = MybaFactory.getFactory().openSession();
			
			if(sqlSession == null) {
				System.out.println("sqlSession 생성시 오류 발생");
			}else {
				System.out.println("정상적으로 sqlSession이 생성됨");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	public List<BoardVo> input(BoardVo vo) {
		List totlist = null;

		totlist = sqlSession.selectList("board.totList", vo);	
		
		return totlist;
	}
	
	
	public List<BoardVo> search(BoardVo vo, Page p) {
		List list = null;

		list = sqlSession.selectList("board.totList", vo);	
		p.setTotList(list.size());
		p.compute();

		list = sqlSession.selectList("board.searchList",p);
		
		System.out.println(list.size());
		return list;
	}
	
	
	
	
	
	
	
	
}
