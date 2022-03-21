package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

// DAO(DataAccessObject)
@Repository("userDAO")
public class UserDAO {
	// JDBC 관련 변수
	private Connection conn=null;
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	// SQl 명령어들
	private final String USER_GET="select * from users where id=? and password=?";
	private final String USER_INSERT="insert into users values(?,?,?,?)";
	private final String USER_UPDATE="update users set password=?, role=? where id=?";
	private final String USER_DELETE="delete from users where id=?";
	
	// CRUD 기능의 메소드 구현
	// 회원 등록
	public UserVO getUser(UserVO vo) {
		UserVO user=null;
		System.out.println("===> JDBC로 getUser() 기능 처리");
		try {
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());;
			rs=stmt.executeQuery();
			while(rs.next()) {
				user=new UserVO();
				user.setId(rs.getNString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}
	// insertUser
	public UserVO insertUser(UserVO vo) {
		UserVO user=null;
		System.out.println("===> JDBC로 insertUser() 기능 처리");
		try {
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());;
			stmt.setString(3, vo.getName());;
			stmt.setString(4, vo.getRole());;
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		return user;
	}
	// updateUser
	// update users set password=?, role=? where id=?
	public UserVO updateUser(UserVO vo) {
		UserVO user=null;
		System.out.println("===> JDBC로 updateUser() 기능 처리");
		try {
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(USER_UPDATE);
			stmt.setString(1, vo.getPassword());;
			stmt.setString(2, vo.getRole());;
			stmt.setString(3, vo.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		return user;
	}
	
	// deleteUser
	public UserVO deleteUser(UserVO vo) {
		UserVO user=null;
		System.out.println("===> JDBC로 deleteUser() 기능 처리");
		try {
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(USER_DELETE);
			stmt.setString(1, vo.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		return user;
	}
	
}










