package com.koreait.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.db.BoardDAO;;

@WebServlet("/BoardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//	String strId_board = request.getParameter("id_board");
		//	System.out.println(strId_board);
		request.setAttribute("data", BoardDAO.selBoardList());
		request.setAttribute("Warring", request.getParameter("warring"));
		request.setAttribute("Error", request.getParameter("err"));
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/VIEW/boardList.jsp");
		rd.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
