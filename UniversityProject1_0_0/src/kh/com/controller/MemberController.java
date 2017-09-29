package kh.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	private static final Logger logger 
		= LoggerFactory.getLogger(MemberController.class);
	
	/**
	 * 메인페이지 
	 */
	@RequestMapping(value="main.do", method=RequestMethod.GET)
	public String main(Model model) {
		logger.info("KhMemberController login");				
		return "main.tiles";
	}
	
	/**
	 * 서브페이지 (오른쪽 메뉴영역 다름) 
	 */
	@RequestMapping(value="sub_test.do", method=RequestMethod.GET)
	public String sub(Model model) {
		logger.info("KhMemberController login");				
		return "sub.tiles";
	}	
	
}





