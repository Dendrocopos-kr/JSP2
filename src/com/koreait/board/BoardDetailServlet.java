package com.koreait.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.common.Utils;
import com.koreait.board.db.BoardDetailDAO;
import com.koreait.board.vo.BoardVO;

@WebServlet("/BoardDetail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int check_Id = Utils.parseStringToInt(request.getParameter("id") , 0 );
		
		if( check_Id == 0) {
			response.sendRedirect("BoardList");
			return;
		}
		
		BoardVO param = new BoardVO();
		param.setId_board(check_Id);
		
		request.setAttribute("data", BoardDetailDAO.selBoard(param));
		request.getRequestDispatcher("/WEB-INF/VIEW/boardDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
