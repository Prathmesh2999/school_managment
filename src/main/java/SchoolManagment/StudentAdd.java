package SchoolManagment;

import java.io.IOException;

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
@WebServlet("/three")
public class StudentAdd extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String id = req.getParameter("id");
	String name = req.getParameter("name");
	String age = req.getParameter("age");
	String phon = req.getParameter("phonenum");
	
	int id1 = Integer.parseInt(id);
	int age1 = Integer.parseInt(age);
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("prathu");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Student s = new Student();
	s.setId(id1);
	s.setAge(age1);
	s.setName(name);
	s.setPhono(phon);
	
	et.begin();
	em.persist(s);
	et.commit();
	
	System.out.println("DATA ADDED....");
	
	RequestDispatcher rd = req.getRequestDispatcher("Student.html");
	rd.forward(req, resp);
}
}
