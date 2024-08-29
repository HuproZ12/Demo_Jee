package Exercice_01;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/ServletBrut")
public class ServletBrut extends HttpServlet {
 public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
  resp.setContentType("text/plain");

  PrintWriter out = resp.getWriter();
  out.println("Hello, World!");
 }
}