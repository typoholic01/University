package kh.com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

import kh.com.model.MainPdsDto;
import kh.com.serv.MainPdsService;
import kh.com.util.Pagination;

@Controller
public class MainPdsController {
	private static final Logger logger = LoggerFactory.getLogger(MainPdsController.class);
	
	@Autowired
	MainPdsService serv;
	
	/*************************************************
	 * 					CREATE
	 * ***********************************************/
	//글쓰기 화면
	@RequestMapping(value="/pds/write.do",method=RequestMethod.GET)
	public String write(Model model) {
		logger.info("/pds/write.do");
		
		
		
		return "mainPdsWrite.tiles";
	}
	
	//글쓰기 기능
	@RequestMapping(value="/pds/writeAf.do",method=RequestMethod.POST)
	public String writePost(MultipartHttpServletRequest req, MultipartFile uploadFile, Model model) throws IOException {
		logger.info("Post: /pds/writeAf.do");
		//init
		String path = "";
        String fileName = "";
        OutputStream out = null;
        String id,title,content;
        MainPdsDto bbs = new MainPdsDto();
        
        //file save
        if (!uploadFile.getOriginalFilename().equals("")) {
			logger.info("upload file null");
        	//이름 짓기
            fileName = uploadFile.getOriginalFilename();
            fileName = System.currentTimeMillis() + "_" + fileName;
                    
            //경로 가져오기
            path = req.getSession().getServletContext().getRealPath("/");
            path += "upload/file/";
            
            //데이터 가져오기
            byte[] bytes = uploadFile.getBytes();
            
            //파일 저장
            File file = new File(path + fileName);        
            out = new FileOutputStream(file);
            out.write(bytes);
            out.close();
            
            //bbs 저장
            bbs.setOrgFileName(uploadFile.getOriginalFilename());
            bbs.setFileName(fileName);

    		logger.info("path: {}",path);
		} else {
			logger.info("upload file null");
			//bbs 저장
			bbs.setOrgFileName("-1");
			bbs.setFileName("-1");
		}        
        
        //bbs
        id = req.getParameter("userId");
        title = req.getParameter("title");
        content = req.getParameter("content");
        
        bbs.setUserId(id);
        bbs.setTitle(title);
        bbs.setContent(content);
        
		serv.insertBbs(bbs);		
		
		return "redirect:/pds/list.do";
	}
	
	
	/*************************************************
	 * 					READ
	 * ***********************************************/
	//리스트 화면
	@RequestMapping(value="/pds/list.do",method=RequestMethod.GET)
	public String list(HttpServletRequest req, Model model) {
		logger.info("/pds/list.do");
		Pagination pagination;
		List<MainPdsDto> bbsList;
		
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
		
		return "mainPdsList.tiles";
	}
	
	//디테일 화면
	@RequestMapping(value="/pds/detail.do",method=RequestMethod.GET)
	public String detail(HttpServletRequest req, Model model) {
		logger.info("/pds/detail.do");
		//init
		Pagination pagination;
		List<MainPdsDto> bbsList;
		
		//상단 디테일
		int seq = Integer.parseInt(req.getParameter("seq"));
		
		MainPdsDto bbs = serv.getBbs(seq);
		
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
		
		return "mainPdsDetail.tiles";
	}
	
	//디테일 화면
	@RequestMapping(value="/pds/comment.do",method=RequestMethod.GET)
	public String comment(HttpServletRequest req, Model model) {
		logger.info("/pds/comment.do");
		
		return "mainPdsComment.tiles";
	}
	
	//리스트 가져오기
	private List<MainPdsDto> getBbsList(Pagination pagination) {		
		return serv.getBbsList(pagination);
		
	}
	
	//페이징 가져오기
	private Pagination getPagination(HttpServletRequest req) {
		int totalArticle;		
		String pageStr = req.getParameter("page");
		int page;
		
		if (pageStr == null) 	page = 1;
		else 					page = Integer.parseInt(pageStr);		
		
		totalArticle = serv.getTotalBbs();
		return new Pagination(totalArticle, page);
		
	}
	
	/*************************************************
	 * 					UPDATE
	 * ***********************************************/
	//글 수정하기
	@RequestMapping(value="/pds/update.do",method=RequestMethod.GET)
	public String updateArticle(HttpServletRequest req, Model model) {
		logger.info("updateArticle");
		String seq;
		seq = req.getParameter("seq");
		
		if (seq == null) return "error.tiles";
		
		MainPdsDto bbs = serv.getBbs(Integer.parseInt(seq));
		
		model.addAttribute("bbs", bbs);
		
		return "mainPdsUpdate.tiles";
	}
	
	//글 수정하기
	@RequestMapping(value="/pds/updateAf.do",method=RequestMethod.POST)
	public String updateAfArticle(MainPdsDto bbs, Model model) {
		logger.info("updateAfArticle");
		
		logger.info(bbs.toString());
		
		serv.updateBbs(bbs);
		
		return  "redirect:/pds/list.do";
	}
	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/
	//글 삭제하기
	@RequestMapping(value="/pds/delete.do",method=RequestMethod.GET)
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
		serv.deleteBbs(seq);
		
		//리다이렉트 전달값
		redirectAttributes.addAttribute("page", page);
		
		return "redirect:/pds/list.do";
		
	}	

}
