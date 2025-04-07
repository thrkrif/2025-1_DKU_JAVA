package kr.ac.dankook.ace.springbootservlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "newFormServlet", urlPatterns = "/servlet/new-form")
public class NewFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(
            "<form action=\"/servlet/addperson\" method=\"post\"> <br/>" +
                " user name: <input type=\"text\" name=\"name\" /> <br/>" +
                " user age: <input type=\"text\" name=\"age\" /> <br/>" +
                " <button type=\"submit\">Submit</button>"
        );
    }
}
