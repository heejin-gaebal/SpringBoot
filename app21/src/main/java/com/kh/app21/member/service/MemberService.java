package com.kh.app21.member.service;

import com.kh.app21.member.repository.MemberRepository;
import com.kh.app21.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository repository;

    public void join(MemberVo vo) {
        repository.join(vo);
    }

    public MemberVo login(MemberVo vo) {
        return repository.login(vo);
    }
}
