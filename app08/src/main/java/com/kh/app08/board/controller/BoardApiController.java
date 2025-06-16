package com.kh.app08.board.controller;

import com.kh.app08.board.service.BoardService;
import com.kh.app08.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller + @ResponseBody
@RequestMapping("api/board")
@RequiredArgsConstructor /* Dependency Injection - 생성자 Injection AJAX 사용위함*/
//@ResponseBody : Json 형식으로 리턴 값을 문자열 그대로 "응답"한다
// 메서드에서도 적용가능하고 클래스에서도 적용가능하다
public class BoardApiController {
    private final BoardService boardService;

    /**
     * 게시글 작성 기능
     */
    @PostMapping("insert")
    //@RequestBody 패킷바디의 데이터 "요청"을 Json 형식으로 str 문자열로 그대로 가져옴
    public int insert(@RequestBody BoardVo vo){
        vo.setWriterNo("3");
        int result = boardService.insert(vo);
        return result;
        //fetch에서 option객체 활용 / 서버에서 데이터 받기
    }

    /**
     * 게시글 목록
     */
    @GetMapping("list")
    public List<BoardVo> list(){
        /*Jackson lib 이미 갖고있음 - vo-> json  */
        List<BoardVo> voList = boardService.list();
        return voList;
    }
}
