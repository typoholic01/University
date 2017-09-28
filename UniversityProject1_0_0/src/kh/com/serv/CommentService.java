package kh.com.serv;

import java.util.List;

import kh.com.model.CommentDto;
import kh.com.model.QueryComment;

public interface CommentService {
	
	/*					CREATE					*/
	boolean insertComment(CommentDto comment);
	
	/*					READ					*/
	CommentDto getComment(int commentSeq);
	List<CommentDto> getCommentList(QueryComment query);
	int getTotalComment(int bbsSeq);
	
	/*					UPDATE					*/
	boolean updateComment(CommentDto comment);

	/*					DELETE					*/
	boolean deleteComment(int commentSeq);

}
