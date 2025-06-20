package com.kh.app11.board.service;

import com.kh.app11.board.mapper.BoardMapper;
import com.kh.app11.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional // 서비스메서드에서 필요. 트랜잭션의 커밋|롤백 등
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
        int result = boardMapper.increaseHit(no);
        if(result != 1){
            throw new IllegalStateException("error-01 : 조회수 증가 실패");
        }
        return boardMapper.selectOne(no);
    }

    public int update(BoardVo vo) {
        return boardMapper.update(vo);
    }

    public int delete(String no) {
        return boardMapper.delete(no);
    }
}
