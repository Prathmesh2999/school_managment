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

@WebServlet("/update2")
public class UpdateTeacher extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String id = req.getParameter("id");
	String name = req.getParameter("name");
	String sub = req.getParameter("subject");
	String sal = req.getParameter("salary");
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("prathu");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Teacher t = new Teacher();
	t.setId(Integer.parseInt(id));
	t.setName(name);
	t.setSubject(sub);
	t.setSalary(Integer.parseInt(sal));
	
	et.begin();
	em.merge(t);
	et.commit();
	
	resp.setContentType("text/html");
	PrintWriter pw = resp.getWriter();
	pw.write("UPDATED SUCCESSFULLY....");
	
	RequestDispatcher rd = req.getRequestDispatcher("Teacher.html");
	rd.include(req, resp);
	
	
}
}
