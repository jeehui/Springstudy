<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test ="${member eq null}">
	
	<form action="${contextPath}/member/login" method="post">
		아이디<input type="text" id="id" name="id">
		비밀번호<input type="password" id="pw" name="pw">
		<button>로그인</button>
	</form> 
	</c:if>
	
	<c:if test="${member ne null}">
	 ${member.id} 님 반갑습니다
	</c:if>
	
	<a href="${contextPath}/freeBoard/list">자유게시판</a>
	
</body>
</html>