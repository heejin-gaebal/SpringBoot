package com.kh.app12.board.api;

import com.kh.app12.board.service.BoardService;
import com.kh.app12.board.vo.BoardVo;
import com.kh.app12.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService boardService;

    /*insert*/
    @PostMapping
    public Map<String, Object> insert(@RequestBody BoardVo vo, HttpSession session){
        MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
        vo.setWriterNo(loginMember.getNo());
        int result = boardService.insert(vo);
        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        map.put("status", "insert OK");

        return map;
    }

    /*list*/
    @GetMapping
    public Map<String, Object> list(){
        List<BoardVo> voList = boardService.list();
        Map<String, Object> map = new HashMap<>();
        map.put("data", voList);
        map.put("status", "list OK");

        return map;
    }

    /*selectOne*/
    @GetMapping("{no}")
    public Map<String, Object> selectOne(@PathVariable String no){
        BoardVo vo = boardService.selectOne(no);
        Map<String, Object> map = new HashMap<>();
        map.put("data", vo);
        map.put("status", "selectOne OK");

        return map;
    }

    /*update*/
    @PutMapping
    public Map<String, Object> update(@RequestBody BoardVo vo){
        int result = boardService.update(vo);
        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        map.put("status", "update OK");

        return map;
    }

    /*delete*/
    @DeleteMapping
    public Map<String, Object> delete(@RequestBody BoardVo vo){
        int result = boardService.delete(vo);
        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        map.put("status", "delete OK");

        return map;
    }
}
