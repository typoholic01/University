package kh.com.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.com.model.CommentDto;
import kh.com.serv.CommentService;

@Controller
public class CommentController {
	private static final Logger logger = LoggerFactory.getLogger(BbsController.class);
	private static final String prefixAddress = "/comment/";
	
	@Autowired
	CommentService serv;

	/*************************************************
	 * 					CREATE
	 * ***********************************************/	
	//글쓰기 기능
	@RequestMapping(value=prefixAddress+"writeAf.do",method=RequestMethod.POST)
	public String writePost(HttpServletRequest req, Model model) {
		logger.info("Post: /comment/writeAf.do");
		//init
		int bbsSeq;
		String boardAddress;
        String userId;
        String commentContent;
        CommentDto comment;
        
        //init
        comment = new CommentDto();
        
        //listen
		boardAddress = req.getParameter("boardAddress");
		bbsSeq = getBbsSeq(req);
		userId = req.getParameter("userId");
		commentContent = req.getParameter("commentContent");
		
		//setup
		comment.setBbsSeq(bbsSeq);
        comment.setUserId(userId);
        comment.setCommentContent(commentContent);
        
		serv.insertComment(comment);
		
		return "redirect:/pds/list.do";		//FIXME
	}

	private int getBbsSeq(HttpServletRequest req) {		
		return req.getParameter("bbsSeq") == null ? 0:Integer.parseInt(req.getParameter("bbsSeq"));
	}
}
