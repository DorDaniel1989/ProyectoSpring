<!doctype html>
<%@ include file="taglibs.jsp" %>
<html lang="${springRequestContext.locale}">
	<head>
		<%@ page 
		language="java"
		contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"
		%>
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<meta charset="ISO-8859-1">
		<title><spring:message code="GuiaRapida" /></title>
		<!-- JQuery -->
		<script src='<spring:url value="/estatico/lib/jquery-1.8.1.js"/>'></script>
	
		<!-- Estilos de la aplicación -->
		<link href='<spring:url value="/estatico/css/style.css"/>' rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div id="a11ycontrols" class="invisible">
			<ul>
			  <li><a href="#skip">Skip to Content</a></li>
			</ul>
		</div>
		<div id="menu-wrapper">
			<tiles:insertAttribute name="menu-sup"/>
		</div>
		<div id="header-wrapper">
			<tiles:insertAttribute name="cabecera"/>
		</div>
		<div id="wrapper">
			<!-- end #header -->
			<div id="page">
				<div id="page-bgtop">
					<div id="page-bgbtm">
						<tiles:insertAttribute name="menu-izq"/>
						<!-- end #sidebar -->
						<div id="content">
							<div id="skipwrapper" class="invisible"><a id="skip">-</a></div>
							<tiles:insertAttribute name="cuerpo"/>
						</div>
						<!-- end #content -->
						<div style="clear: both;">&nbsp;</div>
					</div>
				</div>
			</div>
			<!-- end #page -->
		</div>
		<tiles:insertAttribute name="pie"/>
		
	</body>
</html>