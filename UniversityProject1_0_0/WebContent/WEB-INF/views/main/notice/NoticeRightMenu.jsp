<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/> 
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main/notice.css" />

<aside class="sidebar col-sm-3">
	<div class="widget">
		<h4>게시판 목록</h4>
		<ul>
			<li class="current"><a href="../notice/list.do" title="">공지게시판</a></li>
			<li><a href="#" title="">자유게시판</a></li>
		</ul>
	</div>
</aside>