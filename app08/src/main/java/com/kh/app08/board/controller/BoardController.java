package com.kh.app08.board.controller;

import com.kh.app08.board.service.BoardService;
import com.kh.app08.board.vo.BoardVo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("board")
public class BoardController {
    /*
        @AllArgsConstructor는 모든 생성자 처음부터 연결되지만 재할당이 가능
        => 다른 private도 처음부터 추가되므로 사용 ㄴㄴ
        재할당 예정 없으므로 final 추가 => @RequiredArgsConstructor 사용
        필드 인젝션은 추천 ㄴㄴ
    */
    /**
     * 게시글 작성 (화면)
     */
    @GetMapping("insert")
    public void insert(){}

    /**
     * 게시글 목록 (화면)
     */
    @GetMapping("list")
    public void list(){}
}
