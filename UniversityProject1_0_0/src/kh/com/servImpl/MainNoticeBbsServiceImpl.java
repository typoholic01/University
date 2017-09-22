package kh.com.servImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.MainNoticeBbsDao;
import kh.com.serv.MainNoticeBbsService;

@Service
public class MainNoticeBbsServiceImpl implements MainNoticeBbsService {
	
	@Autowired
	MainNoticeBbsDao dao;

}
