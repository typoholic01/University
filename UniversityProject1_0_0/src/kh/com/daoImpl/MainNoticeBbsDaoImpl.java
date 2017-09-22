package kh.com.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.MainNoticeBbsDao;
import kh.com.model.MainNoticeBbsDto;

@Repository
public class MainNoticeBbsDaoImpl implements MainNoticeBbsDao {
	private final String ns = "MainNoticeBbs.";
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<MainNoticeBbsDto> getBbsList() {
		return sqlSession.selectList(ns+"getBbsList");
	}

	@Override
	public boolean insertBbs(MainNoticeBbsDto dto) {
		
		return sqlSession.insert(ns + "insertBbs", dto) > 0 ? true:false;
		
	}	
}