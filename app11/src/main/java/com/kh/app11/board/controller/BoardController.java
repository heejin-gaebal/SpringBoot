package com.kh.app11.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
public class BoardController {
    @GetMapping("insert")
    public void insert(){};

    @GetMapping("list")
    public void list(){};

    @GetMapping("detail/*")
    public String detail(){
        return "board/detail";
    };
}
