package com.kh.app11.board.mapper;

import com.kh.app11.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Insert("""
            INSERT INTO BOARD
            (
                NO
                ,TITLE
                ,CONTENT
                ,WRITER_NO
            )
            VALUES
            (
                SEQ_BOARD.NEXTVAL
                , #{title}
                , #{content}
                , #{writerNo}
            )
            """)
    int insert(BoardVo vo);

    @Select("""
            SELECT
                NO
                ,TITLE
                ,CONTENT
                ,WRITER_NO
                ,CREATED_DATE
                ,HIT
                ,DEL_YN
            FROM BOARD
            WHERE DEL_YN = 'N'
            ORDER BY NO DESC
            """)
    List<BoardVo> list();

    @Select("""
            SELECT
                NO
                ,TITLE
                ,CONTENT
                ,WRITER_NO
                ,CREATED_DATE
                ,HIT
                ,DEL_YN
            FROM BOARD
            WHERE NO = #{no}
            AND DEL_YN = 'N'
            """)
    BoardVo selectOne(String no);

    @Update("UPDATE BOARD SET HIT = HIT+1 WHERE NO=#{no} AND DEL_YN = 'N'")

    int increaseHit(String no);

    @Update("""
            UPDATE BOARD SET
                TITLE = #{title}
                , CONTENT = #{content}
            WHERE NO = #{no}
            AND DEL_YN = 'N'
            """)
    int update(BoardVo vo);

    @Delete("""
            UPDATE BOARD SET DEL_YN = 'Y' WHERE NO = #{no}
            """)
    int delete(String no);
}
