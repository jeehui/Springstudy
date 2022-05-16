<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js" integrity="sha256-6XMVI0zB8cRzfZjqKcD01PBsAy3FlDASrlC8SxCpInY=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<script>

	//
	$(document).ready(function(){
		
		$('#targetDt').datepicker({
			showOn: 'both',
			dateFormat: 'yymmdd' //실제 생성되는 날짜는 yyyymmdd
		});
		
		$('#btnQuery').on('click', ()=>{
			fnDailyBoxOffice();
		})
	})
	
	//함수
	function fnDailyBoxOffice(){
		$.ajax({
			url: '${contextPath}/dailyBoxOffice'
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