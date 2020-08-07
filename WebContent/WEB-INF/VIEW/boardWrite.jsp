<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
.container {
	width: 600px;
	margin: 30px auto;
	border: 1px black solid;
	padding: 10px;
	display: flex;
	flex-direction: column;
}

form {
	display: flex;
	flex-direction: column;
}

form div {
	margin: 10px auto;
	display: flex;
}

div label {
	width: 100px;
}

div textarea, div input {
	width: 350px;
	margin-bottom: 30px;
}

.button {
	display: flex;
	justify-content: space-between;
}

div textarea {
	height: 400px;
}
</style>
</head>
<body>
	<div class="container">
		<form action="BoardWriteMod" method="post" onsubmit="return chk()" id="frm">
			<input type="hidden" name="id_board" value="${data.id_board}">
			<div>
				<label for="title">제목:</label><input id="title" name="title" value="${data.title}">
			</div>
			<div>
				<label for="ctnt">내용:</label>
				<textarea id="ctnt" name="ctnt">${data.ctnt }</textarea>
			</div>
			<div>
				<label for="id">작성자:</label><input id="name" name="name" value="${data.id_student }">
			</div>
			<div class="button">
				<input type="submit" value="글 작성">
			</div>
		</form>
		<button onclick="moveToList();">돌아가기</button>

	</div>
	<script type="text/javascript">
		function eleValid(ele, nm) {
			if (ele.value.length == 0) {
				alert(nm + '을(를) 입력해주세요');
				ele.focus();
				return true;
			}
		}
		function chk() {
			if (eleValid(frm.title, '제목')) {
				return false;
			} else if (eleValid(frm.ctnt, '내용')) {
				return false;
			} else if (eleValid(frm.name, '이름')) {
				return false;
			}
		}

		function moveToList(PK) {
			console.log(PK);
			location.href = 'BoardList';
		}
	</script>
</body>
</html>