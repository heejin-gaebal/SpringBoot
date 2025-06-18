package com.kh.app10.board.controller;

import com.kh.app10.board.service.BoardService;
import com.kh.app10.board.vo.BoardVo;
import com.kh.app10.common.page.PageVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService boardService;
    
    /*게시글 작성*/
    @PostMapping
    public int insert(@RequestBody BoardVo vo){
        return boardService.insert(vo);
    }

    /*게시글 목록조회*/
    @GetMapping                             //@RequestParam(required = false) int필수값이 아님을 뜻함
                                            //defaultValue 기본값을 설정 [1페이지, 2페이지 ...]
    public Map<String, Object> list(@RequestParam(required = false, defaultValue = "1") int pno){
        System.out.println("pno = " + pno);
        int listCount = boardService.getCount();
        int currentPage = pno;
        int pageLimit = 5;
        int boardLimit = 10;
        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
        //Vo에서 만든 생성자 파라미터에 맞춰서 표출 순서 중요

        List<BoardVo> voList = boardService.list(pvo);
        Map<String, Object> map = new HashMap<String, Object>();
        //  String, Object 한꺼번에 넘기기위해 
        //    키  :  값 
        // HashMap과 Map의 관계 -> List와 ArrayList의 비슷한 관계
        map.put("pvo", pvo);
        map.put("voList", voList);

        return map;
    }

    /*게시글 상세조회*/
    @GetMapping("{no}")
    public BoardVo selectOne(@PathVariable String no){
        return boardService.selectOne(no);
    }
}
