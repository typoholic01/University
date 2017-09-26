package kh.com.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.MainNoticeBbsDao;
import kh.com.model.MainNoticeBbsDto;
import kh.com.util.Pagination;

@Repository
public class MainNoticeBbsDaoImpl implements MainNoticeBbsDao {
	private static final Logger logger = LoggerFactory.getLogger(MainNoticeBbsDaoImpl.class);
	private final String ns = "MainNoticeBbs.";
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<MainNoticeBbsDto> getBbsList(Pagination pagination) {
		logger.info("getBbsList");
		logger.info(pagination.toString());
		
		return sqlSession.selectList(ns+"getBbsList",pagination);
	}

	@Override
	public boolean insertBbs(MainNoticeBbsDto dto) {
		
		return sqlSession.insert(ns + "insertBbs", dto) > 0 ? true:false;
		
	}

	@Override
	public int getTotalArticle() {
		return sqlSession.selectOne(ns+"getTotalArticle");
	}

	@Override
	public MainNoticeBbsDto getBbs(int noticeBbsSeq) {
		return sqlSession.selectOne(ns+"getBbs",noticeBbsSeq);
	}

	@Override
	public boolean deleteArticle(int seq) {
		return sqlSession.update(ns + "deleteArticle", seq) > 0 ? true:false;
	}

	@Override
	public boolean updateArticle(MainNoticeBbsDto bbs) {
		return sqlSession.update(ns + "updateArticle", bbs) > 0 ? true:false;
	}	
}