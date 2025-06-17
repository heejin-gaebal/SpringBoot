package com.kh.app09.board.controller;

import com.kh.app09.board.service.BoardService;
import com.kh.app09.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //@Controller + @ResponseBody
@RequestMapping("api/board") //화면X 데이터만 응답
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService boardService;

    //insert
    @PostMapping        //JSON 형식으로 응답받을 것이므로 @RequestBody
    public int insert(@RequestBody BoardVo vo){
        vo.setWriterNo("1");
        //service
        int result = boardService.insert(vo);
        //result
        return result;
    }

    //selectList
    @GetMapping
    public List<BoardVo> list(){
        List<BoardVo> voList = boardService.list();
        return voList;
    }/*get방식이므로 바디의 내용은 무시가 된다*/

    //selectOne
    /* 경로변수 사용 - 경로에다가 변수 사용하는 것 */
    // 같은 경로의 Get방식이 있으므로 구분지어주기 위해 경로{x} 임의설정 하고, @PathVariable 어노테이션 달고 파라미터 담아준다
    // 파라미터에 담아준 변수명과 @PathVariable("no")의 변수가 같으면 ()는 생략가능
    @GetMapping("{no}")
    public BoardVo detail(@PathVariable("no") String no){
        BoardVo vo = boardService.detail(no);
        return vo;
    }

    //update
    @PutMapping("{no}")
    public int update(@RequestBody BoardVo vo, @PathVariable String no){
        vo.setNo(no);
        return boardService.update(vo);
    }

    //delete
    @DeleteMapping("{no}")
    public int delete(@PathVariable String no){
        return boardService.delete(no);
        //넘버 값 넘기면서 리턴
    }
}
