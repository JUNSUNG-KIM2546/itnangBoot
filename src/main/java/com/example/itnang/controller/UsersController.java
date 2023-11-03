package com.example.itnang.controller;

import com.example.itnang.dao.UsersDao;
import com.example.itnang.service.UsersServiceImpl;
import com.example.itnang.vo.UsersVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class UsersController {

    // 생성자 주입
    private final UsersServiceImpl usersServiceImpl;

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
    public String signUp(UsersVO uservo) {
        usersServiceImpl.signUp(uservo);
        return "redirect:/";
    }
}
