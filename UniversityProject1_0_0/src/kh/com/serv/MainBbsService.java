package kh.com.serv;

import java.util.List;

import kh.com.model.MainBbs;
import kh.com.model.Query;

public interface MainBbsService {
	
	/*					CREATE					*/
	boolean insertBbs(MainBbs dto);
	
	/*					READ					*/
	MainBbs getBbs(int seq);
	List<MainBbs> getBbsList(Query query);
	int getTotalBbs(String boardName);
	
	/*					UPDATE					*/
	boolean updateBbs(MainBbs bbs);

	/*					DELETE					*/
	boolean deleteBbs(int seq);

}
