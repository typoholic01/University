<%@ page contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8" />
<!-- 안에콘텐츠영역 -->
<tiles:insertAttribute name="sub_main" />
<!-- 푸터영역 -->
<tiles:insertAttribute name="sub_right_menu" />
