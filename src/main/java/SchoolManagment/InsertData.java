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

@WebServlet("/one")
public class InsertData extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String name = req.getParameter("name");
	String age = req.getParameter("age");
	String phonno = req.getParameter("phonenum");
	String email = req.getParameter("email");
	String pass = req.getParameter("password");
	
	int age1 = Integer.parseInt(age);
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("prathu");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Principal p = new Principal();
	
	p.setName(name);
	p.setAge(age1);
	p.setPhono(phonno);
	p.setEmail(email);
	p.setPassword(pass);
	
	et.begin();
	em.persist(p);
	et.commit();
	
	System.out.println("DATA SAVED.....");
	RequestDispatcher rd = req.getRequestDispatcher("Log.html");
	rd.forward(req, resp);
}
}
