package kh.com.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.MainPdsDao;
import kh.com.model.MainPdsDto;
import kh.com.util.Pagination;

@Repository
public class MainPdsDaoImpl implements MainPdsDao {
	private final String ns = "MainPdsDao.";

	@Autowired
	SqlSession sqlSession;

	@Override
	public boolean insertBbs(MainPdsDto dto) {
		return sqlSession.insert(ns + "insertBbs",dto) > 0 ? true:false;
	}

	@Override
	public MainPdsDto getBbs(int seq) {
		return sqlSession.selectOne(ns+"getBbs",seq);
	}

	@Override
	public List<MainPdsDto> getBbsList(Pagination pagination) {
		return sqlSession.selectList(ns+"getBbsList",pagination);
	}

	@Override
	public int getTotalBbs() {
		return sqlSession.selectOne(ns+"getTotalBbs");
	}

	@Override
	public boolean updateBbs(MainPdsDto bbs) {
		return sqlSession.update(ns + "updateBbs", bbs) > 0 ? true:false;
	}

	@Override
	public boolean deleteBbs(int seq) {
		return sqlSession.update(ns + "deleteBbs", seq) > 0 ? true:false;
	}
}
