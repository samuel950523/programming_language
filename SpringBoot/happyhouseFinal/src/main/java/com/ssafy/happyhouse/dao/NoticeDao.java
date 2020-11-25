package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ssafy.happyhouse.dto.Notice;

@Mapper
public interface NoticeDao {
	
	@Insert("INSERT INTO notice ( title, content , createtime  )" +
            "VALUES ( #{notice.title} , #{notice.content}, #{notice.createtime} )")
	@Options(useGeneratedKeys = true, keyProperty = "notice.id", keyColumn = "id")
	public int save(@Param("notice") Notice notice);
	
	@Select("SELECT * from notice")
    public List<Notice> list();
	
	@Update("UPDATE notice " +
            "SET content = #{notice.content} WHERE id = #{notice.id}")
    public void noticeUpdate(@Param("notice") Notice notice);
	
	@Delete("DELETE FROM notice WHERE id = #{noticeId} ")
    public void noticeDelete(@Param("noticeId") int id);
}
