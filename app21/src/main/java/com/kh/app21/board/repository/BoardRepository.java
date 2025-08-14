package com.kh.app21.board.repository;

import com.kh.app21.board.vo.BoardVo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardRepository {
    //vo를 메모리에 저장
    private final List<BoardVo> voList = new ArrayList<>();
    private Long seq = 1L;

    public List<BoardVo> getBoardList() {
        return voList;
    }

    public BoardVo getBoardByNo(Long no) {
//        Optional<BoardVo> result = voList.stream().filter(vo -> vo.getNo().equals(no)).findFirst();
//        return result.get();
        
        // vo 중에 no 값이 맞는것을 return 해준다
        for (BoardVo vo : voList){
            if(vo.getNo() == no){
                return vo;
            }
        }
        return null;
    }

    public void insertBoard(BoardVo vo) {
        vo.setNo(seq++);
        vo.setHit(0L);
        voList.add(vo);
    }
}
/*
    stream() : 배열같은 애
    자바에서는 함수대신 객체를 넣는다
    함수 넣으려면 ()->{} 이렇게 표현
    
    filter는 true/false를 리턴
*/