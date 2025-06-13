package com.kh.app02.board;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.PrintWriter;

@Controller
public class BoardController {

    @RequestMapping("/board/insert")
    public void m01(){
        System.out.println("스프링 연습 / 게시글 작성!!");
    }

    @RequestMapping("/board/list")
    public void m02(){
        System.out.println("게시글 목록임미댜");
    }

    @RequestMapping("/")
    public void m03(){
        System.out.println("Home");
    }
    /* 매핑에 /를 빼먹어도 호출 잘 됨 */
    @RequestMapping("member/join")
    public void m04(){
        System.out.println("회원가입이쟈냐");
    }
    @RequestMapping("/member/login")
    public void m05(){
        System.out.println("로그인할꺼쟈냥");
    }

    @RequestMapping("notice/list")
    public void selectNoticeList(HttpServletResponse resp) throws Exception {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>공지사항 목록임댱</h1>");
    }

    /*@RequestMapping("gallery/list") [기존 방식]
    public void galleryList(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.getRequestDispatcher("/WEB-INF/views/gallery/list.jsp").forward(req, resp);
    }*/

    /*@RequestMapping("gallery/list")
    public String galleryList(){
        return "gallery/list";
    }*/

    @RequestMapping("gallery/list")
    public void galleryList(){
    }
}
