<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% session.invalidate(); %>

	<form action="Q02_B.jsp" method="post">
		아이디 <input type="text" name="id" /><br/>
		비밀번호 <input type="password" name="pw" /><br/>
		이름 <input type="text" name="name" /><br/>
		<button>회원가입</button>
	</form>

</body>
</html>