package kh.com.dao;

import java.util.List;

import kh.com.model.MainPdsDto;
import kh.com.util.Pagination;

public interface MainPdsDao {
	
	/*					CREATE					*/
	boolean insertBbs(MainPdsDto dto);
	
	/*					READ					*/
	MainPdsDto getBbs(int seq);
	List<MainPdsDto> getBbsList(Pagination pagination);
	int getTotalBbs();
	
	/*					UPDATE					*/
	boolean updateBbs(MainPdsDto bbs);

	/*					DELETE					*/
	boolean deleteBbs(int seq);

}
