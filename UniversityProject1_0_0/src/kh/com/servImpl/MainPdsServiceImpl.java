package kh.com.servImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.MainPdsDao;
import kh.com.model.MainPdsDto;
import kh.com.serv.MainPdsService;
import kh.com.util.Pagination;

@Service
public class MainPdsServiceImpl implements MainPdsService {
	
	@Autowired
	MainPdsDao dao;

	@Override
	public boolean insertBbs(MainPdsDto dto) {
		return dao.insertBbs(dto);
	}

	@Override
	public MainPdsDto getBbs(int seq) {
		return dao.getBbs(seq);
	}

	@Override
	public List<MainPdsDto> getBbsList(Pagination pagination) {
		return dao.getBbsList(pagination);
	}

	@Override
	public int getTotalBbs() {
		return dao.getTotalBbs();
	}

	@Override
	public boolean updateBbs(MainPdsDto bbs) {
		return dao.updateBbs(bbs);
	}

	@Override
	public boolean deleteBbs(int seq) {
		return dao.deleteBbs(seq);
	}
}
