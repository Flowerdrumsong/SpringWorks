package com.springbook.biz.user;

public interface UserService {
	
	// CRUD 기능의 메서드 구현
	// 회원등록
	public UserVO getUser(UserVO vo);
	public void insertUser(UserVO vo);
	public void deleteUser(UserVO vo);
	public void updateUser(UserVO vo1);
	
}
