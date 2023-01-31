<%@page import="SchoolManagment.Student"%>
<%@page import="SchoolManagment.Teacher"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
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

Student s = em.find(Student.class, id1);
%>
<form action = "update" method ="post">
	Id: <input type = "text" value="<%= s.getId() %>" name = "id">
	Name: <input type ="text" value="<%= s.getName() %>" name = "name">
	Age: <input type = "text" value="<%= s.getAge() %>" name = "age">
	Phone NO.:<input type = "text" value="<%= s.getPhono() %>" name = "phonenum">
	<input type = "submit">
</form>

</body>
</html>