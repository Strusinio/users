package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/podstawowy")
public class Podstawowy extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ServletContext context = request.getSession().getServletContext();

		Model model = (Model) context.getAttribute("model");

		if (request.getParameter("wyloguj") != null) {
			wyloguj(request, response, model);
		} else if (request.getParameter("premium") != null) {
			premium(request, response, model);
		} else if (request.getParameter("admin") != null) {
			admin(request, response, model);
		}

	}

	private void admin(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		if (model.getAkutalnieZalogowany().getUprawnienie() == Uprawnienie.ADMIN) {
			request.getSession().setAttribute("uzytkownicy", model.kontaDoEdycji());
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("error", "Brak dostepu admin");
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}

	private void premium(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		if (model.getAkutalnieZalogowany().getUprawnienie().dostepDoPremium()) {
			RequestDispatcher rd = request.getRequestDispatcher("premium.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("error", "Brak dostepu premium");
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}

	private void wyloguj(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		model.setAkutalnieZalogowany(null);
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
}