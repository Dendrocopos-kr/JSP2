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

@WebServlet("/BoardRegmod")
public class BoardRegmodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardVO param = new BoardVO();
		int check_mod = Utils.parseStringToInt(request.getParameter("id"), 0);

		if (check_mod > 0) {
			param.setId_board(check_mod);
			request.setAttribute("data", BoardDAO.selBoard(param));
		}

		request.setAttribute("submit_button_name", check_mod > 0 ? "글 수정" :"글 등록");
		
		request.setAttribute("err", Utils.parseStringToInt(request.getParameter("err"),0) > 0 ? "애러 발생": null );
		
		String path = "/WEB-INF/VIEW/boardWrite.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		BoardVO insert_Data = new BoardVO();
//		insert_Data.setTitle(request.getParameter("title"));
//		insert_Data.setCtnt(request.getParameter("ctnt"));
//		insert_Data.setId_student(Utils.parseStringToInt(request.getParameter("name"),0));		
//		String path = "/WEB-INF/VIEW/boardRegmod.jsp";
//		request.getRequestDispatcher(path).forward(request, response);
		doGet(request, response);
	}

}
