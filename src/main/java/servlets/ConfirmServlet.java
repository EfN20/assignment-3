package servlets;

import domain.Item;
import services.ItemService;
import services.interfaces.IItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Set;

@WebServlet(name = "ConfirmServlet")
public class ConfirmServlet extends HttpServlet {
    private IItemService itemService = new ItemService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //counter increase
        HttpSession session = request.getSession();
        int counter = (int) session.getAttribute("counter");
        counter++;
        session.setAttribute("counter", counter);
        //

        //Refresh cookies duration to 60 again
        DeleteCookies(request, response);
        //
        Set<Item> items = itemService.getAllItems();
        request.setAttribute("items", items);
        request.getRequestDispatcher("items").forward(request, response);
    }

    protected void DeleteCookies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().contains("item")){
                cookie.setValue("");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }
}
