package kh.com.serv;

import java.util.List;

import kh.com.model.MainNoticeBbsDto;
import kh.com.util.Pagination;

public interface MainNoticeBbsService {
	
	MainNoticeBbsDto getBbs(int seq);
	List<MainNoticeBbsDto> getBbsList(Pagination pagination);

	boolean insertBbs(MainNoticeBbsDto dto);

	int getTotalArticle();
}
