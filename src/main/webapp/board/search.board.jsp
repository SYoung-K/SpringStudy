<%@page import="mvc.Page"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{margin: 0 auto;}
#wrapper{
    width: 900px;
    height: 600px;
    border: 1px solid black;
    margin: 0 auto;
}
#h2{margin-bottom: 25px;}
#wrapper>#title{
	    border: 1px solid black;
    	height: 40px;
    	display: flex;
}
#items{
	border: 1px solid black;
    height: 440px;
     overflow: auto;
   
}
#items>#item{
	display: flex;
	border: 1px solid black;
    height: 40px;
}
#btn_zone{
	margin: 0 auto;
    width:max-content;}
#search_zone{
	text-align: right;
}   
    

</style>
</head>

<body>
<div id="wrapper">
	<h2 id="h2">게시판</h2>
	<div id="title">
		<div>번호</div>
		<div>제목</div>
		<div>작성자</div>
		<div>등록일</div>
		<div>조회수</div>
	</div>
	<div id=items>
		<c:forEach var='vo' items="${list}">
		<div id=item>
			<div>${vo.serial }</div>
			<div>${vo.subject }</div>
			<div>${vo.mid }</div>
			<div>${vo.mDate }</div>
			<div>${vo.hit }</div>
		</div><hr>
		</c:forEach>
	</div>
<div id="btn_zone">
	<c:if test="${page.startPage>1 }">
	<input type="button" value="맨첨" onclick="move(1)">
	<input type="button" value="이전" onclick="move(${page.nowPage-1})">
	</c:if>
	
	<c:forEach var="p" begin="${page.startPage }" end="${page.endPage }">
	<input type="button" value="${p }" onclick="move(${p })">
	</c:forEach>
	
	<c:if test="${page.endPage<page.totPage }">
	<input type="button" value="맨뒤" onclick="move(${page.totPage})">
	<input type="button" value="다음" onclick="move(${page.nowPage+1})">
	</c:if>		
</div>
<div id="search_zone">
	<input type="text">
	<input type="button" value="검색">
	<input type="hidden" name="nowPage" value="${(empty page.nowPage)?1:page.nowPage }">
	<input type="hidden" value="검색">	
</div>	
</div>
<script type="text/javascript" src="./board/board.js"></script>
</body>
</html>