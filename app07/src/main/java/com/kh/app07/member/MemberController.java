package com.kh.app07.member;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    /*회원가입*/
    @GetMapping("join")
    public void join(){}

    /*마이페이지*/
    @GetMapping("mypage")
    public String mypage(HttpSession session){
    MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
        if(loginMember != null){
            return "member/mypage";
        }else{
            return "member/login";
        }
    }

    /*로그인*/
    @GetMapping("login")
    public void login(){}

/*----------------------------------------------------------------------*/

    /*회원가입 기능 구현*/
    @PostMapping("join")
    public String join(MemberVo vo){
        //service
        int result = memberService.join(vo);

        if(result != 1){
            throw new IllegalStateException("[MEMBER-001] 회원가입 문제 발생!! 꺅>.<");
            /*예외던지는 것도 DS가 처리해줌*/
        }

        //result
        return "redirect:/member/login";
    }

    @PostMapping("login")
    public String login(MemberVo vo, HttpSession session){
        MemberVo loginMember = memberService.login(vo);
        if(loginMember == null){
            session.setAttribute("alertMsg","Login Fail!!");
        }else {
            /* 세션에 데이터 담기 */
            session.setAttribute("loginMember", loginMember);
        }
        return "redirect:/home";
    }

    @GetMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        /* 세션 만료시키기 */
        return "redirect:/home";
    }

    @GetMapping("quit")
    public String quit(HttpSession session){
        MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
        int result = memberService.quit(loginMember);
        if(result != 1){
           throw new IllegalStateException("[MEMBER-002] QUIT ERROR");
        }
        session.invalidate();
        return "redirect:/home";
    }

    @PostMapping("edit")
    public String edit(MemberVo vo, HttpSession session){
        MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
        String no = loginMember.getNo();
        vo.setNo(no);
        int result = memberService.edit(vo);
        if(result != 1){
            throw new IllegalStateException("[MEMBER-003] edit Fail!!");
        }
        session.invalidate();
        return "redirect:/member/login";
    }
}
