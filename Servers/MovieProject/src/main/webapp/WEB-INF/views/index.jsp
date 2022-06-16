<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	
	$(function(){
		fnSearchAllMovie();
		fnSearchMovie();
	})
	
	function fnSearchAllMovie(){
		$.ajax({
			/* 요청 */
			url: '${contextPath}/movie/searchAllMovies',
			type: 'get',
			dataType: 'json',
			success: function(map){
				alert(map.msg);
				$('#movies').empty();
				if(map.status == 200){
					$.each(map.movies, function(i, movie){
						$('<tr>')
						.append($('<td>').text(movie.title))
						.append($('<td>').text(movie.genre))
						.append($('<td>').text(movie.description))
						.append($('<td>').text(movie.star))
						.appendTo('#movies');
					})
				} else if(map.status == 500){
					$('<tr>')
					.append($('<td colspan="4">').text('검색 결과 없음'))
					.appendTo('#movies');
				}
			}
		})
	} 
	
function fnSearchMovie(){
		
		$('#btn').on('click', function(){
		
			$.ajax({
				url: '${contextPath}/movie/searchMovie',
				type: 'post',
				data: JSON.stringify({
					'column': $('#column').val(),
					'searchText': $('#searchText').val()
				}),
				contentType: 'application/json',
				dataType: 'json',
				success: function(result){
					alert(result.msg);
					$('#movies').empty();
					if(result.status == 200){
						$.each(result.movies, function(i, movie){
							$('<tr>')
							.append($('<td>').text(movie.title))
							.append($('<td>').text(movie.genre))
							.append($('<td>').text(movie.description))
							.append($('<td>').text(movie.star))
							.appendTo('#movies');
						})
					} else if(result.status == 500){
						$('<tr>')
						.append($('<td colspan="4">').text('검색 결과 없음'))
						.appendTo('#movies');
					}
				}
			})
			
		})
		
		
	}
	
</script>
</head>
<body>
	<select id="column">
		<option value="TITLE">제목</option>
		<option value="GENRE">장르</option>
		<option value="DESCRIPTION">내용</option>
	</select>
	<input type="text" id="searchText">
	<input type="button" value="검색" id="btn">
	<input type="button" value="초기화" >
	
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<td>제목</td>
				<td>장르</td>
				<td>내용</td>
				<td>평점</td>
			</tr>
		</thead>
		<tbody id="movies"></tbody>
	</table>
</body>
</html>