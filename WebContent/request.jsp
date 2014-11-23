<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<TITLE>request.jsp</TITLE>
</HEAD>
<BODY style="background-color: Lavender;">
<FORM  method="post" action="FingerTipMedicalAidServlet"><BR>
<table align="center">
<tr><td align="center"><input type="radio" name="medical" value="ambulance">Ambulance</td></tr>
<tr><td align="center"><input type="radio" name="medical" value="hospital">Hospital</td></tr>
<tr><td align="center"><input type="radio" name="medical" value="doctors">Doctors</td></tr>
<tr><td align="center"><input type="radio" name="medical" value="medstore">Medicine Store</td></tr>

<tr><td align="center">Lattitude<input type="text" name="lattitude" value="22.5817822"  ></td></tr>
<tr><td align="center">Longitude<input type="text" name="longitude" value="88.460697" ></td></tr>







<tr><td align="center"><INPUT type="submit" name="Submit" value="Fetch Details" ></td></tr>


</table>
</FORM>
</BODY>
</HTML> 