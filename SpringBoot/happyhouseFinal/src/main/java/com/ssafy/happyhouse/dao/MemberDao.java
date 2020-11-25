package com.ssafy.happyhouse.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ssafy.happyhouse.dto.MemberDto;

@Mapper
public interface MemberDao {

//	@Select(" SELECT USER_SEQ as userSeq, USER_NAME as userName, USER_PASSWORD as userPassword, USER_EMAIL as userEmail, DATE_FORMAT(USER_REGISTER_DATE,'%Y.%m.%d.') as userRegisterDate from user where user_name = #{userName} ")
	@Select(" SELECT USER_SEQ as userSeq, USER_NAME as userName, USER_PASSWORD as userPassword, USER_EMAIL as userEmail, USER_REGISTER_DATE as userRegisterDate from user where user_name = #{userName} ")
	public MemberDto login(String userName) throws SQLException;
	
	@Insert("INSERT INTO user ( USER_NAME, USER_PASSWORD, USER_EMAIL, USER_REGISTER_DATE ) VALUES ( #{memberDto.userName} , #{memberDto.userPassword} , #{memberDto.userEmail} , now())")
	@Options(useGeneratedKeys = true)
	public int join(@Param("memberDto") MemberDto memberDto);
	
	@Update("UPDATE user " +
            "SET USER_PASSWORD = #{memberDto.userPassword}, USER_EMAIL = #{memberDto.userEmail} WHERE USER_SEQ = #{memberDto.userSeq}")
    public void loginUpdate(@Param("memberDto") MemberDto memberDto);
	
	@Delete("DELETE FROM user WHERE USER_SEQ = #{loginId} ")
    public void loginDelete(@Param("loginId") int id);
}


