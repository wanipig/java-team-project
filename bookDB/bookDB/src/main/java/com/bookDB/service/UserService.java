package com.bookDB.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.bookDB.repository.UserRepository;


@Service // 이 클래스가 Spring의 서비스 컴포넌트임을 나타냄 (비즈니스 로직 담당)
public class UserService {
	private final UserRepository repository;
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	
	//Delete
	public Boolean delete(int id) {
		if(!repository.existsById(id)) { // 존재여부 체크
			return false;
		}
		repository.deleteById(id); // 사용자 삭제
		return true; // 삭제 완료시 true리턴
	}
}
