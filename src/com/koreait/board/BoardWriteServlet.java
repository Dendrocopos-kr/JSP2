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
		param.setId_board(Utils.parseStringToInt(request.getParameter("id_board"),0));
		param.setTitle(request.getParameter("title"));
		param.setCtnt(request.getParameter("ctnt"));
		param.setId_student(Utils.parseStringToInt(request.getParameter("name"), 0));

		if(param.getId_board() == 0) {
			if (BoardDAO.insert_Mod(param)) {
				response.sendRedirect("BoardList");
			}else {
				response.sendRedirect("BoardList?err=1");
				//실패시 이동할 경로 insert err
			}
		}else {
			if(BoardDAO.update_Mod(param)) {
				response.sendRedirect("BoardDetail?id="+param.getId_board());
			}else {
				response.sendRedirect("BoardList?err=2");
				//실패시 이동할 경로 update err
			}
		}
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
