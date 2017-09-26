package kh.com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.com.model.MainNoticeBbsDto;
import kh.com.serv.MainNoticeBbsService;
import kh.com.util.Pagination;

@Controller
public class MainNoticeController {
	private static final Logger logger = LoggerFactory.getLogger(MainNoticeController.class);
	
	@Autowired
	MainNoticeBbsService serv;	
	
	
	/*************************************************
	 * 					CREATE
	 * ***********************************************/
	//글쓰기 화면
	@RequestMapping(value="/notice/write.do",method=RequestMethod.GET)
	public String write(Model model) {
		logger.info("/notice/write.do");
		
		
		
		return "mainNoticeWrite.tiles";
	}
	
	//글쓰기 기능
	@RequestMapping(value="/notice/writeAf.do",method=RequestMethod.POST)
	public String writePost(MainNoticeBbsDto bbs, Model model) {
		logger.info("Post: /notice/writeAf.do");		
		
		//파일을 올리지 않았을 시
		if (bbs.getFileName() == null)
			bbs.setFileName("-1");
		if (bbs.getOrgFileName() == null)
			bbs.setOrgFileName("-1");		
		
		logger.info(bbs.toString());
		
		try {
			serv.insertBbs(bbs);			
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			logger.info("success");
		}
		
		return "redirect:/notice/list.do";
	}
	
	
	/*************************************************
	 * 					READ
	 * ***********************************************/
	//리스트 화면
	@RequestMapping(value="/notice/list.do",method=RequestMethod.GET)
	public String list(HttpServletRequest req, Model model) {
		logger.info("/notice/list.do");
		Pagination pagination;
		List<MainNoticeBbsDto> bbsList;
		
		try {
			pagination = getPagination(req);
			bbsList = getBbsList(pagination);
			
			model.addAttribute("bbsList", bbsList);
			model.addAttribute("pagination", pagination);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			logger.info("success");
		}
		
		return "mainNotice.tiles";
	}
	
	//디테일 화면
	@RequestMapping(value="/notice/detail.do",method=RequestMethod.GET)
	public String detail(HttpServletRequest req, Model model) {
		logger.info("/notice/detail.do");
		//init
		Pagination pagination;
		List<MainNoticeBbsDto> bbsList;
		
		//상단 디테일
		int seq = Integer.parseInt(req.getParameter("seq"));
		
		MainNoticeBbsDto bbs = serv.getBbs(seq);
		
		logger.info(bbs.toString());
		
		model.addAttribute("bbs", bbs);
		
		//하단 리스트		
		try {
			pagination = getPagination(req);
			bbsList = getBbsList(pagination);
			model.addAttribute("bbsList", bbsList);
			model.addAttribute("pagination", pagination);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			logger.info("success");
		}
		
		return "mainNoticeDetail.tiles";
	}
	
	//리스트 가져오기
	private List<MainNoticeBbsDto> getBbsList(Pagination pagination) {		
		return serv.getBbsList(pagination);
		
	}
	
	//페이징 가져오기
	private Pagination getPagination(HttpServletRequest req) {
		int totalArticle;		
		String pageStr = req.getParameter("page");
		int page;
		
		if (pageStr == null) 	page = 1;
		else 					page = Integer.parseInt(pageStr);		
		
		totalArticle = serv.getTotalArticle();
		return new Pagination(totalArticle, page);
		
	}
	
	/*************************************************
	 * 					UPDATE
	 * ***********************************************/
	//글 수정하기
	@RequestMapping(value="/notice/update.do",method=RequestMethod.GET)
	public String updateArticle(HttpServletRequest req, Model model) {
		logger.info("updateArticle");
		String seq;
		seq = req.getParameter("seq");
		
		if (seq == null) return "error.tiles";
		
		MainNoticeBbsDto bbs = serv.getBbs(Integer.parseInt(seq));
		
		model.addAttribute("bbs", bbs);
		
		return "mainNoticeWrite.tiles";
	}
	
	//글 수정하기
	@RequestMapping(value="/notice/updateAf.do",method=RequestMethod.POST)
	public String updateAfArticle(MainNoticeBbsDto bbs, Model model) {
		logger.info("updateAfArticle");
		
		logger.info(bbs.toString());
		
		serv.updateArticle(bbs);
		
		return  "redirect:/notice/list.do";
	}
	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/
	//글 삭제하기
	@RequestMapping(value="/notice/delete.do",method=RequestMethod.GET)
	public String deleteArticle(HttpServletRequest req, RedirectAttributes redirectAttributes) {
		//init
		String seqStr, page;
		int seq;		
		
		//값 받아오기
		seqStr = req.getParameter("seq");
		if (seqStr == null) return "error.tiles";
		else seq = Integer.parseInt(seqStr);
		
		page = req.getParameter("page");
		
		//삭제
		serv.deleteArticle(seq);
		
		//리다이렉트 전달값
		redirectAttributes.addAttribute("page", page);
		
		return "redirect:/notice/list.do";
		
	}	

}
