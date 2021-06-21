package board;


import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BrdController {
	List<BoardAttVo> attList;
	
	@Autowired
	BoardDao dao;
	
	@Autowired
	BoardFileUploadController fileUpload;
	
	@RequestMapping(value="/fup.brd", method=RequestMethod.POST)
	public void upload(HttpServletRequest req , HttpServletResponse resp){
	   attList = fileUpload.upload(req);
	   System.out.println(attList.size());
	   
	   PrintWriter pw;
	   try {
		   pw = resp.getWriter();
		   pw.print("OK");
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }
	}
	
	@RequestMapping(value="/search.brd", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView search(Page p) {  // 이름은 아무 상관 없다. a를 하든 board를 하던
		ModelAndView mv = new ModelAndView();		
		
		List<BoardVo> list = dao.select(p);	
		
		mv.addObject("list",list);  // 담을 객체
		mv.addObject("page",p);  // 담을 객체
		mv.setViewName("search");  // input_result로 보내라.   prefix / suffix 가 붙기때문에 /board/ + input_result + .jsp 로 변환
		
		return mv;   // 객체 반환
	}
	
	@RequestMapping(value="/view.brd", method= {RequestMethod.POST})
	public ModelAndView view(BoardVo v, Page p) {  // 이름은 아무 상관 없다. a를 하든 board를 하던
		ModelAndView mv = new ModelAndView();
		BoardVo vo = dao.view(v.getSerial());	
		mv.addObject("vo",vo);  // 담을 객체
		mv.addObject("page",p);  // 담을 객체
		mv.setViewName("view");  // view로 보내라.   prefix / suffix 가 붙기때문에 /board/ + input_result + .jsp 로 변환
		
		return mv;   // 객체 반환
	}
	
	@RequestMapping(value="/modify.brd", method= {RequestMethod.POST})
	public ModelAndView modify(BoardVo v, Page p) {  // 이름은 아무 상관 없다. a를 하든 board를 하던
		ModelAndView mv = new ModelAndView();
		BoardVo vo = dao.view(v.getSerial());	
		
		mv.addObject("vo",vo);  // 담을 객체
		mv.addObject("page",p);  // 담을 객체
		mv.setViewName("modify");  // modify로 보내라.   prefix / suffix 가 붙기때문에 /board/ + input_result + .jsp 로 변환
		
		return mv;   // 객체 반환
	}
	
	@RequestMapping(value="/modifyR.brd", method= {RequestMethod.POST})
	public ModelAndView modifyR(BoardVo v, Page p, @RequestParam(value="delFile", required=false) List<String> delFile) {
		ModelAndView mv = new ModelAndView();
		List<BoardAttVo> delList = new ArrayList<BoardAttVo>();
		
		if(delFile != null) {
			for(String ori : delFile) {
				BoardAttVo attVo = new BoardAttVo();
				attVo.setSysAtt(ori);
				delList.add(attVo);
				v.setDelList(delList);
			}
			
		}
		
		v.setAttList(attList);
		
		
		System.out.println("modifyR..............");
		System.out.println(delList.size());
		
		
		dao.update(v);
		
		mv = search(p);
		mv.setViewName("search");
		
		return mv;
	}
	
	
	@RequestMapping(value="/delete.brd", method= {RequestMethod.POST})
	public ModelAndView delete(BoardVo v, Page p) {  // 이름은 아무 상관 없다. a를 하든 board를 하던
		ModelAndView mv = new ModelAndView();

		dao.delete(v);
		List<BoardVo> list = dao.select(p);
		
		mv.addObject("page",p);  // 담을 객체
		mv.addObject("list",list);  // 담을 객체
		mv.setViewName("search");  // modify로 보내라.   prefix / suffix 가 붙기때문에 /board/ + input_result + .jsp 로 변환
		
		return mv;   // 객체 반환
	}
	
	@RequestMapping(value="/register.brd", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView register(Page p) {  // 이름은 아무 상관 없다. a를 하든 board를 하던
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("page",p);  // 담을 객체
		mv.setViewName("register");  // modify로 보내라.   prefix / suffix 가 붙기때문에 /board/ + input_result + .jsp 로 변환
		
		return mv;   // 객체 반환
	}
	
	@RequestMapping(value="/registerR.brd", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView registerR(BoardVo vo, Page p){  // 이름은 아무 상관 없다. a를 하든 board를 하던

		ModelAndView mv = new ModelAndView();
		
			vo.setAttList(attList);
			dao.insert(vo);
			
			mv = search(p);
		
		return mv;   // 객체 반환
	}
	
}
