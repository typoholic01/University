<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>

<jsp:useBean id="nows" class="java.util.Date"/>

<div style="width: 100%; height: 53px; border-bottom: 1px solid #5e5e5e; ">
	<div style="width: 100%; height: 100%; clear: both; display:inline-block; ">
	
		<div id="_title_image" style="width: 30%; float: left; display: inline;">
			<img src="image/bbslogo1.jpg" style="height: 53px">
		</div>
		<div id="_title_today" style="width: 70%; float: left; text-align: right;">
			<div style="position: relative; top: 27px">
				
				<c:if test="${login.id ne '' }">
					<a href="#none" onclick="url_logout();" title="로그아웃">[로그아웃]</a>&nbsp;&nbsp;&nbsp;
				</c:if>				
				
				<c:if test="${login.name ne '' }">
					[${login.name }]				
				</c:if>
			
				<fmt:formatDate var="now" value="${nows }" pattern="yyyy/MM/dd"/>${now }				
			
			</div>		
		</div>		
	</div>
</div> 

<script type="text/javascript">
function url_logout() { /* 로그아웃 */ 
	alert('goodby');
	self.location.href = "logout.do"; 
}
</script>




