package board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/board.do")
public class BoardServelt extends HttpServlet{
	BoardDao dao;
	RequestDispatcher rd;
	String job = "search";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		BoardVo vo = null;
		String url="./board/";
		dao = new BoardDao();
		
		
		int serial = 0;
		Page page = new Page();
		String tempNowPage = req.getParameter("nowPage");
		
		if(req.getParameter("job") != null) {
			job = req.getParameter("job");
		}
		
		if(req.getParameter("findStr") != null) {
			page.setFindStr(req.getParameter("findStr"));
		}
		
		if(tempNowPage == null || tempNowPage.equals("")) {
			page.setNowPage(1);
		}else {
			page.setNowPage(Integer.parseInt(tempNowPage));
		}
		
		if(!(req.getParameter("serial") == null || req.getParameter("serial").equals("")) ){
			serial = Integer.parseInt(req.getParameter("serial"));
		}
		
		
		switch(job) {
		case "search":
			url += "search.jsp";
			List<BoardVo> list = dao.select(page);
			
			req.setAttribute("list", list);
			break;
			
		case "view":
			url += "view.jsp";
			vo = dao.view(serial);
			
			req.setAttribute("vo", vo);
			
			break;
		case "modify":
			url += "modify.jsp";
			vo = dao.view(serial);
			
			req.setAttribute("vo", vo);
			
			break;
			
			
		case "delete":
			url += "search.jsp";
			vo = new BoardVo();
			vo.setSerial(serial);
			vo.setMid(req.getParameter("mid"));
			vo.setPwd(req.getParameter("pwd"));
			dao.delete(vo);
			
			list = dao.select(page);
			req.setAttribute("list", list);
			break;
			
		}
		
		req.setAttribute("page", page);
		rd = req.getRequestDispatcher(url);
		rd.include(req, resp);
		
	}

	@Override
	public void init() throws ServletException {
	}

	
}
