package com.kh.app22.board.service;

import com.kh.app22.board.entity.BoardEntity;
import com.kh.app22.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository repository;

    public void insert(BoardEntity entity) {
        repository.insert(entity);
    }
}
