package controller.access;

import java.io.IOException;
import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.*;
import model.entity.Access;

@SuppressWarnings("serial")
public class AccessControllerAdd extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Security.garantyAccess(req.getServletPath(), pm);
			String rol = req.getParameter("roleId");
			String resource = req.getParameter("resourceId");
			if (rol == null || resource == null) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Views/Access/add.jsp");
				rd.forward(req, resp);
			} else {
				Access a = new Access(Long.parseLong(rol),Long.parseLong( resource));
				pm.makePersistent(a);
				resp.sendRedirect("/access");
			}
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