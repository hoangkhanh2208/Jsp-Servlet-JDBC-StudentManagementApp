package com.hoangkhanh.studentmanager.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hoangkhanh.studentmanager.bean.Student;


public class DBUtils {
	
	public static List<Student> queryStudent(Connection conn) throws SQLException{
		String sql = "SELECT std.id, std.fullname, std.age, std.address FROM student std";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Student> list = new ArrayList<Student>();
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String fullName = rs.getString("fullname");
			int age = rs.getInt("age");
			String address = rs.getString("address");
			Student student = new Student(id, fullName, age, address);
			list.add(student);
		}
		return list;
	}
	
	public static Student findStudent(Connection conn, int id) throws SQLException {
		String sql = "SELECT std.id, std.fullname, std.age, std.address FROM student std WHERE std.id = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1 , id);
		ResultSet rs = pstm.executeQuery();
		
		while (rs.next()) {
			String fullName = rs.getString("fullname");
			int age = rs.getInt("age");
			String address = rs.getString("address");
			Student student = new Student(id, fullName, age, address);
			return student;
		}
		return null;
	}
	
	public static void updateStudent(Connection conn, Student student) throws SQLException {
		String sql = "UPDATE Student set fullname = ?, age = ?, address = ? WHERE id = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, student.getFullName());
		pstm.setInt(2, student.getAge());
		pstm.setString(3, student.getAddress());
		pstm.setInt(4, student.getId());
		pstm.executeUpdate();
	}
	
	public static void insertStudent(Connection conn, Student student) throws SQLException {
		String sql = "INSERT INTO student(fullname,age,address) VALUES (?,?,?)";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, student.getFullName());
		pstm.setInt(2, student.getAge());
		pstm.setString(3, student.getAddress());
		pstm.executeUpdate();
	}
	
	public static void deleteStudent(Connection conn, int id) throws SQLException {
		String sql = "DELETE FROM student WHERE id = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		
		pstm.executeUpdate();
	}
}
