<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${contextPath}/board/addPage">새글작성</a>
	
	<h3>전체게시글 개</h3>
	<table border="1">
		<thead>
			<tr>
				<td>게시글번호</td>			
				<td>제목</td>			
				<td>작성자</td>			
				<td>조회수</td>			
				<td>작성일자</td>			
				<td>삭제</td>			
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boards}" var="board">
				<tr>
					<td>${board.no}</td>
					<td><a href="${contextPath}/board/detail?no=${no}">${board.title}</a></td>
					<td>${board.writer}</td>
					<td>${board.hit}</td>
					<td>${board.created}</td>
					<td></td>				
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>