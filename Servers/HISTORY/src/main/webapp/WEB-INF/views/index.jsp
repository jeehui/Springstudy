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
		fnSearchAll();
		fnSearch();
	})
	
	function fnSearchAll(){
		$.ajax({
			/* 요청 */
			url: '${contextPath}/history/searchAll',
			type: 'get',
			dataType: 'json',
			success: function(map){
				alert(map.msg);
				$('#histories').empty();
				if(map.status == 1){
					$.each(map.histories, function(i, history){
						$('<tr>')
						.append($('<td>').text(history.historyNo))
						.append($('<td>').text(history.userId))
						.append($('<td>').text(history.keyword))
						.append($('<td>').text(history.actionDay))
						.appendTo('#histories');
					})
				} else if(map.status == 0){
					$('<tr>')
					.append($('<td colspan="4">').text('검색 결과 없음'))
					.appendTo('#histories');
				}
			}
		})
	} // function fnSearchAll
	
	function fnSearch(){
		
		$('#btn').on('click', function(){
		
			$.ajax({
				url: '${contextPath}/history/search',
				type: 'post',
				data: JSON.stringify({
					'column': $('#column').val(),
					'searchText': $('#searchText').val()
				}),
				contentType: 'application/json',
				dataType: 'json',
				success: function(result){
					alert(result.msg);
					$('#histories').empty();
					if(result.status == 1){
						$.each(result.histories, function(i, history){
							$('<tr>')
							.append($('<td>').text(history.historyNo))
							.append($('<td>').text(history.userId))
							.append($('<td>').text(history.keyword))
							.append($('<td>').text(history.actionDay))
							.appendTo('#histories');
						})
					} else if(result.status == 0){
						$('<tr>')
						.append($('<td colspan="4">').text('검색 결과 없음'))
						.appendTo('#histories');
					}
				}
			})
			
		})
		
		
	}

</script>
</head>
<body>
<!-- submit안해서 그냥 id로 끝! -->
	<select id="column">
		<option value="USER_ID">사용자</option>
		<option value="KEYWORD">키워드</option>
	</select>
	<input type="text" id="searchText">
	<input type="button" value="검색" id="btn">
	
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				 <td>번호</td>
				<td>사용자</td>
				<td>키워드</td>
				<td>평점</td>
			</tr>
		</thead>
		<tbody id="histories"></tbody>
	</table>
	
</body>
</html>