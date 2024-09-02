package Exercice_03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import java.io.IOException;

@WebServlet("/servlet-form")
public class ServletForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/DisplayForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String race = req.getParameter("race");
        String naissance = req.getParameter("naissance");

        Session session = Util.getSession();
        session.beginTransaction();
        Chien chien = new Chien.ChienBuilder().nom(nom).race(race).naissance(naissance).build();
        session.save(chien);
        session.getTransaction().commit();
        Util.closeSession(session);

        resp.sendRedirect(req.getServletContext().getContextPath() + "/servlet-display");
    }
}