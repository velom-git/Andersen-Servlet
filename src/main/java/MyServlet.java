import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyServlet extends HttpServlet {
     Check check = new Check();

    public Check getCheck() {
        return check;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User.ROLE role = check.getRoleByLoginPassword(login, password);
        moveToMenu(req, resp, role);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User.ROLE role = User.ROLE.USER;
        session.setAttribute("login", login);
        session.setAttribute("password", password);
        session.setAttribute("role", role);
        User user = new User(login, password, role);
        check.add(user);
        moveToMenu(req, resp, role);
    }

    private void moveToMenu(final HttpServletRequest req,
                            final HttpServletResponse res,
                            final User.ROLE role)
            throws ServletException, IOException {


        if (role.equals(User.ROLE.ADMIN)) {
            req.getRequestDispatcher("/WEB-INF/view/admin.jsp").forward(req, res);
        } else if (role.equals(User.ROLE.USER)) {
            req.getRequestDispatcher("/WEB-INF/view/user.jsp").forward(req, res);
        } else {
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);
        }
    }
}
