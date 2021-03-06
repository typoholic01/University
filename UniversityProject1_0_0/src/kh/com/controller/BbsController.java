package kh.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.com.model.MainBbs;
import kh.com.model.QueryBbs;
import kh.com.model.QueryComment;
import kh.com.serv.BbsService;
import kh.com.serv.CommentService;
import kh.com.util.FileUpload;
import kh.com.util.Pagination;

@Controller
public class BbsController {
	private static final Logger logger = LoggerFactory.getLogger(BbsController.class);
	//http://springboot.tistory.com/25 예외처리
	
	@Autowired
	BbsService servBbs;
	
	/*************************************************
	 * 					CREATE
	 * ***********************************************/
	//글쓰기 화면
	@RequestMapping(value= "/{boardUrl}/write.do",method=RequestMethod.GET)
	public String write(@PathVariable String boardUrl, Model model) {
		logger.info("/{}/write.do",boardUrl);
		
		
		
		return "mainBbsWrite.tiles";
	}
	
	//글쓰기 기능
	@RequestMapping(value="/{boardUrl}/writeAf.do",method=RequestMethod.POST)
	public String writePost(@PathVariable String boardUrl, MultipartHttpServletRequest req, MultipartFile uploadFile, Model model) throws IOException {
		logger.info("Post: /{}/writeAf.do",boardUrl);
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
        bbs.setBoardUrl(boardUrl);
        bbs.setUserId(userId);
        bbs.setBbsTitle(bbsTitle);
        bbs.setBbsContent(bbsContent);
        bbs.setBbsStoredFileName(bbsStoredFileName);
        bbs.setBbsOrgFileName(bbsOrgFileName);
        
		servBbs.insertBbs(bbs);		
		
		logger.info("insert Done");
		
		return "redirect:/"+boardUrl+"/list.do";
	}
	
	
	/*************************************************
	 * 					READ
	 * ***********************************************/
	//리스트 화면
	@RequestMapping(value="/{boardUrl}/list.do",method=RequestMethod.GET)
	public String list(@PathVariable String boardUrl, HttpServletRequest req, Model model) {
		logger.info("/bbs/list.do");
		
		//init
		List<MainBbs> bbsList;
		QueryBbs query;
		Pagination pagination;
		
		//페이징
		pagination = new Pagination(getTotalBbs(boardUrl), getCurrPage(req));

		//질의 설정
		query = new QueryBbs();
		query.setBoardUrl(boardUrl);
		query.setStartArticle(pagination.getStartArticle());
		query.setEndArticle(pagination.getEndArticle());
		
		//받아오기
		bbsList = servBbs.getBbsList(query);
		
		//요소 추가
		model.addAttribute("bbsList", bbsList);
		model.addAttribute("pagination", pagination);
		model.addAttribute("boardUrl", boardUrl);
		
		return "mainBbsList.tiles";
	}

	//디테일 화면
	@RequestMapping(value="/{boardUrl}/detail.do",method=RequestMethod.GET)
	public String detail(@PathVariable String boardUrl, HttpServletRequest req, Model model) {
		logger.info("/{}/detail.do", boardUrl);
		//init
		Pagination pagination;
		List<MainBbs> bbsList;
		MainBbs bbs;
		QueryBbs queryBbs;
		int seq;

		//페이징
		pagination = new Pagination(getTotalBbs(boardUrl), getCurrPage(req));
		
		//질의 설정
		seq = Integer.parseInt(req.getParameter("seq"));
		
		queryBbs = new QueryBbs();
		queryBbs.setBoardUrl(boardUrl);
		queryBbs.setStartArticle(pagination.getStartArticle());
		queryBbs.setEndArticle(pagination.getEndArticle());
		
		//DB 데이터
		bbs = servBbs.getBbs(seq);
		bbsList = servBbs.getBbsList(queryBbs);
		
		//요소 추가
		model.addAttribute("bbsList", bbsList);
		model.addAttribute("pagination", pagination);
		model.addAttribute("boardUrl", boardUrl);
		model.addAttribute("bbs", bbs);
		
		//매핑
		if (boardUrl.equals("notice")) {
			logger.info("noComment");
			//댓글 없는 곳
			return "noCommentBbsDetail.tiles";
			
		} else {
			logger.info("Comment");
			//댓글 있는 곳
			return "bbsDetail.tiles";
		}
		
	}
	
	/*************************************************
	 * 					UPDATE
	 * ***********************************************/
	//글 수정하기
	@RequestMapping(value="/{boardUrl}/update.do",method=RequestMethod.GET)
	public String updateArticle(@PathVariable String boardUrl, HttpServletRequest req, Model model) {
		logger.info("bbs/update");
		//init
		MainBbs bbs;
		
		//DB get
		bbs = servBbs.getBbs(getSeq(req));
		
		//요소 추가
		model.addAttribute("bbs", bbs);
		
		return "mainBbsUpdate.tiles";
	}
	
	//글 수정하기
	@RequestMapping(value="/{boardUrl}/updateAf.do",method=RequestMethod.POST)
	public String updateAfArticle(@PathVariable String boardUrl, MainBbs bbs, Model model) {
		logger.info("updateAfArticle");
		
		//query Set
		bbs.setBoardUrl(boardUrl);
		
		//DB set
		try {
			servBbs.updateBbs(bbs);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return  "redirect:/"+boardUrl+"/list.do";
	}
	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/
	//글 삭제하기
	@RequestMapping(value="/{boardUrl}/delete.do",method=RequestMethod.GET)
	public String deleteArticle(@PathVariable String boardUrl, HttpServletRequest req, RedirectAttributes redirectAttributes) {
		logger.info("/bbs/delete");
		
		//삭제
		servBbs.deleteBbs(getSeq(req));
		
		//리다이렉트 전달값
		redirectAttributes.addAttribute("page", req.getParameter("page"));
		
		return "redirect:/"+boardUrl+"/list.do";
		
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
		return servBbs.getTotalBbs(boardName);
	}

}