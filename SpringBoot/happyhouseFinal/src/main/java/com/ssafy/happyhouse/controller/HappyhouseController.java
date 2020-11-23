package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.HouseDealDto;
import com.ssafy.happyhouse.service.HouseMapService;

@RestController
public class HappyhouseController {

	@Autowired
	HouseMapService houseService;

	@CrossOrigin(origins = "*")
	@GetMapping("/getAptInDong")
	public List<HouseDealDto> getAptInDong(@RequestParam(value="dongName", required=false) String dongName) throws Exception {
		// .....		
		
		System.out.println(dongName); // 동 출력

		List<HouseDealDto> house = houseService.getAptInDong(dongName); // 동 이름을 넣어서 해당하는 apt list 반환

		return house;
	}
//	
//	@CrossOrigin(origins = "http://localhost:4000")
//	@PostMapping("/todo")
//	public int createTodo ( @RequestBody Memo memo ) {
//		
//		int result = houseService.create(memo);
//		System.out.println("create만들기");
//		return result;
//	}
//	
//	@CrossOrigin(origins = "http://localhost:4000")
//	@GetMapping("/todolist")
//	public List<Memo> showTodolist(@RequestParam(value="createdAt", required=false)
//	@DateTimeFormat(pattern="yyyy-MM-dd") LocalDate createdAt) {
//		System.out.println(createdAt); //날짜 출력해주고
//		
//		List<Memo> memo = houseService.list(createdAt); //service에 내가 선택한 날짜를 파라미터로 넣기 
//		
//		return memo;
//	}
//	@CrossOrigin(origins = "http://localhost:4000")
//	@PutMapping("/todo")
//	public void memoUpdate (@RequestBody Memo memo) {
//		
//		System.out.println(memo.getId() +" "+ memo.getContent());
//		houseService.update(memo);
//	}
//	
//	@CrossOrigin(origins = "http://localhost:4000")
//	@DeleteMapping("/todo/{id}")
//	public void memoDelete (@PathVariable int id) {
//		houseService.delete(id);
//	}
}
