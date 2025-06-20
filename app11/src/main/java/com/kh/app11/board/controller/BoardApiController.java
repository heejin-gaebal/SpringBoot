package com.kh.app11.board.controller;

import com.kh.app11.board.service.BoardService;
import com.kh.app11.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService boardService;

    //insert
    @PostMapping
    public Map<String, String> insert(@RequestBody BoardVo vo){
        vo.setWriterNo("1");
        int result = boardService.insert(vo);
        Map<String, String> map = new HashMap<String, String>(); //객체->JSON
        map.put("data", result + "");
        map.put("status", "Insert success~~");
        return map;
    }

    //list
    @GetMapping
    public Map<String, Object> list(){
        List<BoardVo> volist = boardService.list();
        Map<String, Object> map = new HashMap<>();
        map.put("data", volist);
        map.put("status", "good!!");
        return map;
    }

    //selectOne
    @GetMapping("{no}")
    public Map<String, Object> selectOne(@PathVariable String no){
        BoardVo vo = boardService.selectOne(no);
        Map<String, Object> map = new HashMap<>();
        map.put("data", vo);
        map.put("status", "selectOne view");
        return map;
    }

    //update
    @PutMapping
    public Map<String, Object> update(@RequestBody BoardVo vo){
        int result = boardService.update(vo);
        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        map.put("status", "update success");
        return map;
    }

    //delete
    @DeleteMapping
    public Map<String, Object> delete(@RequestBody HashMap<String, String> reqmap){
        int result = boardService.delete(reqmap.get("no"));
        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        map.put("status", "delete success");
        return map;
    }
}
