package Exercice_01;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/ServletHTML")
public class ServletHTML extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/HTML");
        PrintWriter out = resp.getWriter();
        out.println("<html><body><h1>test</h1></body></html>");
    }
}