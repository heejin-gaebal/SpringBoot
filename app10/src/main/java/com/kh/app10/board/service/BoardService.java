package com.kh.app10.board.service;

import com.kh.app10.board.mapper.BoardMapper;
import com.kh.app10.board.vo.BoardVo;
import com.kh.app10.common.page.PageVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;
    public int insert(BoardVo vo) {
        return boardMapper.insert(vo);
    }

    public List<BoardVo> list(PageVo pvo) {
        return boardMapper.list(pvo);
    }

    public BoardVo selectOne(String no) {
        int result = boardMapper.increaseHit(no);
        if(result != 1){
            throw new IllegalStateException("조회수 증가 실패");
        }
        return boardMapper.selectOne(no);
    }

    public int getCount() {
        return boardMapper.getCount();
    }
}
