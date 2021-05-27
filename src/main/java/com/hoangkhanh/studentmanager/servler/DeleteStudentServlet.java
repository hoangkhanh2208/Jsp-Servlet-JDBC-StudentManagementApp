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

import com.hoangkhanh.studentmanager.conn.ConnectionUtils;
import com.hoangkhanh.studentmanager.utils.DBUtils;

@WebServlet(urlPatterns = "/deleteStudent")
public class DeleteStudentServlet extends HttpServlet{
	public DeleteStudentServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		resp.setContentType("text/html;charset=UTF-8");
		  req.setCharacterEncoding("utf-8");
		
		String errorString = null;
		String idStr = (String)req.getParameter("id");
		
		int id = 0;
		try {
			id = Integer.parseInt(idStr);
			DBUtils.deleteStudent(conn, id);
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		
		if(errorString != null){
			req.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/deleteStudentErrorView");
			dispatcher.forward(req, resp);
		}else {
            resp.sendRedirect(req.getContextPath() + "/studentList");
        }
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
