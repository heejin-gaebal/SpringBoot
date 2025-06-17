package com.kh.app09.board.service;

import com.kh.app09.board.mapper.BoardMapper;
import com.kh.app09.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    //insert
    public int insert(BoardVo vo) {
        return boardMapper.insert(vo);
    }

    public List<BoardVo> list() {
        return boardMapper.list();
    }

    public BoardVo detail(String no) {
        return boardMapper.detail(no);
    }

    public int delete(String no) {
        return boardMapper.delete(no);
    }

    public int update(BoardVo vo) {
        return boardMapper.update(vo);
    }
}
