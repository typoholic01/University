<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/> 

<header class="site-header">
	<div class="top">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<p>KH 대학교</p>
				</div>
				<div class="col-sm-6">
					<ul class="list-inline pull-right">
						<li><a href="login.do">Login</a></li>
						<li><a href="https://www.facebook.com/khacademy1998"><i
								class="fa fa-facebook"></i></a></li>
						<li><a href="https://www.instagram.com/kh_iei/"><i
								class="fa fa-linkedin"></i></a></li>
						<li><a href="#"><i class="fa fa-envelope-o"></i></a></li>
						<li><a href="#"><i class="kh-phone"></i> +82 1544-9970</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<nav class="navbar navbar-default">
		<div class="container">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-navbar-collapse">
				<span class="sr-only">Toggle Navigation</span> <i class="fa fa-bars"></i>
			</button>
			<a href="main.do" class="navbar-brand"> <img src="./img/logo.png" alt="Post" style="width:183px;">
			</a>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-navbar-collapse">
				<ul class="nav navbar-nav main-navbar-nav">
					<li class="active"><a href="index.html" title="">HOME</a></li>
					<li class="dropdown">
						<a href="#" title="" class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false">소개 
						<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="sub_test.do" title="">학교소개</a></li>
							<li><a href="sub_test.do" title="">식단</a></li>
						</ul>
					</li>
					<li class="dropdown">
						<a href="#" title="" class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false">대학생활
						<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="sub_test.do" title="">공지게시판</a></li>
							<li><a href="sub_test.do" title="">자유게시판</a></li>
						</ul>
					</li>
					<li><a href="page.html" title="">e-class</a></li>
					<li class="dropdown">
						<a href="#" title="" class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false">학사인트라넷
						<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="sub_test.do" title="">성적확인</a></li>
							<li><a href="sub_test.do" title="">정보수정</a></li>
							<li><a href="sub_test.do" title="">성적입력강사용</a></li>
						</ul>
					</li>
					<li><a href="#" title="">수강신청</a></li>
					<li><a href="#" title="">MENU ITEM</a></li>
				</ul>
				
				<!-- 교직원!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
			</div>
			<!-- /.navbar-collapse -->
			<!-- END MAIN NAVIGATION -->
		</div>
	</nav>
</header>
