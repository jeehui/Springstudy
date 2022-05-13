<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	//페이지 로드 이벤트
	$(document).ready(function(){
		$('#btn1').on('click', fnAjax1)
		$('#btn2').on('click', fnAjax2)
		$('#btn3').on('click', fnAjax3)
		$('#btn4').on('click', fnAjax4)
	})
	
	function fnAjax1(){
		$('result1').empty();
		$.ajax({
			url:'${contextPath}/board/detail1',
			type:'get',
			data: $('#f').serialize(),
			
			dataType: 'json',
			success: function(obj){
				$('#result1').text(res);
			},
			error: function(jqXHR){
				$('#result1').text(jqXHR.status + ' : ' + jqXHR.responseText);
			}
		})
	} //fnAjax1
	
	function fnAjax2(){
		$('result1').empty();
		$.ajax({
			url:'${contextPath}/board/detail1',
			type:'get',
			data: $('#f').serialize(),
			
			dataType: 'json',
			success: function(obj){
				$('#result1').text(res);
			},
			error: function(jqXHR){
				$('#result1').text(jqXHR.status + ' : ' + jqXHR.responseText);
			}
		})
	} //fnAjax2
	
	function fnAjax3(){
		$('result1').empty();
		$.ajax({
			url:'${contextPath}/board/detail3',
			type:'post',
			data: JSON.stringify({
				'title' : $('#title').val(),
				'hit'	: $('#hit').val()
		}),			
			contentType: 'application/json',
			
			dataType: 'json',
			success: function(obj){
				$('#result1').text(res);
			},
			error: function(jqXHR){
				$('#result1').text(jqXHR.status + ' : ' + jqXHR.responseText);
			}
		})
	} //fnAjax3
	
	function fnAjax4(){
		$('result1').empty();
		$.ajax({
			url:'${contextPath}/board/detail4',
			type:'post',
			data: $('#f').serialize(),
			
			dataType: 'json',
			success: function(obj){
				$('#result1').text(res);
			},
			error: function(jqXHR){
				$('#result1').text(jqXHR.status + ' : ' + jqXHR.responseText);
			}
		})
	}
	
</script>
</head>
<body>
	<form id="f">
		<input type="text" name="title" id="title"><br>
		<input type="text" name="hit" id="hit"><br>
		<input type="button" value="전송1" id="btn1">
		<input type="button" value="전송2" id="btn2">
		<input type="button" value="전송3" id="btn3">
		<input type="button" value="전송4" id="btn4">
	</form>
	
	<hr>
	
	<div id="result1"></div>
</body>
</html>