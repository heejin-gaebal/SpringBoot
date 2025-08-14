package com.kh.app21.notice.controller;

import com.kh.app21.notice.service.NoticeService;
import com.kh.app21.notice.vo.NoticeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/notice")
@RequiredArgsConstructor
@CrossOrigin
public class NoticeApiController {
    private final NoticeService service;

    //insert
    @PostMapping
    public void insert(@RequestBody NoticeVo vo){
        service.insert(vo);
    }

    //select All
    @GetMapping
    public List<NoticeVo> getNoticeAll(){
        return service.getNoticeAll();
    }

    //select One
    @GetMapping("{no}")
    public NoticeVo getNoticeByNo(@PathVariable Long no){
        return service.getNoticeByNo(no);
    }
}
