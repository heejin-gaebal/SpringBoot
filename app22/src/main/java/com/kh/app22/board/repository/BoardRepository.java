package com.kh.app22.board.repository;

import com.kh.app22.board.entity.BoardEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final EntityManager em;

    //entity 매니저한테 엔티티 전달
    public void insert(BoardEntity entity) {
        em.persist(entity);
        //entity 매니저에게 엔티티 저장하기
    }
}
