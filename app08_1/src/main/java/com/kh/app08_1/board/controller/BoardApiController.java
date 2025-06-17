package com.kh.app08_1.board.controller;

import com.kh.app08_1.board.service.BoardService;
import com.kh.app08_1.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/board")
public class BoardApiController {
    private final BoardService boardService;

    /*insert*/
    @PostMapping
    public int insert(@RequestBody BoardVo vo){
        vo.setWriterNo("1");
        int result = boardService.insert(vo);
        return result;
    }

    /*list*/
    @GetMapping
    public List<BoardVo> list(){
        List<BoardVo> voList = boardService.list();
        return voList;
    }
    
    /*상세조회*/
    @GetMapping("{no}")
    public BoardVo selectOne(@PathVariable String no){
        BoardVo vo = boardService.selectOne(no);
        return vo;
    }
    
    /*수정*/
    @PutMapping("{no}")
    public int update(@PathVariable String no, @RequestBody BoardVo vo){
        return boardService.update(no, vo);
    }
    
    /*삭제*/
    @DeleteMapping("{no}")
    public int delete(@PathVariable String no){
        return boardService.delete(no);
    }
}
