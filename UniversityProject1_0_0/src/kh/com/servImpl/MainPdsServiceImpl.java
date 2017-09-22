package kh.com.servImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.MainNoticeBbsDao;
import kh.com.serv.MainPdsService;

@Service
public class MainPdsServiceImpl implements MainPdsService {
	
	@Autowired
	MainNoticeBbsDao dao;
}
