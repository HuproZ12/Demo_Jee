package Exercice_03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet-display")
public class ServletDisplay extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = Util.getSession();
        List<Chien> chiens = session.createQuery("from Chien ").list();
        Util.closeSession(session);

        req.setAttribute("chiens", chiens);
        req.getRequestDispatcher("/WEB-INF/Display.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("chien"));

        Session session = Util.getSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM Chien WHERE id = :id").setParameter("id", id).executeUpdate();
        session.getTransaction().commit();
        Util.closeSession(session);

        resp.sendRedirect(req.getServletContext().getContextPath() + "/servlet-display");
    }
}