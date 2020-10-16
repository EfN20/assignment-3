package servlets;

import domain.User;
import services.UserService;
import services.interfaces.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    private IUserService userServ = new UserService();

    //FOR LOGIN ALREADY EXIST USER
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("usernameLog");
        String password = request.getParameter("passwordLog");
        if(username != null && password != null){
            User signedUser = new User(username, password);
            userServ.findUserByLogin(signedUser);
            HttpSession session = request.getSession();
            session.setAttribute("signedUser", signedUser);
            request.getRequestDispatcher("items").forward(request, response);
        }
        else{
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            pw.print("<h1>Invalid username or password</h1>");
            pw.close();
        }
    }

    //FOR REGISTER NEW USERS
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username != null && password != null){
            User signedUser = new User(username, password);
            userServ.add(signedUser);
            HttpSession session = request.getSession();
            session.setAttribute("signedUser", signedUser);
            request.getRequestDispatcher("items").forward(request, response);
        }
        else{
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            pw.print("<h1>There should not be empty field</h1>");
            pw.close();
        }
    }
}
