package kh.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.LoginDao;
import kh.com.model.MemberDto;
import kh.com.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao logindao;

	@Override
	public MemberDto login(MemberDto dto) throws Exception {
		return logindao.login(dto);
	}

	@Override
	public void addMember(MemberDto dto) throws Exception {
		 if(dto.getUser_auth().equals("100")) {
			 logindao.addMember(dto);
			 logindao.addMember_student(dto);
		 }else if(dto.getUser_auth().equals("200")){
			 logindao.addMember(dto);
			 logindao.addMember_prof(dto);
		 }else if(dto.getUser_auth().equals("300")){
			 logindao.addMember(dto);
			 logindao.addMember_admin(dto);;
		 }
		 else {
			 logindao.addMember(dto);
		 }
	}

	@Override
	public String findid(MemberDto dto) throws Exception {
		return logindao.findid(dto);
	}

	@Override
	public MemberDto findpw(MemberDto dto) throws Exception {
		return logindao.findpw(dto);
	}
	
	
	
	
	
	
	

}
