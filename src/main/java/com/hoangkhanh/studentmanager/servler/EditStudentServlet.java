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

@WebServlet(urlPatterns = { "/editStudent" })
public class EditStudentServlet extends HttpServlet{
	public EditStudentServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(req);
		
		String idStr = req.getParameter("id");
		
		int id = 0;
		try {
			id = Integer.parseInt(idStr);
		} catch (Exception e) {
			
		}
		System.out.print(id);
		Student student = null;
		
		String errorString = null;
		
		try {
			student = DBUtils.findStudent(conn, id);
		} catch (SQLException e) {
			errorString  = e.getMessage();
			e.printStackTrace();
		}
		
		if(errorString != null && student == null) {
			resp.sendRedirect(req.getServletPath() + "/studentList");
			return;
		}
		
		req.setAttribute("errorString", errorString);
        req.setAttribute("student", student);
        
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/editStudentView.jsp");
        dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		resp.setContentType("text/html;charset=UTF-8");
		  req.setCharacterEncoding("utf-8");
		
		String idStr = (String)req.getParameter("id");
		String fullName = (String)req.getParameter("fullName");
		String ageStr = (String)req.getParameter("age");
		String address = (String)req.getParameter("address");
		
		int age = 0;
		int id = 0;
		try {
			age = Integer.parseInt(ageStr);
			id = Integer.parseInt(idStr);
		} catch (Exception e) {
			
		}
		
		Student student = new Student(id,fullName, age, address);
		
		String errorString = null;
		
		try {
			DBUtils.updateStudent(conn, student);
		} catch (SQLException e) {
			errorString = e.getMessage();
			e.printStackTrace();
		}
		
		 req.setAttribute("errorString", errorString);
	     req.setAttribute("student", student);
	     
	     if (errorString != null) {
	            RequestDispatcher dispatcher = req.getServletContext()
	                    .getRequestDispatcher("/WEB-INF/views/editStudentView.jsp");
	            dispatcher.forward(req, resp);
	        }        
	      else {
	            resp.sendRedirect(req.getContextPath() + "/studentList");
	        }
	}
	
}
