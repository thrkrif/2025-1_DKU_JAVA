package kr.ac.dankook.ace.springbootservlet;

import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// using initParams & @WebInitParam annotations to set init parameter
@WebServlet(name = "helloServlet", urlPatterns = "/servlet/hello", initParams= {@WebInitParam(name="id", value="abc"), @WebInitParam(name="passwd", value="12345")})
public class HelloServlet extends HttpServlet {
    @Override
    public void init() {
        // load init-param using ServletConfig().getInitParamater("")
        String id = getInitParameter("id");
        String passwd = getInitParameter("passwd");
        System.out.println("HelloServlet init() id=" + id + " passwd=" + passwd);
    }

    // localhost:8080/servlet/hello?name=park&age=20
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        Person person = new Person(username, age);
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("HelloServlet hello " + person);
    }

    @Override
    public void destroy() {
        System.out.println("destroy()");
    }
}
