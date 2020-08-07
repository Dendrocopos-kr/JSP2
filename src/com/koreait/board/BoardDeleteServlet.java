package com.koreait.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.common.Utils;
import com.koreait.board.db.BoardDeleteDAO;
import com.koreait.board.vo.BoardVO;

@WebServlet("/BoardDel")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO param = new BoardVO();
		param.setId_board( Utils.parseStringToInt(request.getParameter("id"),0 ));
		System.out.println(param.getId_board());
		if( BoardDeleteDAO.boardDelete(param)  == 0 ) {
			// 에러문구
			// 이미 삭제되었거나, 없는 페이지입니다.
			response.sendRedirect("BoardList?warring=1");
		}else {
			response.sendRedirect("BoardList");
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
