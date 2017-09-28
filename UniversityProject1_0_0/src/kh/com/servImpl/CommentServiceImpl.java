package kh.com.servImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.CommentDao;
import kh.com.model.CommentDto;
import kh.com.model.QueryComment;
import kh.com.serv.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao dao;

	@Override
	public boolean insertComment(CommentDto comment) {
		return dao.insertComment(comment);
	}

	@Override
	public CommentDto getComment(int commentSeq) {
		return dao.getComment(commentSeq);
	}

	@Override
	public List<CommentDto> getCommentList(QueryComment query) {
		return dao.getCommentList(query);
	}

	@Override
	public int getTotalComment(int bbsSeq) {
		return dao.getTotalComment(bbsSeq);
	}

	@Override
	public boolean updateComment(CommentDto comment) {
		return dao.updateComment(comment);
	}

	@Override
	public boolean deleteComment(int commentSeq) {
		return dao.deleteComment(commentSeq);
	}

}
