<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/> 

<section class="category-content col-sm-9">
    <h2 class="category-title">CATEGORY NAME</h2>
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
                <h3 class="media-heading"><a href="#" title="Post Title">${bbs.title }</a></h3>
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
	<div class="button-group">
		<div class="arc-comment">
			<a href="./write.do" title="Comment"><i class="fa fa-comments"></i> 글쓰기</a>
		</div>
	</div>
</section>