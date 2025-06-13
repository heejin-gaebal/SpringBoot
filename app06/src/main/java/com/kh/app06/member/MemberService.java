
package com.kh.app06.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;

    public int join(MemberVo vo) {
        //SQL Mapper
        int result = memberMapper.join(vo);
        System.out.println("result :" + result);

        return result;
    }

    public List<MemberVo> findMemberList() {
        return memberMapper.findMemberList();
    }
}
