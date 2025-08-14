package com.kh.app22.notice.controller;

import com.kh.app22.notice.entity.NoticeEntity;
import com.kh.app22.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/notice")
@RequiredArgsConstructor
public class NoticeApiController {
    private final NoticeService service;

    @PostMapping
    public void insert(@RequestBody NoticeEntity entity){
        service.insert(entity);
    }

    @GetMapping
    public List<NoticeEntity> getNoticeAll(){
        return service.getNoticeAll();
    }

    @GetMapping("{no}")
    public NoticeEntity getNoticeByNo(@PathVariable Long no){
        return service.getNoticeByNo(no);
    }
}
