package Exercice_03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet-details")
public class ServletDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String chienObjet = req.getParameter("chien");              // "Chien(id=1, nom=Olaf, race=Bulldog, naissance=2018-07-15)"
        chienObjet = chienObjet.substring(6, chienObjet.length() - 1); // "id=1, nom=Olaf, race=Bulldog, naissance=2018-07-15"
        String[] pairs = chienObjet.split(", ");                 // ["id=1", "nom=Olaf", "race=Bulldog", "naissance=2018-07-15"]
        for (String pair : pairs) {
            String[] cleValeur = pair.split("=");                // ["id","1"] ...
            req.setAttribute(cleValeur[0], cleValeur[1]);
        }
        req.getRequestDispatcher("/WEB-INF/DisplayDetails.jsp").forward(req, resp);
    }
}