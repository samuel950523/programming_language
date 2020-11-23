package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ssafy.happyhouse.dto.HouseDealDto;
import com.ssafy.happyhouse.dto.HouseInfoDto;

@Mapper
public interface HouseMapDao {

	@Select("SELECT * from housedeal where dong = #{dong}")
	List<HouseDealDto> getAptInDong(String dong) throws Exception;
	
	
	List<HouseInfoDto> getAptDetail(String aptdetail) throws Exception;
	HouseDealDto getDetail(String aptName, String dongCode) throws Exception;
	
//	@Insert("INSERT INTO todolist ( content , createdAt  )" +
//            "VALUES ( #{memo.content} , #{memo.createdAt} )")
//	@Options(useGeneratedKeys = true, keyProperty = "memo.id", keyColumn = "id")
//	public int save(@Param("memo") Memo memo);
//	
//	@Select("SELECT * from todolist")
//    public List<Memo> list();
//	
//	@Select("SELECT * from todolist where createdAt = #{createdAt}") // 새로 추가한 부분. 만약 createAt과 같다면 다 받아오기 
//	public List<Memo> getListByCreatedAt(@Param("createdAt") LocalDate createdAt);
//	
//	@Update("UPDATE todolist " +
//            "SET content = #{memo.content} WHERE id = #{memo.id}")
//    public void memoUpdate(@Param("memo") Memo memo);
//	
//	@Delete("DELETE FROM todolist WHERE id = #{memoId} ")
//    public void memoDelete(@Param("memoId") int id);
	
}