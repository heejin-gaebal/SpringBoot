package com.kh.app09.board.mapper;

import com.kh.app09.board.vo.BoardVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BoardMapper {
    //insert
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

    //리스트
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

    //상세조회
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
    BoardVo detail(String no);

    @Update("""
            UPDATE BOARD
            SET
                DEL_YN = 'Y'
            WHERE NO = #{no}
            """)
    int delete(String no);

    @Update("""
            UPDATE BOARD
                SET
                    TITLE = #{title}
                    , CONTENT = #{content}
                WHERE NO = #{no}
                AND DEL_YN = 'N'
            """)
    int update(BoardVo vo);
}
