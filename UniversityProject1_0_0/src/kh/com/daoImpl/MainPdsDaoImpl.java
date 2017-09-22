package kh.com.daoImpl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.MainPdsDao;

@Repository
public class MainPdsDaoImpl implements MainPdsDao {
	private final String ns = "MainPdsDao.";

	@Autowired
	SqlSession sqlSession;
}
