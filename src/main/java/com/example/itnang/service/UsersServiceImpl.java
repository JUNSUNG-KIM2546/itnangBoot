package com.example.itnang.service;

import java.util.List;

import com.example.itnang.dao.UsersDao;
import com.example.itnang.entity.UsersEntity;
import com.example.itnang.pager.Pager;
import com.example.itnang.vo.UsersVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsersServiceImpl {
	
	@Autowired
	UsersDao usersdao;


	public void signUp(UsersVO uservo) {
		UsersEntity usersEntity = UsersEntity.toUsersEntity(uservo);
		usersdao.save(usersEntity);
	}
}
