package kh.com.dao;

import java.util.List;

import kh.com.model.MainNoticeBbsDto;

public interface MainNoticeBbsDao {
	
	List<MainNoticeBbsDto> getBbsList();

	boolean insertBbs(MainNoticeBbsDto dto);

}
