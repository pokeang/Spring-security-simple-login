<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title><tiles:getAsString name="title"/></title>
		<!-- Loaded style libraries -->
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/template/fontend/css/style.css"/>">
	</head>
<body>
	<tiles:insertAttribute name="header"/>
	<div class="container">
		<tiles:insertAttribute name="content"/>
	</div>
	<tiles:insertAttribute name="footer"/>
	<!-- Loaded JS libraries -->
	<script type="text/javascript" src="<c:url value="/resources/template/fontend/js/app.js"/>"></script>
</body>
</html>