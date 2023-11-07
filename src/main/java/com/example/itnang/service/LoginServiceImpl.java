package com.example.itnang.service;

import com.example.itnang.dao.LoginDao;
import com.example.itnang.entity.LoginEntity;
import com.example.itnang.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl {
	
	@Autowired
	LoginDao logindao;


	public void signUp(LoginVO uservo) {
		LoginEntity loginEntity = LoginEntity.toUsersEntity(uservo);
		logindao.save(loginEntity);
	}
}
