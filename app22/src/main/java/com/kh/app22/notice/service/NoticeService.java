package com.kh.app22.notice.service;

import com.kh.app22.notice.entity.NoticeEntity;
import com.kh.app22.notice.repository.NoticeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository repository;

    public void insert(NoticeEntity entity) {
        repository.insert(entity);
    }

    public List<NoticeEntity> getNoticeAll() {
        return repository.getNoticeAll();
    }

    public NoticeEntity getNoticeByNo(Long no) {
        return repository.getNoticeByNo(no);
    }
}
