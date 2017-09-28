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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.com.model.MainBbs;
import kh.com.model.QueryBbs;
import kh.com.serv.MainBbsService;
import kh.com.util.FileUpload;
import kh.com.util.Pagination;

@Controller
public class MainBbsPdsController {
	private static final Logger logger = LoggerFactory.getLogger(MainBbsPdsController.class);
	public static final String boardName = "자료 게시판";
	private static final String prefixAddress = "/pds/";
	
	@Autowired
	MainBbsService serv;
	
	/*************************************************
	 * 					CREATE
	 * ***********************************************/
	//글쓰기 화면
	@RequestMapping(value= {prefixAddress+"write.do"},method=RequestMethod.GET)
	public String write(Model model) {
		logger.info("/notice/write.do");
		
		
		
		return "mainBbsWrite.tiles";
	}
	
	//글쓰기 기능
	@RequestMapping(value=prefixAddress+"writeAf.do",method=RequestMethod.POST)
	public String writePost(MultipartHttpServletRequest req, MultipartFile uploadFile, Model model) throws IOException {
		logger.info("Post: /notice/writeAf.do");
		//init
		String path = "";
        String userId; 
        String bbsContent;
        String bbsStoredFileName;
        String bbsOrgFileName;
        String bbsTitle;
        
        
        //init
        path = req.getSession().getServletContext().getRealPath("/") + "upload/file/"; //파일 저장경로
        FileUpload fileUpload = new FileUpload(uploadFile, path);
        MainBbs bbs = new MainBbs();
        
        //listen
		userId = req.getParameter("userId");
		bbsTitle = req.getParameter("bbsTitle");
		bbsContent = req.getParameter("bbsContent");
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
		
		return "redirect:"+prefixAddress+"list.do";
	}
	
	
	/*************************************************
	 * 					READ
	 * ***********************************************/
	//리스트 화면
	@RequestMapping(value=prefixAddress+"list.do",method=RequestMethod.GET)
	public String list(HttpServletRequest req, Model model) {
		logger.info("/bbs/list.do");
		
		//init
		List<MainBbs> bbsList;
		QueryBbs query;
		Pagination pagination;
		
		//페이징
		pagination = new Pagination(getTotalBbs(boardName), getCurrPage(req));

		//질의 설정
		query = new QueryBbs();
		query.setBoardName(boardName);
		query.setStartArticle(pagination.getStartBbs());
		query.setEndArticle(pagination.getEndBbs());
		
		//받아오기
		bbsList = serv.getBbsList(query);
		
		//요소 추가
		model.addAttribute("bbsList", bbsList);
		model.addAttribute("pagination", pagination);
		model.addAttribute("boardName", boardName);
		
		return "mainBbsList.tiles";
	}

	//디테일 화면
	@RequestMapping(value=prefixAddress+"detail.do",method=RequestMethod.GET)
	public String detail(HttpServletRequest req, Model model) {
		logger.info("/bbs/detail.do");
		//init
		Pagination pagination;
		List<MainBbs> bbsList;
		MainBbs bbs;
		QueryBbs query;
		int seq;

		//페이징
		pagination = new Pagination(getTotalBbs(boardName), getCurrPage(req));
		
		//질의 설정
		seq = Integer.parseInt(req.getParameter("seq"));
		
		query = new QueryBbs();
		query.setBoardName(boardName);
		query.setStartArticle(pagination.getStartBbs());
		query.setEndArticle(pagination.getEndBbs());
		
		//DB 데이터
		bbs = serv.getBbs(seq);
		bbsList = serv.getBbsList(query);
		
		//요소 추가
		model.addAttribute("bbsList", bbsList);
		model.addAttribute("pagination", pagination);
		model.addAttribute("boardName", boardName);
		model.addAttribute("bbs", bbs);
		
		
		return "mainPdsDetail.tiles";
	}
	
	/*************************************************
	 * 					UPDATE
	 * ***********************************************/
	//글 수정하기
	@RequestMapping(value=prefixAddress+"update.do",method=RequestMethod.GET)
	public String updateArticle(HttpServletRequest req, Model model) {
		logger.info("bbs/update");
		//init
		MainBbs bbs;
		
		//DB get
		bbs = serv.getBbs(getSeq(req));
		
		//요소 추가
		model.addAttribute("bbs", bbs);
		
		return "mainBbsUpdate.tiles";
	}
	
	//글 수정하기
	@RequestMapping(value=prefixAddress+"updateAf.do",method=RequestMethod.POST)
	public String updateAfArticle(MainBbs bbs, Model model) {
		logger.info("updateAfArticle");
		
		//query Set
		bbs.setBoardName(boardName);
		
		//DB set
		try {
			serv.updateBbs(bbs);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return  "redirect:"+prefixAddress+"list.do";
	}
	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/
	//글 삭제하기
	@RequestMapping(value=prefixAddress+"delete.do",method=RequestMethod.GET)
	public String deleteArticle(HttpServletRequest req, RedirectAttributes redirectAttributes) {
		logger.info("/bbs/delete");
		
		//삭제
		serv.deleteBbs(getSeq(req));
		
		//리다이렉트 전달값
		redirectAttributes.addAttribute("page", req.getParameter("page"));
		
		return "redirect:"+prefixAddress+"list.do";
		
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
	
	private int getSeq(HttpServletRequest req) {
		int seq;
		
		if (req.getParameter("seq") == null) {
			seq = 0;
		} else {
			seq = Integer.parseInt(req.getParameter("seq"));
		}
		
		return seq;
	}

	private int getTotalBbs(String boardName) {
		return serv.getTotalBbs(boardName);
	}

}