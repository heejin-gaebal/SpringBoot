package com.kh.app06.member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {
    //인터페이스는 무조건 추상메서드이므로 접근제한자나 리턴값 필요없음!
    @Insert("""
            INSERT INTO MEMBER
            (
                NO
                ,USER_ID
                ,USER_PWD
                ,USER_NICK
            )
            VALUES
            (
                SEQ_MEMBER.NEXTVAL
                , #{userId}
                , #{userPwd}
                , #{userNick}
            )
            """)
    int join(MemberVo vo);

//            DAO class > method : sql연결 [xml]
//     MAPPER interface > method : sql연결 [@annotation]

    @Select("""
            SELECT *
            FROM MEMBER
            WHERE DEL_yn = 'N'
            ORDER BY NO DESC
            """)
    List<MemberVo> findMemberList();
}
