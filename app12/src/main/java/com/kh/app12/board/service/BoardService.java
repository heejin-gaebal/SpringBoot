package com.kh.app12.board.service;

import com.kh.app12.board.mapper.BoardMapper;
import com.kh.app12.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public int insert(BoardVo vo) {
        return boardMapper.insert(vo);
    }

    public List<BoardVo> list() {
        return boardMapper.list();
    }

    public BoardVo selectOne(String no) {
        return boardMapper.selectOne(no);
    }

    public int update(BoardVo vo) {
        return boardMapper.update(vo);
    }

    public int delete(BoardVo vo) {
        return boardMapper.delete(vo);
    }
}
