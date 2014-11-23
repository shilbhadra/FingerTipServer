<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<TITLE>response.jsp</TITLE>
</HEAD>
<BODY>
<%  
String address = request.getAttribute("address").toString(); 
%>

<table id="updateTable" align="center" height="100" width="200">
		<tr><td align="center"><% out.println("<message>" + address + "</message>");%></td></tr>
       <tr><td><input type="button" value="Back" onclick="javascript:history.go(-1)"></td></tr>
</table> 
<BR>
<BR>
</BODY>
</HTML> 