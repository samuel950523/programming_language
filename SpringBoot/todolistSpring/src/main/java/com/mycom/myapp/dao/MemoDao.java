package com.mycom.myapp.dao;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mycom.myapp.dto.Memo;

@Mapper
public interface MemoDao {
	
	@Insert("INSERT INTO todolist ( content , createdAt  )" +
            "VALUES ( #{memo.content} , #{memo.createdAt} )")
	@Options(useGeneratedKeys = true, keyProperty = "memo.id", keyColumn = "id")
	public int save(@Param("memo") Memo memo);
	
	@Select("SELECT * from todolist")
    public List<Memo> list();
	
	@Select("SELECT * from todolist where createdAt = #{createdAt}") // 새로 추가한 부분. 만약 createAt과 같다면 다 받아오기 
	public List<Memo> getListByCreatedAt(@Param("createdAt") LocalDate createdAt);
	
	@Update("UPDATE todolist " +
            "SET content = #{memo.content} WHERE id = #{memo.id}")
    public void memoUpdate(@Param("memo") Memo memo);
	
	@Delete("DELETE FROM todolist WHERE id = #{memoId} ")
    public void memoDelete(@Param("memoId") int id);
}
