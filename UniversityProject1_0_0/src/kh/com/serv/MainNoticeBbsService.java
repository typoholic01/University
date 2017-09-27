package kh.com.serv;

import java.util.List;

import kh.com.model.MainNoticeBbsDto;
import kh.com.util.Pagination;

public interface MainNoticeBbsService {
	
	/*					CREATE					*/
	boolean insertBbs(MainNoticeBbsDto dto);
	
	/*					READ					*/
	MainNoticeBbsDto getBbs(int seq);
	List<MainNoticeBbsDto> getBbsList(Pagination pagination);
	int getTotalBbs();
	
	/*					UPDATE					*/
	boolean updateBbs(MainNoticeBbsDto bbs);

	/*					DELETE					*/
	boolean deleteBbs(int seq);


}
