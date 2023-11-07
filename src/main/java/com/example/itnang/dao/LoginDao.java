package com.example.itnang.dao;

import com.example.itnang.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoginDao extends JpaRepository<LoginEntity, Long> {

}
