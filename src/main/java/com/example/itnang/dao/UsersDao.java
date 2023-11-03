package com.example.itnang.dao;

import com.example.itnang.entity.UsersEntity;
import com.example.itnang.pager.Pager;
import com.example.itnang.vo.UsersVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsersDao extends JpaRepository<UsersEntity, Long> {

}
