package com.kh.app21.member.controller;

import com.kh.app21.member.service.MemberService;
import com.kh.app21.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
@CrossOrigin
public class MemberApiController {
    private final MemberService service;

    @PostMapping("join")
    public void join(@RequestBody MemberVo vo){
        service.join(vo);
    }

    @PostMapping("login")
    public MemberVo login(@RequestBody MemberVo vo){
        return service.login(vo);
    }
}
