package kh.com.dao;

import java.util.List;

import kh.com.model.MainBbs;
import kh.com.model.QueryBbs;

public interface BbsDao {
	
	/*					CREATE					*/
	boolean insertBbs(MainBbs dto);
	
	/*					READ					*/
	MainBbs getBbs(int seq);
	List<MainBbs> getBbsList(QueryBbs query);
	int getTotalBbs(String boardName);
	
	/*					UPDATE					*/
	boolean updateBbs(MainBbs bbs);

	/*					DELETE					*/
	boolean deleteBbs(int seq);

}
