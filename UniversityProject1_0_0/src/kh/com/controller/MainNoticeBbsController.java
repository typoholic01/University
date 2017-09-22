package kh.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainNoticeBbsController {
	private static final Logger logger = LoggerFactory.getLogger(MainNoticeBbsController.class);
	
	@RequestMapping(value="/mainNoticeBbs.do",method=RequestMethod.GET)
	public String mainNoticeBbs() {
		logger.info("mainNoticeBbs");
		
		
		return "main.tiles";
	}

}
