package mvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello.do", method= {RequestMethod.GET, RequestMethod.POST})
		public ModelAndView hello() {
			ModelAndView mv = new ModelAndView();
			
			//Model : model.addAttribute("msg", "Hi...spring !!!!")
			mv.addObject("msg","Hi...spring !!!");
			mv.setViewName("hello");
			
			
			return mv;
		}
	
	
	
//	@Autowired
//	Dao dao;  // Dao 알아서 찾아서 넣어줌
//	@RequestMapping(value="/hello.do", method= {RequestMethod.GET, RequestMethod.POST})
//		public ModelAndView hello(BoardVo vo) {
//			ModelAndView mv = new ModelAndView();
//			
//			List<Vo> list = dao.search(vo)
//			//Model : model.addAttribute("msg", "Hi...spring !!!!")
//			mv.addObject("list",list);
//			mv.addObject("msg","Hi...spring !!!");
//			mv.setViewName("hellow");
//			
//			
//			return mv;
//		}
	
	
}
