package com.ssafy.happyhouse.dao;


import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.dto.BoardFileDto;
import com.ssafy.happyhouse.dto.BoardParamDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardDao {

    @Select("SELECT b.BOARD_ID as boardId, b.USER_SEQ as userSeq, u.USER_NAME as userName, " +
            "b.TITLE as title, b.CONTENT as content, b.REG_DT as regDt, b.READ_COUNT as readCount " +
            "FROM BOARD b, USER u " +
            "WHERE b.USER_SEQ = u.USER_SEQ " +
            "ORDER BY b.BOARD_ID DESC " +
            "LIMIT #{BoardParamDto.limit} OFFSET #{BoardParamDto.offset}")
    List<BoardDto> boardList(@Param("BoardParamDto") BoardParamDto boardParamDto);

    @Select("SELECT COUNT(*) FROM BOARD")
    int boardListTotalCount();

    @Select("SELECT b.BOARD_ID as boardId, b.USER_SEQ as userSeq, u.USER_NAME as userName, " +
            "b.TITLE as title, b.CONTENT as content, b.REG_DT as regDt, b.READ_COUNT as readCount " +
            " FROM BOARD b, USER u " +
            " WHERE b.USER_SEQ = u.USER_SEQ " +
            " AND b.TITLE LIKE CONCAT('%', #{boardParamDto.searchWord}, '%') " +
            " ORDER BY b.BOARD_ID DESC " +
            " LIMIT #{boardParamDto.limit} OFFSET #{boardParamDto.offset}")
    List<BoardDto> boardListSearchWord(@Param("BoardParamDto") BoardParamDto boardParamDto);

    @Select("SELECT COUNT(*) " +
            "FROM BOARD " +
            "WHERE TITLE LIKE CONCAT('%', #{searchWord}, '%')")
    int boardListSearchWordTotalCount(@Param("searchWord") String searchWord);

    @Insert("INSERT INTO BOARD ( USER_SEQ, TITLE, CONTENT, REG_DT, READ_COUNT )" +
            "VALUES ( #{boardDto.userSeq}, #{boardDto.title}, #{boardDto.content}, now(), 0)")
	@Options(useGeneratedKeys = true, keyProperty = "boardDto.boardId")
    void boardInsert(@Param("boardDto") BoardDto boardDto);

    @Insert("INSERT INTO BOARD_FILE ( BOARD_ID, FILE_NAME, FILE_SIZE, FILE_CONTENT_TYPE, FILE_URL )" +
            "VALUES ( #{boardFileDto.boardId}, #{boardFileDto.fileName}, #{boardFileDto.fileSize}, #{boardFileDto.fileContentType}, #{boardFileDto.fileUrl} )")
    void boardFileInsert(@Param("boardFileDto") BoardFileDto boardFileDto);

    @Select("SELECT * FROM BOARD WHERE BOARD_ID = #{boardId}")
    BoardDto findByBoardId(@Param("boardId") int boardId);

    @Select("SELECT * FROM BOARD_FILE WHERE BOARD_ID = #{boardId}")
    List<BoardFileDto> findByBoardFileId(@Param("boardId") int boardId);

    @Delete("DELETE FROM BOARD WHERE BOARD_ID = #{boardId}")
    void boardDelete(@Param("boardId")  int boardId);

    @Update("UPDATE BOARD " +
            "SET TITLE = #{boardDto.title}, CONTENT = #{boardDto.content} WHERE BOARD_ID = #{boardDto.boardId}")
    void boardUpdate(@Param("boardDto") BoardDto boardDto);


    @Delete("DELETE FROM BOARD_FILE WHERE BOARD_ID = #{boardId} ")
    void boardFileDelete(@Param("boardId")  int boardId);

    @Delete(" SELECT FILE_URL as fileUrl FROM BOARD_FILE WHERE BOARD_ID = #{boardId} ")
    List<String> boardFileUrlDeleteList(@Param("boardId")  int boardId);


}
