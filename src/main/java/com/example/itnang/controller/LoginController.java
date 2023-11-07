package com.example.itnang.controller;

import com.example.itnang.service.LoginServiceImpl;
import com.example.itnang.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class LoginController {

    // 생성자 주입
    @Autowired
    LoginServiceImpl loginServiceImpl;

    final String home = "home/";

    // 로그인 페이지
    @GetMapping("/login")
    public String Login() {
        return home +"Login.html";
    }

    // 회원가입 페이지
    @GetMapping("/signup")
    public String signUp() {
        return home +"signUp.html";
    }
    @PostMapping("/signup")
    public String signUp(LoginVO uservo) {
        loginServiceImpl.signUp(uservo);
        return "redirect:/hello";
    }
}
