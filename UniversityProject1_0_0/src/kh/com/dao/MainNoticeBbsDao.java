package kh.com.dao;

import java.util.List;

import kh.com.model.MainNoticeBbsDto;
import kh.com.util.Pagination;

public interface MainNoticeBbsDao {
	
	List<MainNoticeBbsDto> getBbsList(Pagination pagination);

	boolean insertBbs(MainNoticeBbsDto dto);

	int getTotalBbs();

	MainNoticeBbsDto getBbs(int seq);

	boolean deleteBbs(int seq);

	boolean updateBbs(MainNoticeBbsDto bbs);

}
