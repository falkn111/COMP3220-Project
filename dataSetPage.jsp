<%@ page import= "yolo.Menu"%>
<%@ page import= "yolo.FileReader"%>
<%@ page import= "yolo.Servlet1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open Data Set</title>
</head>
<body>
<h2> Open Data Set</h2>

<% Servlet1 s = new Servlet1();
String search = request.getParameter("textfield");%>
<p> You searched for: <% out.println(search); %></p> 
<a href = "MainPage.jsp"> Return to main page </a>
</body>
</html>
