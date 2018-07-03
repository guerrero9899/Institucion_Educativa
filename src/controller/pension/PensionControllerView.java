package controller.pension;

import java.io.IOException;
import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import controller.PMF;
import controller.Security;
import model.entity.Pension;

@SuppressWarnings("serial")
public class PensionControllerView extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Security.garantyAccess(req.getServletPath(), pm);
			String query = " select from " + Pension.class.getName() + " where ID == "
					+ Long.parseLong(req.getParameter("ID")) + "";
			System.out.println(query);
			Pension pension = (Pension) pm.newQuery(query).execute();
			req.setAttribute("pension", pension);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Views/Pension/view.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/error.jsp");
			req.setAttribute("message", e.getMessage());
			rd.forward(req, resp);
		}
	}
}