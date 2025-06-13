package com.kh.app03.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
    
    //목록조회 (화면 + 로직)
    @RequestMapping("/board/list")
    public void m01(){
        System.out.println("게시글 목록 조회!");
    }

    //작성하기 (화면 get)
//    @RequestMapping(value = "/board/write", method = RequestMethod.GET)
    @GetMapping("/board/write")
    public void m02(){
        System.out.println("게시글 작성하기 화면!");
    }

    //작성하기 (로직 post)
//    @RequestMapping(value = "/board/write", method = RequestMethod.POST)
    @PostMapping("/board/write")
    public void m03(){
        System.out.println("게시글 작성하기 로직!");
    }
}
