package com.kh.app22.board.controller;

import com.kh.app22.board.entity.BoardEntity;
import com.kh.app22.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService service;

    @PostMapping
    public void insert(@RequestBody BoardEntity entity){
        service.insert(entity);
    }
}
