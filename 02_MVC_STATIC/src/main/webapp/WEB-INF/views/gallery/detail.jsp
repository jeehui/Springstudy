<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 외부 css 파일 포함하기 -->
<link rel="styleshett" href="css/detail.css">

<!-- 외부 js 파일 포함하기 -->
<script src="resources/js/jquery-3.6.0.js"></script>
<script>
	$(document).ready(function(){
		$('.picture').on('click', funtion(){
			alert('앗 따거');
		})
	})
</script>

<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- 웹 경로에서 contextPath는 web root 폴더인 webapp을 의미합니다.
	  css 코드를 css/detail.css파일에 옮기고 link 태그로 적용시켜보세요. 
	-->
	 
</head>
<body>
	<h1>gallery에 오신 걸 환영합니다</h1>
	<h3>독수리</h3>
	<div class="picture"></div>
</body>
</html>