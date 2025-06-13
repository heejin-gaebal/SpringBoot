package com.kh.app06.member;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("member")

public class MemberController {

    /*변수 설정해주면 스프링이 객체 생성*/
    /*결합도를 낮추기 위함*/
    @Autowired
    private MemberService memberService;

    @GetMapping("join")
    public String join(){
        return "member/join";
    }

    @PostMapping("join")
    public String join(MemberVo vo){
        //service
        int result = memberService.join(vo);

        //result
        return "redirect:/home";
    }

    @GetMapping("list")
    public String memberList(Model model){
        List<MemberVo> voList = memberService.findMemberList();
        model.addAttribute("voList", voList);
        return "member/list";
    }
}
