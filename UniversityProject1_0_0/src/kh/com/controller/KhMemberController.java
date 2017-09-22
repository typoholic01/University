package kh.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class KhMemberController {
	
	private static final Logger logger 
		= LoggerFactory.getLogger(KhMemberController.class);
	
	@RequestMapping(value="main.do", method=RequestMethod.GET)
	public String main(Model model) {
		logger.info("KhMemberController login");				
		return "main.tiles";
	}	
	
}




