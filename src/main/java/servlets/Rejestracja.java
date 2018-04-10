package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rejestracja")
public class Rejestracja extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ServletContext context = request.getSession().getServletContext();
		Model model = (Model) context.getAttribute("model");
		System.out.println("odpalone");
		if (model.getAkutalnieZalogowany() != null) {
			System.out.println("zalogowany");
			response.sendRedirect("podstawowy.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ServletContext context = request.getSession().getServletContext();
		Model model = (Model) context.getAttribute("model");
		Konto konto = new Konto(request.getParameter("login"), request.getParameter("haslo"));
		String potwierdzenie = request.getParameter("potwierdz");
		if (konto.getLogin().isEmpty() || konto.getHaslo().isEmpty()) {
			request.setAttribute("error", "uzupelnij dane");
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}

		else if (walidujLogin(konto, model)) {
			request.setAttribute("error", "Uzytkownik o podanym loginie jest juz zarejestrowany");
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		} else if (!potwierdzenie.equals(konto.getHaslo())) {
			request.setAttribute("error", "Hasla musza byc takie same");
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);

		} else {
			model.dodajKonto(konto);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

	private boolean walidujLogin(Konto konto, Model model) {
		Konto kontoZModelu = model.pobierzPoNazwie(konto.getLogin());
		return kontoZModelu != null;
	}
}