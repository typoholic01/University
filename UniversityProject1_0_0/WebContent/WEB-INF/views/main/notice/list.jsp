<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/> 

<h2 class="category-title">공지 게시판</h2>
    <!-- list -->
	<ul class="media-list">
    	<!-- 				게시물 불러오기				 -->
    	<c:forEach items="${bbsList }" var="bbs">
    	<li class="media">
            <div class="media-left">
                <a href="#" title="Post">
                    <img class="media-object" src="${pageContext.request.contextPath }/img/h1.jpeg" alt="Post">
                </a>
            </div>
            <div class="media-body">
                <h3 class="media-heading"><a href="./detail.do?seq=${bbs.noticeBbsSeq }&page=${pagination.currPage}" title="Post Title">${bbs.title }</a></h3>
                <p>${bbs.content }</p>
                <aside class="meta category-meta">
                    <div class="pull-left">
                        <div class="arc-comment"><a href="#" title="Comment"><i class="fa fa-comments"></i> 0 Comment</a></div>
                        <div class="arc-date">${bbs.wDate }</div>
                    </div>
                    <div class="pull-right">
                        <ul class="arc-share">
                            <li><a href="#" title="Post"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-linkedin"></i></a></li>
                            <li><a href="#" title="Post"><i class="fa fa-google-plus"></i></a></li>
                        </ul>
                    </div>
                </aside>                                
            </div>
        </li>
    	</c:forEach>
    </ul>
    
    <!-- 페이징 -->
    <div style="text-align: center;">
    <ul class="pagination pagination-lg">
    	<!-- 10페이지 이전 -->
    	<c:choose>
	  	<c:when test="${pagination.currPage <= pagination.pageLimit }">
	  		<li class="disabled"><a href="#"><i class="fa fa-angle-double-left"></i></a></li>	  	
	  	</c:when>
	  	<c:otherwise>
	  		<li><a href="./list.do?page=${pagination.currPage - pagination.pageLimit }"><i class="fa fa-angle-double-left"></i></a></li>	 	  	
	  	</c:otherwise>
	  </c:choose> 
	  <!-- 1페이지 이전 -->
	  <c:choose>
	  	<c:when test="${pagination.currPage == 1 }">
	  		<li class="disabled"><a href="#"><i class="fa fa-angle-left"></i></a></li>	  	
	  	</c:when>
	  	<c:otherwise>
	  		<li><a href="./list.do?page=${pagination.currPage - 1 }"><i class="fa fa-angle-left"></i></a></li>	 	  	
	  	</c:otherwise>
	  </c:choose>
	  <!-- 페이징 설정만큼 돌리기 -->
	  <c:forEach var="i" begin="${pagination.startPage }" end="${pagination.endPage }" step="1">
	  	<c:choose>
	  		<c:when test="${i == pagination.currPage }">
	 			<li class="active">
	 				<a href="./list.do?page=${i }">${i }</a>
	 			</li>	  		
	  		</c:when>
	  		<c:otherwise>
	  			<li><a href="./list.do?page=${i }">${i }</a></li>	  		
	  		</c:otherwise>
	  	</c:choose>
	  </c:forEach>
	  <!-- 1페이지 이후 -->
	  <c:choose>
	  	<c:when test="${pagination.currPage == pagination.finalEndPage }">
	  		<li class="disabled"><a href="#"><i class="fa fa-angle-right"></i></a></li>	  	
	  	</c:when>
	  	<c:otherwise>
	  		<li><a href="./list.do?page=${pagination.currPage + 1 }"><i class="fa fa-angle-right"></i></a></li>	 	  	
	  	</c:otherwise>
	  </c:choose>
	  <!-- 10페이지 이후 -->
	  <c:choose>
	  	<c:when test="${pagination.currPage + pagination.pageLimit > pagination.finalEndPage }">
	  		<li class="disabled"><a href="#"><i class="fa fa-angle-double-right"></i></a></li>	  	
	  	</c:when>
	  	<c:otherwise>
	  		<li><a href="./list.do?page=${pagination.currPage + pagination.pageLimit }"><i class="fa fa-angle-double-right"></i></a></li>	 	  	
	  	</c:otherwise>
	  </c:choose>
	</ul>
    </div>
    
    <!-- 버튼 목록 -->
	<div class="button-group">
		<div class="arc-comment">
			<a href="./write.do" title="Comment"><i class="fa fa-comments"></i> 글쓰기</a>
		</div>
	</div>