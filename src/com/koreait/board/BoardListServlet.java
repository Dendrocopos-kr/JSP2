package com.koreait.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.common.Utils;
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

		//애러구문 스위치로 변경할것
		request.setAttribute("Warring", Utils.parseStringToInt(request.getParameter("warring"),0) == -1 ? null : "");
		request.setAttribute("Error", Utils.parseStringToInt(request.getParameter("err"),0) == -1 ? null : "");
		
		request.setAttribute("id", request.getParameter("id_board"));
		
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
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         