<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- pageContext.request.contextPath가 기니까 contextPath로 줄여주기 -->	
	<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="application"/>
	<h1>${res}</h1>
	
	<a href="/ex02/imageView">이미지보러가기</a>
	
	<br>
	
	<!-- hosting에 올릴 때 "/ex02"가 폴더로 인식되는 경우가 있어요. -->
	<!-- contextPath를 변수로 처리하면 해결됩니다. -->
	
	<a href="${contextPath}/imageView">이미지보러가기</a>
	
	<br>
	
	<a href="${contextPath}/lionView">사자보러가기</a>
	
</body>
</html>