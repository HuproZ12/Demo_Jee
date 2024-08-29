package Exercice_01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/ServletJSP")
public class ServletJSP extends HttpServlet {

    private String prenom = "Hugo";
    private String nom = "DUTILLEEUX";

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("prenom", prenom);
        req.setAttribute("nom", nom);
        req.getRequestDispatcher("/WEB-INF/ServletJSP.jsp").forward(req,resp);
    }
}