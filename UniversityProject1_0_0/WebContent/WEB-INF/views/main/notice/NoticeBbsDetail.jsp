<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- body -->
<section class="category-content col-sm-9">
	<div id="postlist">        
        <div class="panel">
                <div class="panel-heading">
                    <div class="text-center">
                        <div class="row">
                            <div class="col-sm-9">
                                <h3 class="pull-left">${bbs.title }</h3>
                            </div>
                            <div class="col-sm-3">
                                <h4 class="pull-right">
                                <small><em>${bbs.wDate }</em></small>
                                </h4>
                            </div>
                        </div>
                    </div>
                </div>
            <div class="panel-body">
                <a href="#" class="thumbnail" style="width: fit-content;height: fit-content;">
                    <img alt="Image" src="http://i.imgur.com/tAHVmXi.jpg">
                </a>
                <span>${bbs.content }</span>                
            </div>            
            <div class="panel-footer">
                <span class="label label-default">수정</span> <span class="label label-default">삭제</span>
            </div>
        </div>
    </div>
    <%@ include file="list.jsp" %>
</section>