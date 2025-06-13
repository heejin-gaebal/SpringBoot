package com.kh.app07.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* @Component class -> bean
* 스프링이 BoardService를 객체로 만들고 bean 으로 등록하게 함
* @Autowired class <-> class
* 결합도를 낮추기 위해 스프링이 컨트롤러와 자동연결하게 함
* 해당 필드의 타입에 맞는 bean 을 spring container 에서 찾고, 할당해줌
* */
@Service
public class BoardService {
    @Autowired
    private BoardMapper boardMapper;
    
    /*게시글 작성*/
    public int insert(BoardVo vo){
        return boardMapper.insert(vo);
    }

    public List<BoardVo> getBoardList() {
        return boardMapper.getBoardList();
    }
}
