package com.kh.app08.board.service;

import com.kh.app08.board.mapper.BoardMapper;
import com.kh.app08.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
}
