package kr.ac.dankook.ace.springbootservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "addPersonServlet", urlPatterns = "/servlet/addperson")
public class AddPersonServlet extends HttpServlet {
    List<Person> people = null;

    public AddPersonServlet() {
        people = new ArrayList<>();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        Person person = new Person(username, age);
        people.add(person);

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("<table>");
        for (Person p: people) {
            response.getWriter().write(" <tr>");
            response.getWriter().write(" <td>" + p.getName() + "</td>");
            response.getWriter().write(" <td>" + p.getAge() + "</td>");
            response.getWriter().write(" </tr>");
        }
        response.getWriter().write("</table>");
        
        /*response.getWriter().write(
            " Success to add new person<br/>" +
            " <li>username=" + person.getName()+"</li>" +
            " <li>age=" + person.getAge()+"</li>"
        );*/

        response.getWriter().write(
            "<hr><a href = \"/servlet/new-form\">Click here to add a new person</a>"
        );
    }
}
