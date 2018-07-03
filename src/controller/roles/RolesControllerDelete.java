package controller.roles;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.PMF;
import controller.Security;
import model.entity.Role;
import model.entity.User;


@SuppressWarnings("serial")
public class RolesControllerDelete extends HttpServlet {

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Security.garantyAccess(req.getServletPath(), pm);
			Long id = Long.parseLong(req.getParameter("ID"));
			String query = "select from "+User.class.getName()+" where roleId =="+id+"";
			List<User> Users = (List<User>) pm.newQuery(query).execute();
			for (int i = 0; i < Users.size(); i++) {
				Users.get(i).setRole(null);
			}
			Role c=pm.getObjectById(Role.class,id);
			pm.deletePersistent(c);
			resp.sendRedirect("/role");
		} catch (Exception e) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/error.jsp");
			req.setAttribute("message", e.getMessage());
			rd.forward(req, resp);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}