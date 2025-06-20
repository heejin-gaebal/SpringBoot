package com.kh.app12.member.service;

import com.kh.app12.board.mapper.BoardMapper;
import com.kh.app12.member.mapper.MemberMapper;
import com.kh.app12.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;

    public int join(MemberVo vo) {
        return memberMapper.join(vo);
    }

    public MemberVo login(MemberVo vo) {
        return memberMapper.login(vo);
    }

    public List<MemberVo> selectList() {
        return memberMapper.selectList();
    }

//    public int edit(MemberVo vo) {
//        return memberMapper.edit(vo);
//    }

    public Map<String, Object> edit(MemberVo vo) {
        // 트랜잭션 : 한 작업에 여러쿼리문 실행
        int result = memberMapper.edit(vo); // 수정하기 위한 쿼리
        MemberVo loginVo = memberMapper.editVo(vo); // 수정된 멤버객체

        Map<String, Object> map = new HashMap<>();
        map.put("result" , result);
        map.put("loginVo" , loginVo);
        return map;
    }

    public int quit(MemberVo vo) {
        return memberMapper.quit(vo);
    }
}
