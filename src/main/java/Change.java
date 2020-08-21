import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Change extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        HttpSession httpSession = req.getSession();
        String log = (String) httpSession.getAttribute("login");
        MyServlet myServlet = new MyServlet();
        Check check = myServlet.getCheck();
        check.setRoleAdmin(login);
        check.setRoleAdmin(log);
        req.getRequestDispatcher("/WEB-INF/view/guest.jsp").forward(req, resp);
    }
}
