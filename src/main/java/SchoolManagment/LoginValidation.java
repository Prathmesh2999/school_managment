package SchoolManagment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/two")
public class LoginValidation extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String email = req.getParameter("email");
	String pass = req.getParameter("password");
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("prathu");
	EntityManager em = emf.createEntityManager();
	
	Query q = em.createQuery("select a from Principal a where a.email=?1 and a.password =?2");
	q.setParameter(1, email);
	q.setParameter(2, pass);
	
	List<Principal> princi = q.getResultList();
	
	if (princi.size()>0) {
		RequestDispatcher rd = req.getRequestDispatcher("teastu.html");
		rd.forward(req, resp);
		
	} else {
		PrintWriter pw = resp.getWriter();
		pw.write("Invalid Credential....");
		RequestDispatcher rd1 = req.getRequestDispatcher("Login.html");
		rd1.include(req, resp);
		resp.setContentType("text/html");
	}
}
}
