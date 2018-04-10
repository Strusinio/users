package servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter implements Filter {

    private List<String> withoutLogin = Arrays.asList("/login", "/rejestracja", "/error");
    private List<String> withLogin = Arrays.asList("/login", "/rejestracja");

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        int index = request.getRequestURI().indexOf(".");
        String requestPath;
        if (index > 0) {
            requestPath = request.getRequestURI().substring(0, request.getRequestURI().indexOf("."));
        } else {
            requestPath = request.getRequestURI();
        }

        boolean loggedIn;
        if (session != null) {
            Model model = (Model) session.getServletContext().getAttribute("model");
            loggedIn = model != null && model.getAkutalnieZalogowany() != null;
        } else {
            loggedIn = false;
        }

        if (loggedIn) {
            if (withLogin(requestPath, request)) {
                response.sendRedirect("podstawowy.jsp");
            } else {
                chain.doFilter(request, response);
            }
        } else if (withoutLogin(requestPath, request)) {
            chain.doFilter(request, response);
        } else {
            System.out.println(requestPath);
            response.sendRedirect("login.jsp");
        }
    }

    private boolean withoutLogin(String requestPath, HttpServletRequest request) {
        for (String uri : withoutLogin) {
            String toCompare = request.getContextPath() + uri;
            if (toCompare.equals(requestPath)) {
                return true;
            }
        }
        return false;
    }

    private boolean withLogin(String requestPath, HttpServletRequest request) {
        for (String uri : withLogin) {
            String toCompare = request.getContextPath() + uri;
            if (toCompare.equals(requestPath)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}