package com.kh.app21.member.repository;

import com.kh.app21.member.vo.MemberVo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberRepository {
    private Long seq = 1L;
    private final List<MemberVo>  voList = new ArrayList<>();

    public void join(MemberVo vo) {
        vo.setNo(seq++);
        voList.add(vo);
        System.out.println("방금 회원가입한 계정" + vo);
    }

    public MemberVo login(MemberVo vo) {
        System.out.println("로그인 시도 계정" + vo);
        for (MemberVo elem : voList) {
            if(elem.getUserId().equals(vo.getUserId())&&elem.getUserPwd().equals(vo.getUserPwd())){
                return elem;
            }
        }
        return null;
    }
}
