<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../resources/js/jquery-3.6.0.js"></script>
<script>
	
	/* 페이지 로드*/
	$(function(){
		fnInit();
		fnFileCheck();
		fnAdd();
		fnAttached();
	})
	
	
	/* 함수 */
	function fnInit(){
		
	}
	
	function fnFileCheck(){
		
	}
	
	function fnAdd(){
		
	}
	
	function fnAttached(){
		
	}
	
</script>
</head>
<body>
	
	<h1>갤러리 관리</h1>
	
	<div>
		작성자 <input type="text" name="writer" id="writer"><br>
		제목   <input type="text" name="title"  id="title"><br>
		내용   <input type="text" name="content" id="content"><br>
		첨부   <input type="file" name="files" id="files" multiple="multiple"><br><br>
		<input type="button" value="등록" id="btnAdd">
	</div>
	
	<div>
		<h3>첨부된 파일 확인</h3>
		<div id="attached"></div>		
	</div>
		
</body>
</html>