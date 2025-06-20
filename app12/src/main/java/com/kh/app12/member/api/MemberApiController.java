package com.kh.app12.member.api;

import com.kh.app12.member.service.MemberService;
import com.kh.app12.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberService;

    //join
    @PostMapping("join")
    public Map<String, Object> join(@RequestBody MemberVo vo){
        int result = memberService.join(vo);
        Map<String, Object> map = new HashMap<>();
        map.put("data",result);
        map.put("status", "join ok");

        return map;
    }

    //login
    @PostMapping("login")
    public Map<String, Object> login(@RequestBody MemberVo vo, HttpSession session){
        MemberVo loginMember = memberService.login(vo);
        session.setAttribute("loginMember", loginMember);

        Map<String, Object> map = new HashMap<>();
        map.put("data",loginMember);
        map.put("status", "login ok");

        return map;
    }

    //selectList
    @GetMapping
    public Map<String, Object> selectList(){
        List<MemberVo> voList = memberService.selectList();
        Map<String, Object> map = new HashMap<>();
        map.put("data",voList);
        map.put("status", "selectList ok");

        return map;
    }

    //edit
    @PutMapping
    public Map<String, Object> edit(@RequestBody MemberVo vo, HttpSession session){
        MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");//이전세션데이터
        vo.setNo(loginMember.getNo());

        Map<String, Object> updateMap = memberService.edit(vo);
        Map<String, Object> map = new HashMap<>();
        map.put("data",updateMap.get("result"));
        map.put("status", "edit ok");

        session.setAttribute("loginMember" , updateMap.get("loginVo"));

        return map;
    }

    //quit
    @DeleteMapping
    public Map<String, Object> quit(@RequestBody MemberVo vo, HttpSession session){
        MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
        vo.setNo(loginMember.getNo());
        // no값을 받아오기위해 세션이 필요
        int result = memberService.quit(vo);

        Map<String, Object> map = new HashMap<>();
        map.put("data",result);
        map.put("status", "quit ok");

        return map;
    }
}
