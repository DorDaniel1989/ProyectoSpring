<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">

	

	<head>
	
	<meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
	<title>Infraestucturas Viarias - Expedientes Diar</title>
	<meta name="description" content="Web de Catas y Sondeos" />
	<meta name="keywords" content="Actas, Documentos" />
	<meta name="Author" content="IZFE" />
	<meta http-equiv="imagetoolbar" content="no" />
	<META HTTP-EQUIV="Cache-Control" content="no-cache"/>
  	<META HTTP-EQUIV="Pragma" CONTENT="no-cache"/>
	<META HTTP-EQUIV="Expires" CONTENT="-1"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE10" />
    

		<!-- JQuery -->
		<script src='<spring:url value="/estatico/lib/jquery-1.8.1.js"/>'></script>
		<title>Guía rápidaa</title>
	
	</head>
	<body>
		<form:form modelAttribute="cuenta">   
			<form:input path="nombre" id="nombre"/>Nombre<br/>
			<button id="aceptar" style="width: 75px;" type="submit">Aceptar</button>
		</form:form> 
		
		Encoding: <c:out value="${encoding}" />  <br/>
		cod: <c:out value="${cod}" /> <br/>
		codEscape: <c:out value="${codEscape}" /> <br/>
		codEncode: <c:out value="${codEncode}" /> <br/>

 	<script type="text/javascript" > 
		$(document).ready(function(){
	    $("#aceptar").click(function(event){
		    	event.preventDefault();
			    var expediente= $("#nombre").val();
			    var expedienteEscape= escape(expediente);
			    var expedienteEncode= encodeURIComponent(expediente);
			    var elAction ="/WAS/HACI/WFIGuiaRapidaSpringMVCWEB/ajax/generar";
	
	               var href = elAction + "?cod="+expediente+"&codEscape="+expedienteEscape+"&codEncode="+expedienteEncode;
	
				$.get(href, {},
					function(data) {
						console.log(data);
			  		}
				);		
		    });
		});	
	</script>
</body>
</html>