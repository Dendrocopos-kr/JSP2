<%@page import="com.koreait.board.vo.BoardVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${data.title}</title>
</head>
<style>
.main_body {
	width: 800px;
	margin: 0 auto;
	display: flex;
}

.main_body div {
	margin: 10px;
}

.ctnt {
	border: black 1px solid;
	height: 400px;
	padding: 10px;
}

.board_ctnt_title, .profile {
	border: black 1px solid;
	display: flex;
	margin-bottom: 30px;
}

.board_ctnt_title div {
	margin: 10px;
}

.menu {
	border: 1px solid black;
	padding: 10px;
	width: 20%;
}

.board_body {
	width: 75%;
}

.profile {
	justify-content: space-between;
}
</style>
<body>
	<div class="main_body">
		<div class="menu">
			<div>
				<B>게시판 메뉴</B>
			</div>
			<hr>
			<div>
				게시글 번호 :${data.id_board}</div>
			<div>
				<a href="/BoardList">리스트보기</a>
			</div>
			<div>
				<a href="" onclick="procDel(${data.id_board})">삭제</a>
			</div>
			<div>
				<a href="/BoardRegmod?id=${data.id_board}">수정</a>
			</div>
		</div>
		<div class="board_body">
			<div class="board_ctnt_title">
				<div>
					제목 :${data.title}</div>
			</div>
			<div class="profile">
				<div>
					작성일 :${data.r_dt}</div>
				<div>
					작성자 :${data.id_student}</div>
			</div>
			<div class="ctnt">${data.ctnt}</div>
		</div>
	</div>
	<script type="text/javascript">
	function procDel(PK){
		event.preventDefault();
		var result = confirm('삭제하시겠습니까?');
		//alert('id_board :'+ id)
		if(result){
			location.href = '/BoardDel?id='+PK;
		}
	}</script>
</body>
</html>