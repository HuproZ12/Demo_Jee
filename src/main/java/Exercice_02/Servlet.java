package Exercice_02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/servlet")
public class Servlet extends HttpServlet {

    private List<Chat> chats = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("chats", chats);
        req.getRequestDispatcher("/WEB-INF/JSP.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nom = req.getParameter("nom");
        String race = req.getParameter("race");
        String repasFavoris = req.getParameter("repasFavoris");
        String naissance = req.getParameter("naissance");

        Chat chat = new Chat(nom, race, repasFavoris, naissance);
        chats.add(chat);

        resp.sendRedirect(req.getServletContext().getContextPath() + "/servlet");
    }
}