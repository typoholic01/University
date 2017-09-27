package kh.com.servImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.MainBbsDao;
import kh.com.model.MainBbs;
import kh.com.model.Query;
import kh.com.serv.MainBbsService;

@Service
public class MainBbsServiceImpl implements MainBbsService {

	@Autowired
	MainBbsDao dao;
	
	@Override
	public boolean insertBbs(MainBbs dto) {
		return dao.insertBbs(dto);
	}

	@Override
	public MainBbs getBbs(int seq) {
		return dao.getBbs(seq);
	}

	@Override
	public List<MainBbs> getBbsList(Query query) {
		return dao.getBbsList(query);
	}

	@Override
	public int getTotalBbs(String boardName) {
		return dao.getTotalBbs(boardName);
	}

	@Override
	public boolean updateBbs(MainBbs bbs) {
		return dao.updateBbs(bbs);
	}

	@Override
	public boolean deleteBbs(int seq) {
		return dao.deleteBbs(seq);
	}

}
