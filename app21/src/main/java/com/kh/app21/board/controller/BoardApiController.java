package com.kh.app21.board.controller;

import com.kh.app21.board.service.BoardService;
import com.kh.app21.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
@CrossOrigin(value = "*")
public class BoardApiController {
    private final BoardService service;

    //전체 게시글 조회
    @GetMapping
    public List<BoardVo> getBoardList(){
        return service.getBoardList();
    }

    //게시글 상세 조회(no)
    @GetMapping("{no}")
    public BoardVo getBoardByNo(@PathVariable Long no){
        return service.getBoardByNo(no);
    }

    //게시글 등록
    @PostMapping
    public void insertBoard(@RequestBody BoardVo vo){
        service.insertBoard(vo);
    }
}
