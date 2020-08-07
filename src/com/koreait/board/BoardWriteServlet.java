package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.common.Utils;
import com.koreait.board.db.BoardRegmodDAO;
import com.koreait.board.vo.BoardVO;

@WebServlet("/BoardWriteMod")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardVO vo = new BoardVO();
		vo.setId_board(Utils.parseStringToInt(request.getParameter("id_board"),0));
		vo.setTitle(request.getParameter("title"));
		vo.setCtnt(request.getParameter("ctnt"));
		vo.setId_student(Utils.parseStringToInt(request.getParameter("name"), 0));

		if(vo.getId_board() == 0) {
			if (BoardRegmodDAO.insert_Mod(vo)) {
				response.sendRedirect("BoardList");
			}else {
				response.sendRedirect("BoardList?err=1");
				//실패시 이동할 경로 insert err
			}
		}else {
			if(BoardRegmodDAO.update_Mod(vo)) {
				response.sendRedirect("BoardDetail?id="+vo.getId_board());
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
