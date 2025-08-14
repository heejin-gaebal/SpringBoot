package com.kh.app21.notice.repository;

import com.kh.app21.notice.vo.NoticeVo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class NoticeRepository {
    private final List<NoticeVo> voList = new ArrayList<>();
    private Long seq = 1L;

    public void insert(NoticeVo vo) {
        vo.setNo(seq++);
        vo.setHit(0L);
        voList.add(vo);
    }

    public List<NoticeVo> getNoticeAll() {
        return voList;
    }

    public NoticeVo getNoticeByNo(Long no) {
        for(NoticeVo vo : voList){
            if(vo.getNo() == no){
                return vo;
            }
        }
        return null;

//        Optional<NoticeVo> result = voList.stream().filter((vo -> vo.getNo() == no).findFirst());
//        return result.get();
    }
}
