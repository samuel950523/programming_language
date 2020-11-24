package com.ssafy.happyhouse.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ssafy.happyhouse.dto.MemberDto;

@Mapper
public interface MemberDao {

	@Select(" SELECT USER_SEQ as userSeq, USER_NAME as userName, USER_PASSWORD as userPassword, USER_EMAIL as userEmail, DATE_FORMAT(USER_REGISTER_DATE,'%Y.%m.%d.') as userRegisterDate from user where user_name = #{userName} ")
	public MemberDto login(String userName) throws SQLException;
	
	@Insert("INSERT INTO user ( USER_NAME as userName , USER_PASSWORD as userPassword, USER_EMAIL as userEmail )" +
  "VALUES ( #{info[0]} , #{info[1]} , #{info[2]} )")
	@Options(useGeneratedKeys = true)
	public int join(@Param("info") String[] info);
}
