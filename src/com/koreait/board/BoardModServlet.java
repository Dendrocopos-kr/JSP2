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

@WebServlet("/BoardMod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int check_Id = Utils.parseStringToInt(request.getParameter("id") , 0 );
		
		if( check_Id == 0) {
			response.sendRedirect("BoardList");
			return;
		}
		
		BoardVO param = new BoardVO();
		param.setId_board(check_Id);
		
		request.setAttribute("data", BoardDAO.selBoard(param));
		request.setAttribute("err", Utils.parseStringToInt(request.getParameter("err"),0) == 1 ? " 삭제실패했습니다." : null);
		
		request.getRequestDispatcher("/WEB-INF/VIEW/boardWrite.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO param = new BoardVO();
		param.setId_board(Utils.parseStringToInt(request.getParameter("id"), 0));
		param.setTitle(request.getParameter("title"));
		param.setCtnt(request.getParameter("ctnt"));
		param.setId_student(Utils.parseStringToInt(request.getParameter("name"), 0));
		BoardDAO.update_Mod(param);
		response.sendRedirect("BoardDetail?id="+param.getId_board());
		//doGet(request, response);
	}

}
