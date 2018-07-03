package controller.resources;

import java.io.IOException;
import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.PMF;
import controller.Security;
import model.entity.Resource;

@SuppressWarnings("serial")
public class ResourceControllerEdit extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Security.garantyAccess(req.getServletPath(), pm);
			Resource c = pm.getObjectById(Resource.class, Long.parseLong(req.getParameter("ID")));
			String name = req.getParameter("name");
			if (name == null) {
				req.setAttribute("Resource", c);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Views/Resources/edit.jsp");
				rd.forward(req, resp);
			} else {
				c.setName(name);
				c.setStatus(Boolean.parseBoolean(req.getParameter("stat")));
				c.setDate(new Date());
				resp.sendRedirect("/resources");
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