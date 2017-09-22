package kh.com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.com.model.MainNoticeBbsDto;
import kh.com.serv.MainNoticeBbsService;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	MainNoticeBbsService serv;
	
	@RequestMapping(value="/notice/list.do",method=RequestMethod.GET)
	public String list(Model model) {
		logger.info("/notice/list.do");
		
		try {
			List<MainNoticeBbsDto> bbsList = serv.getBbsList();
			model.addAttribute("bbsList", bbsList);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			logger.info("success");
		}
		
		return "mainNotice.tiles";
	}
	
	@RequestMapping(value="/notice/write.do",method=RequestMethod.GET)
	public String write(Model model) {
		logger.info("/notice/write.do");
		
		
		
		return "mainNoticeWrite.tiles";
	}
	
	@RequestMapping(value="/notice/write.do",method=RequestMethod.POST)
	public String writePost(Model model) {
		logger.info("Post: /notice/write.do");
		
		//bbs 데이터
		MainNoticeBbsDto bbs = new MainNoticeBbsDto();
		bbs.setUserId("asdf");
		bbs.setTitle("제목");
		bbs.setContent("내용");
		bbs.setFileName("-1");
		bbs.setOrgFileName("-1");
		
		try {
			boolean b = serv.insertBbs(bbs);			
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			logger.info("success");
		}
		
		return "mainNotice.tiles";
	}

}
