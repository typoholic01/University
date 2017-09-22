package kh.com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.com.model.MainNoticeBbsDto;
import kh.com.serv.MainNoticeBbsService;

@Controller
public class MainNoticeBbsController {
	private static final Logger logger = LoggerFactory.getLogger(MainNoticeBbsController.class);
	
	@Autowired
	MainNoticeBbsService serv;
	
	@RequestMapping(value="/mainNoticeBbs.do",method=RequestMethod.GET)
	public String mainNoticeBbs() {
		logger.info("mainNoticeBbs");
		
		try {
			List<MainNoticeBbsDto> list = serv.getBbsList();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			logger.info("success");
		}
		
		return "main.tiles";
	}

}
