package com.hoangkhanh.studentmanager.servler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hoangkhanh.studentmanager.bean.Student;
import com.hoangkhanh.studentmanager.conn.ConnectionUtils;
import com.hoangkhanh.studentmanager.utils.DBUtils;
import com.hoangkhanh.studentmanager.utils.MyUtils;

@WebServlet(urlPatterns = { "/studentList" })
public class StudentListServlet extends HttpServlet{
	 private static final long serialVersionUID = 1L;
	 
	 public StudentListServlet() {
		super();
	}
	  
	  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Connection conn = MyUtils.getStoredConnection(req);
		  resp.setContentType("text/html;charset=UTF-8");
		  req.setCharacterEncoding("utf-8");
		
		String errorString = null;
		List<Student> list = null;
		
		try {
			Connection conn = ConnectionUtils.getConnection();
			list = DBUtils.queryStudent(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("errorString", errorString);
		req.setAttribute("studentList", list);
		
		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/studentListView.jsp");
		dispatcher.forward(req, resp);
	}
	  
	  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	 
}
