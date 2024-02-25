package tech.maviprogressus.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/helloWorld")
public class MyServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Servlet ON!");
        response.getWriter().append("<html>\n" +
                "<body>\n" +
                "<h2>RESPONSE!</h2>\n" +
                "</body>\n" +
                "</html>");
    }

}