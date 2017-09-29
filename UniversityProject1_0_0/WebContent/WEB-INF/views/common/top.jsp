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
					<p>KH Information University</p>
				</div>
				<div class="col-sm-6">
					<ul class="list-inline pull-right">
					
					
					<c:if test="${not empty login}">
						<li>${login.user_name }님</li>
						<li><a href="logout.do">Logout</a></li>
					</c:if>
					<c:if test="${empty login}">
						<li><a href="login.do">Login</a></li>
					</c:if>
					
					
					
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
					<!-- 학생용 메뉴 -->
					<li><a href="page.html" title="">e-class</a></li>
					<li class="dropdown">
						<a href="intranet.do" title="학사인트라넷" class="dropdown-toggle" 
																data-toggle="dropdown" role="button"
																aria-haspopup="true" aria-expanded="false">
							학사인트라넷 <span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="assessment.do" title="">교수평가</a></li>
							<li><a href="student_grade.do" title="">성적확인</a></li>
							<li><a href="update_info.do" title="">정보수정</a></li>
						</ul>
					</li>
					<li><a href="#" title="">수강신청</a></li>
					<!-- 교직원용 메뉴 -->
					<li class="dropdown">
						<a href="#" title="" class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false">교직원
						<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="regi.do" title="">회원가입</a></li>
							<li><a href="sub_test.do" title="">강의등록</a></li>
							<li><a href="classList.do" title="">성적입력</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
			<!-- END MAIN NAVIGATION -->
		</div>
	</nav>
</header>
