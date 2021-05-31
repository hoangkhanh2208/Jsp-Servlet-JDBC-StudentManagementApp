package com.hoangkhanh.studentmanager.servler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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

@WebServlet(urlPatterns = { "/insertStudent" })
public class InsertStudentServlet extends HttpServlet{
	public InsertStudentServlet() {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/addStudent.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(req);
		
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		
		String fullName = (String)req.getParameter("fullName");
		String ageStr = (String)req.getParameter("age");
		String address = (String)req.getParameter("address");
		
		int age = 0;
		try {
			age = Integer.parseInt(ageStr);
		} catch (Exception e) {
			
		}
		
		Student student = new Student(fullName, age, address);
		
		String errorString = null;
		
		if(errorString == null) {
			try {
				DBUtils.insertStudent(conn, student);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		req.setAttribute("student", student);
		
		 if (errorString != null) {
	            RequestDispatcher dispatcher = req.getServletContext()
	                    .getRequestDispatcher("/WEB-INF/views/addStudentView.jsp");
	            dispatcher.forward(req, resp);
	        }        
	      else {
	            resp.sendRedirect(req.getContextPath() + "/studentList");
	        }
		
	}
}
