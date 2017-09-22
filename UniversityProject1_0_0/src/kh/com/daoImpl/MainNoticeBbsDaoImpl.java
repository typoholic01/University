package kh.com.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.MainNoticeBbsDao;
import kh.com.dto.MainNoticeBbsDto;

@Repository
public class MainNoticeBbsDaoImpl implements MainNoticeBbsDao {
	private final String ns = "MainNoticeBbs.";
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<MainNoticeBbsDto> getBbsList() {
		return sqlSession.selectList(ns+"getBbsList");
	}
	
	

}