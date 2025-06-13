package com.kh.app05.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member") /*도메인 하나로 묶어줄 수 있음!!*/
public class MemberController {

    @GetMapping("join")
    public void join(){

    }

    @PostMapping("join")
    public void join(MemberVo vo){
        System.out.println("vo = " + vo);
    }
}
