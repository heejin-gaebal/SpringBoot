package com.kh.app21.notice.service;

import com.kh.app21.notice.repository.NoticeRepository;
import com.kh.app21.notice.vo.NoticeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository repository;

    public void insert(NoticeVo vo) {
        repository.insert(vo);
    }

    public List<NoticeVo> getNoticeAll() {
        return repository.getNoticeAll();
    }

    public NoticeVo getNoticeByNo(Long no) {
        NoticeVo vo = repository.getNoticeByNo(no);
        vo.setHit(vo.getHit()+1);
        return vo;
    }
}
