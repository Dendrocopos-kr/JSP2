package com.koreait.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.common.Utils;
import com.koreait.board.db.BoardDAO;
import com.koreait.board.vo.BoardVO;

@WebServlet("/BoardWriteMod")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BoardVO param = new BoardVO();
		param.setId_board(Utils.parseStringToInt(request.getParameter("id_board"), 0));
		param.setTitle(request.getParameter("title"));
		param.setCtnt(request.getParameter("ctnt"));
		param.setId_student(Utils.parseStringToInt(request.getParameter("name"), 0));

		if (param.getId_board() == 0) {
			switch (BoardDAO.insert_Mod(param)) {
			case -1:
				response.sendRedirect("BoardRegmod?err=1");
				break;
			case 0:
				break;
			case 1:
				response.sendRedirect("BoardList");
				break;
			}
		} else {
			switch(BoardDAO.update_Mod(param)) {
			case -1:
				response.sendRedirect("BoardList?err=2");
				break;
			case 0:
				break;
			case 1:
				response.sendRedirect("BoardDetail?id=" + param.getId_board());
				break;
			}
		}
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
