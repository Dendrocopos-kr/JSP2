<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.koreait.board.db.BoardDAO"%>
<%@page import="com.koreait.board.vo.BoardVO"%>
<%@page import="java.util.*"%>

<%
	String id = request.getParameter("id_board");
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("data");
%>
<title>게시판</title>
</head>
<style>
table {
	border: black 1px solid;
	margin: 10px auto;
	border-collapse: collapse;
}

th, td {
	padding: 1em;
	border: black 1px solid;
	text-align: center;
}

th {
	background: linear-gradient(white, lightpink, white);
}

td:nth-child(2) {
	text-align: left;
}

div {
	text-align: center;
}
</style>
<body>
	<div>
		<h1>게시판 리스트</h1>
	</div>
	<table>
		<tr>
			<th style="width: 60px;">번호</th>
			<th style="width: 300px;">제목</th>
			<th style="width: 150px;">작성일</th>
			<th style="width: 60px;">작성자</th>
		</tr>
		<%
			for (BoardVO vo : list) {
		%>
		<tr>
			<td><%=vo.getId_board()%></td>
			<td><%=vo.getTitle()%></td>
			<td><%=vo.getR_dt()%></td>
			<td><%=vo.getId_student()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<div>
		<button>글쓰기</button>
		</div>
</body>
</html>