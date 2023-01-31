<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="SchoolManagment.Teacher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String id = request.getParameter("id");
int id1 = Integer.parseInt(id);

EntityManagerFactory  emf = Persistence.createEntityManagerFactory("prathu");
EntityManager em = emf.createEntityManager();

Teacher t = em.find(Teacher.class, id1);
%>
<form action="update2" method = "post">
	Id: <input type = "text" value="<%= t.getId() %>" name = "id">
	Name: <input type ="text" value="<%= t.getName() %>" name = "name">
	Subject: <input type = "text" value="<%= t.getSubject()%>" name = "subject">
	Salary:<input type = "text" value="<%= t.getSalary() %>" name = "salary">
	<input type = "submit">

</form>

</body>
</html>