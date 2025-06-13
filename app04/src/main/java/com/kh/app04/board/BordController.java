package com.kh.app04.board;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BordController {

    @GetMapping("/board/list")
    public String list(){
        return "/board/list";

    }

    @GetMapping("/board/insert")
    public void insert01(){

    }

    @PostMapping("/board/insert")
    public String insert02(BoardVo vo){
        /*파라미터에 아예 Vo를 넣어서 부를 수 있음
        * Spring 이라 이 형태가 사용가능한 것이고, Servlet 에서는 사용불가
        * */
        //data
//        String title = req.getParameter("title");
//        String content = req.getParameter("content");

//        BoardVo vo = new BoardVo();
//        vo.setTitle(title);
//        vo.setContent(content);

        //service
        System.out.println("vo : " + vo);

        //result
        return "redirect:/board/list";
    }
}
