package kh.com.servImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.MainNoticeBbsDao;
import kh.com.model.MainNoticeBbsDto;
import kh.com.serv.MainNoticeBbsService;
import kh.com.util.Pagination;

@Service
public class MainNoticeBbsServiceImpl implements MainNoticeBbsService {
	
	@Autowired
	MainNoticeBbsDao dao;

	@Override
	public List<MainNoticeBbsDto> getBbsList(Pagination pagination) {
		return dao.getBbsList(pagination);
	}
	
	@Override
	public int getTotalBbs() {
		return dao.getTotalBbs();
	}

	@Override
	public boolean insertBbs(MainNoticeBbsDto dto) {
		return dao.insertBbs(dto);
	}

	@Override
	public MainNoticeBbsDto getBbs(int seq) {
		return dao.getBbs(seq);
	}

	@Override
	public boolean deleteBbs(int seq) {
		return dao.deleteBbs(seq);
	}

	@Override
	public boolean updateBbs(MainNoticeBbsDto bbs) {
		return dao.updateBbs(bbs);
	}

}
