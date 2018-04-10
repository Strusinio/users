package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ServletContext context = request.getSession().getServletContext();
		Model model = (Model) context.getAttribute("model");
		String login = request.getParameter("loginDoZmiany");
		model.zmienUprawnienie(login);
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
		rd.forward(request, response);

	}

}