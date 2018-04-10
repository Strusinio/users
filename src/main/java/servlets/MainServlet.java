package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ServletContext context = request.getSession().getServletContext();
		Model model = (Model) context.getAttribute("model");
		if (model == null) {
			model = new Model();
			context.setAttribute("model", model);
		}
		if (model.getAkutalnieZalogowany() != null) {
			System.out.println("zalogowany");
			response.sendRedirect("podstawowy.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		ServletContext context = request.getSession().getServletContext();
		Model model = (Model) context.getAttribute("model");
		if (model == null) {
			model = new Model();
			context.setAttribute("model", model);
		}
		if (request.getParameter("logowanie") != null) {
			loguj(request, response, model);
		} else if (request.getParameter("rejestracja") != null) {
			rejestruj(request, response);
		}

	}

	private void loguj(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		Konto konto = new Konto(request.getParameter("login"), request.getParameter("haslo"));
		if (!walidujLogin(konto, model)) {
			request.setAttribute("error", "Bledny login lub haslo");
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		} else {
			model.setAkutalnieZalogowany(model.pobierzPoNazwie(konto.getLogin()));
			RequestDispatcher rd = request.getRequestDispatcher("podstawowy.jsp");
			rd.forward(request, response);
		}
	}

	private void rejestruj(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("rejestracja.jsp");
		rd.forward(request, response);
	}

	private boolean walidujLogin(Konto konto, Model model) {
		Konto kontoZModelu = model.pobierzPoNazwie(konto.getLogin());
		return konto.equals(kontoZModelu);
	}
}