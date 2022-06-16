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
	
	<!-- Controller2에 요청하기, Board 도메인(Builder 패턴) 사용 -->
	<a href="${contextPath}/add1?title=공지사항1&hit=10">정보전달1</a><br>
	<a href="${contextPath}/add2?title=공지사항1&hit=10">정보전달2</a><br>
	<a href="${contextPath}/add3?title=공지사항1&hit=10">정보전달3</a><br>
	
	<hr>
	
	<!-- Controller3에 요청하기, Product 도메인 사용-->
	<form method="post">
		<input type="text" name="models" placeholder="모델명"><br>
		<input type="text" name="price" placeholder="가격"><br>
		<input type="button" value="정보전달1" onclick="fn1(this.form)"> <!-- HttpServletRequest + Model -->
		<input type="button" value="정보전달2" onclick="fn2(this.form)"> <!-- @RequestParam + Model -->
		<input type="button" value="정보전달3" onclick="fn3(this.form)"> <!-- Product + Model -->
	</form>
	<script>
	//fn1(f) = fn1(this.form) this.form을 f로 정해둠
		function fn1(f){ //onclick=fn1(this.form)을 통해서 form 전체 내용이 매개변수 f에 전달됩니다.
			f.action = '${contextPath}/remove1';
			f.submit();
		}
		function fn2(f){
			f.action = '${contextPath}/remove2';
			f.submit();
		}
		function fn3(f){ 
			f.action = '${contextPath}/remove3';
			f.submit();
		}
	</script>
	
	<hr>
	
	<!-- Controller4에 요청하기, redirect 하는 방법 -->
	<a href="${contextPath}/list1?page=1">목록보기1</a>
	<a href="${contextPath}/list3?page=1">목록보기2</a>
	<a href="${contextPath}/list5?page=1">목록보기3</a>
</body>
</html>