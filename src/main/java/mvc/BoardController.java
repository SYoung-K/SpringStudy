package mvc;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	@Autowired
	BoardDao dao;
	
	@RequestMapping(value="/input.board", method= {RequestMethod.GET, RequestMethod.POST})
		public ModelAndView a(BoardVo vo) {  // 이름은 아무 상관 없다. a를 하든 board를 하던
			ModelAndView mv = new ModelAndView();
			
			
		
			List<BoardVo> a = dao.input(vo);
			int msg = a.size();
			
			mv.addObject("msg",msg);
			mv.addObject("vo",vo);  // 담을 객체
			mv.setViewName("input_result");  // input_result로 보내라.   prefix / suffix 가 붙기때문에 /board/ + input_result + .jsp 로 변환
			
			return mv;   // 객체 반환
		}
	
	@RequestMapping(value="/search.board", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView b(BoardVo vo, Page p) {  // 이름은 아무 상관 없다. a를 하든 board를 하던
		ModelAndView mv = new ModelAndView();
		
		List<BoardVo> a = dao.search(vo,p);
		
		System.out.println(a.size());
		
		mv.addObject("vo",vo);  // 담을 객체
		mv.addObject("page",p);  // 담을 객체
		mv.addObject("list",a);  // 담을 객체
		mv.setViewName("search.board");  // input_result로 보내라.   prefix / suffix 가 붙기때문에 /board/ + input_result + .jsp 로 변환
		
		return mv;   // 객체 반환
	}
	
}
