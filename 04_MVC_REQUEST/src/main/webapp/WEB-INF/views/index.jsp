<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:set var ="contextPath" value="${pageContext.request.contextPath}"/>
	
	<!-- Controller1 요청하기 -->
	<a href="${contextPath}/detail1?name=민경태&age=45">정보전달1</a>
	<a href="${contextPath}/detail2?name=이지희&age=27">정보전달2</a>
	<a href="${contextPath}/detail3?name=강지똥&age=7">정보전달3</a>
	<a href="${contextPath}/detail4?name=강치리&age=6">정보전달4</a>
	<a href="${contextPath}/detail5?name=이동희&age=27">정보전달5</a>
	<a href="${contextPath}/detail6?name=박현정&age=27">정보전달6</a>
	
	<hr>
	
	<!-- Controller2에 요청하기, Board 도메인 사용 -->
	<a href="${contextPath}/add1?title=공지사항1&hit=10">정보전달1</a><br>
	
	
</body>
</html>