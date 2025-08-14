package com.kh.app21.board.service;

import com.kh.app21.board.repository.BoardRepository;
import com.kh.app21.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository repository;

    public List<BoardVo> getBoardList() {
        return repository.getBoardList();
    }

    public BoardVo getBoardByNo(Long no) {
        BoardVo vo = repository.getBoardByNo(no);
        vo.setHit(vo.getHit()+1);
        return vo;
    }

    public void insertBoard(BoardVo vo) {
        repository.insertBoard(vo);
    }
}
