<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script>

	//
	$(document).ready(function(){
		
	})
	$(function(){
		$( "#datepicker" ).datepicker();
	})
	
	//함수
	function fnDailyBoxOffice(){
		$.ajax({
			
		})
	}
	
</script>
</head>
<body>
	
	<p>Date: <input type="text" id="datepicker"></p>
	조회버튼 클릭하면 ajax 동작
	
	-----
	
	순위 영화이름 개봉일 일일관객수 누적관객수 비고(신규의 경우 신규)	
	
</body>
</html>