package controller.roles;

import java.io.IOException;
import java.util.*;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.PMF;
import controller.Security;
import model.entity.Role;


@SuppressWarnings("serial")
public class RolesControllerIndex extends HttpServlet {

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Security.garantyAccess(req.getServletPath(), pm);
			Query query = pm.newQuery(Role.class);
			query.setRange(0, 20);
			List<Role> roles = (List<Role>) query.execute();
			req.setAttribute("showFull", roles);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Views/Roles/viewFull.jsp");
			rd.forward(req, resp);
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