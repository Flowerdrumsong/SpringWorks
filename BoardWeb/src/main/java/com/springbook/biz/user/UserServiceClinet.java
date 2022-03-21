package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.user.impl.UserDAO;

public class UserServiceClinet {

	public static void main(String[] args) {
		//1. Spring 컨테이너를 구동한다.
		//xml 파일을 읽고, bean 객체 생성함. xml의 bean에 property엘리먼트를 사용하므로 set~~~()
		//xml 파일의 주석처리한 부분
		//setUserDAO(userDAO); 매개변수(ref)userDAO를 던지는 setUserDAO() (name=userDAO니까)
		//UserServiceImpl userSerive=new UserServiceImpl();
		//UserDAO userDAO=new UserDAO(); 디폴트 생성자 호출
		//userService.setUserDAO(userDAO);
		//그리고 UserDAO userDAO=new UserDAO() 까지 한 것 (ㅕuserserviceImle에서)
		AbstractApplicationContext container=new GenericXmlApplicationContext("user/userContext.xml");
		
		//2. Spring 컨테이너로부터 UserServiceImpl 객체를 lookup 한다
		UserService userService=(UserService) container.getBean("userService");
		
		//3. 로그인 기능 테스트
		//vo 객체 가져와서 메서드 사용하기
		UserVO vo= new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		// 나머지는 작성하지 않았으므로 name, role은 null
		UserVO user=userService.getUser(vo);
		if(user!=null) {
			System.out.println(user.getName()+"님 환영합니다");
		} else {
			System.out.println("로그인 실패");
		}
		
		//3-1. insert into users values(id, password, name, role)
		//3-1. insert into users values(?, ?, ?, ?)
		UserVO vo1=new UserVO();
		vo1.setId("test8");
		vo1.setPassword("test88");
		vo1.setName("name8");
		vo1.setRole("User8");
		userService.insertUser(vo1);
		
//		//3-2. update id기준  "update users set password=?, role=? where id=?"
		vo1.setPassword("test22up");
		vo1.setRole("User");
		vo1.setId("test2");
		userService.updateUser(vo1);
		
		//3-3. delete id기준 delete from users where id=?;
//		vo1.setId("test2");
//		userService.deleteUser(vo);
		
		//3-4. 전체목록 보여주기
		//3-5. 선택한 아이디 정보만 보여주기
		
		//4. Spring 컨테이너를 종료한다.
		container.close();
	}

}
