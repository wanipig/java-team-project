package com.bookDB.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookDB.service.UserService;

@Controller
@RequestMapping("/user") // 모든 경로 요청 앞에 "/user" 붙임
public class SpringDBController {
	// 비즈니스 로직처리 서브스 객체
	private final UserService service;
	// 생성자
	public SpringDBController(UserService service) {
		this.service= service;
	}
	
		// DELETE 책 삭제 -> ID로 삭제 하기
	@PostMapping("/deleteForm") // POST 요청 "/user/deleteForm" 처리
	@ResponseBody
	public String delete(@RequestParam("id") int id) {
		boolean success = service.delete(id); // 아직 userService 구현 못 해서 빨간
		if(!success) {
			// 실패시 메시지 띄우기
			return "<h3>삭제 실패: 사용자를 찾을 수 없습니다.</h3><a href='/user-crud.html'>돌아가기</a>";
		}
		// 성공 시 메시지 띄우기
		return "<h3>삭제 완료</h3><a href='/user/list'>전체 목록 보기</a>";
	}
	
	
	
}
