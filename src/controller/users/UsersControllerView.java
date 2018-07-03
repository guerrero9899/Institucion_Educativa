package controller.users;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import controller.PMF;
import controller.Security;
import model.entity.User;

@SuppressWarnings("serial")
public class UsersControllerView extends HttpServlet {
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Security.garantyAccess(req.getServletPath(), pm);
			String query = " select from " + User.class.getName() + " where ID == '" + Long.parseLong("+"+req.getParameter("ID"))+"'";
			List<User> User = (List<User>)pm.newQuery(query).execute();
			User user = User.get(0);
			req.setAttribute("user",user);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/view.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
			rd.forward(req, resp);
		}
	}
}