package kh.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kh.com.model.MainBbs;
import kh.com.model.MainNoticeBbsDto;
import kh.com.model.Query;
import kh.com.serv.MainBbsService;
import kh.com.util.FileUpload;
import kh.com.util.Pagination;

@Controller
public class MainBbsController {
	private static final Logger logger = LoggerFactory.getLogger(MainBbsController.class);
	
	@Autowired
	MainBbsService serv;
	
	/*************************************************
	 * 					CREATE
	 * ***********************************************/
	//글쓰기 화면
	@RequestMapping(value="/bbs/write.do",method=RequestMethod.GET)
	public String write(Model model) {
		logger.info("/bbs/write.do");
		
		
		
		return "mainNoticeWrite.tiles";
	}
	
	//글쓰기 기능
	@RequestMapping(value="/bbs/writeAf.do",method=RequestMethod.POST)
	public String writePost(MultipartHttpServletRequest req, MultipartFile uploadFile, Model model) throws IOException {
		logger.info("Post: /bbs/writeAf.do");
		//init
		String path = "";
        String boardName,userId,bbsTitle,bbsContent,bbsStoredFileName,bbsOrgFileName;
        
        //init
        path = req.getSession().getServletContext().getRealPath("/") + "upload/file/"; //파일 저장경로
        FileUpload fileUpload = new FileUpload(uploadFile, path);
        MainBbs bbs = new MainBbs();
        
        //listen
        boardName = "대문공지";
		userId = req.getParameter("userId");
		bbsTitle = req.getParameter("title");
		bbsContent = req.getParameter("content");
		bbsStoredFileName = fileUpload.getStoredFileName();
		bbsOrgFileName = fileUpload.getOrgFileName();
		
		//setup
        bbs.setBoardName(boardName);
        bbs.setUserId(userId);
        bbs.setBbsTitle(bbsTitle);
        bbs.setBbsContent(bbsContent);
        bbs.setBbsStoredFileName(bbsStoredFileName);
        bbs.setBbsOrgFileName(bbsOrgFileName);
        
		serv.insertBbs(bbs);		
		
		return "redirect:/notice/list.do";
	}
	
	
	/*************************************************
	 * 					READ
	 * ***********************************************/
	//리스트 화면
	@RequestMapping(value="/bbs/list.do",method=RequestMethod.GET)
	public String list(HttpServletRequest req, Model model) {
		logger.info("/bbs/list.do");
		
		//init
		List<MainBbs> bbsList;
		Query query;
		Pagination pagination;
		
		//페이징
		pagination = new Pagination(getTotalBbs("대문공지"), getCurrPage(req));

		//질의 설정
		query = new Query();
		query.setBoardName("대문공지");
		query.setStartArticle(pagination.getStartBbs());
		query.setEndArticle(pagination.getEndBbs());
		
		//받아오기
		bbsList = serv.getBbsList(query);
		
		//요소 추가
		model.addAttribute("bbsList", bbsList);
		model.addAttribute("pagination", pagination);
		
		return "mainNotice.tiles";
	}

	//디테일 화면
	@RequestMapping(value="/bbs/detail.do",method=RequestMethod.GET)
	public String detail(HttpServletRequest req, Model model) {
		logger.info("/bbs/detail.do");
		//init
		Pagination pagination;
		List<MainBbs> bbsList;
		MainBbs bbs;
		Query query;
		int seq;

		//페이징
		pagination = new Pagination(getTotalBbs("대문공지"), getCurrPage(req));
		
		//질의 설정
		seq = Integer.parseInt(req.getParameter("seq"));
		
		query = new Query();
		query.setBoardName("대문공지");
		query.setStartArticle(pagination.getStartBbs());
		query.setEndArticle(pagination.getEndBbs());
		
		//DB 데이터
		bbs = serv.getBbs(seq);
		bbsList = serv.getBbsList(query);
		
		//요소 추가
		model.addAttribute("bbsList", bbsList);
		model.addAttribute("pagination", pagination);
		model.addAttribute("bbs", bbs);
		
		return "mainNoticeDetail.tiles";
	}
	
	/************************************************************
	 * 							Util Method 
	 * **********************************************************/
	private int getCurrPage(HttpServletRequest req) {
		int currPage;
		
		if (req.getParameter("page") == null) {
			currPage = 1;
		} else {
			currPage = Integer.parseInt(req.getParameter("page"));
		}
		
		return currPage;
	}

	private int getTotalBbs(String boardName) {
		return serv.getTotalBbs(boardName);
	}

}