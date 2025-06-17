package com.kh.app08_1.board.service;

import com.kh.app08_1.board.mapper.BoardMapper;
import com.kh.app08_1.board.vo.BoardVo;
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

    public List<BoardVo> list() {
        return boardMapper.list();
    }

    public BoardVo selectOne(String no) {
        return boardMapper.selectOne(no);
    }

    public int update(String no, BoardVo vo) {
        return boardMapper.update(no, vo);
    }

    public int delete(String no) {
        return boardMapper.delete(no);
    }

}
