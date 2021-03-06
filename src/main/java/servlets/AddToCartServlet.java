package servlets;

import domain.Item;
import services.ItemService;
import services.interfaces.IItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Set;

@WebServlet(name = "AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    private IItemService itemService = new ItemService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //counter increase
        HttpSession session = request.getSession();
        int counter = (int) session.getAttribute("counter");
        counter++;
        session.setAttribute("counter", counter);
        //

        int id = Integer.parseInt(request.getParameter("itemId"));
        Item item = itemService.getItemById(id);
        Cookie cookie = new Cookie("item"+id, Integer.toString(id));
        cookie.setMaxAge(60);
        //Refresh cookies duration to 60 again
        refreshCookies(request, response);
        //
        response.addCookie(cookie);
        Set<Item> items = itemService.getAllItems();
        request.setAttribute("items", items);
        request.getRequestDispatcher("items").forward(request, response);
    }

    protected void refreshCookies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().contains("item")){
                cookie.setMaxAge(60);
                response.addCookie(cookie);
            }
        }
    }
}
