package kh.com.serv;

import java.util.List;

import kh.com.model.MainNoticeBbsDto;

public interface MainNoticeBbsService {

	List<MainNoticeBbsDto> getBbsList();

	boolean insertBbs(MainNoticeBbsDto dto);
}
