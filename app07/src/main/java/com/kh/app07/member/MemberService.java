package com.kh.app07.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;

    public int join(MemberVo vo) {

        //dao => sql
        return memberMapper.join(vo);
    }

    public MemberVo login(MemberVo vo) {
        return memberMapper.login(vo);
    }

    public int quit(MemberVo loginMember) {
        return memberMapper.quit(loginMember);
    }

    public int edit(MemberVo vo) {
        return memberMapper.edit(vo);
    }
}
