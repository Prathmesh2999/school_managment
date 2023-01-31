package SchoolManagment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/update")
public class UpdateStudent extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String id = req.getParameter("id");
	String name = req.getParameter("name");
	String age = req.getParameter("age");
	String phone = req.getParameter("phonenum");
	
	int id1 = Integer.parseInt(id);
	int age1 = Integer.parseInt(age);
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("prathu");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Student s = new Student();
	s.setId(id1);
	s.setName(name);
	s.setAge(age1);
	s.setPhono(phone);
	
	et.begin();
	em.merge(s);
	et.commit();
	
	resp.setContentType("text/html");
	PrintWriter pw = resp.getWriter();
	pw.write("UPDATED SUCCESSFULLY....");
	
	RequestDispatcher rd = req.getRequestDispatcher("Student.html");
	rd.include(req, resp);
	
}
}
