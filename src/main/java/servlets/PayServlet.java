package servlets;

import domain.Item;
import services.ItemService;
import services.interfaces.IItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "PayServlet")
public class PayServlet extends HttpServlet {
    private IItemService itemService = new ItemService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Item> selectedItems = new LinkedList<>();
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().contains("item")){
                Item item = itemService.getItemById(Integer.parseInt(cookie.getValue()));
                //Getting id from cookie and searching from DB this item

                selectedItems.add(item);
            }
        }
        int sessionCount = (int) session.getAttribute("counter"); //counter of visit
        Date sessionCreation = new Date(session.getCreationTime()); //creation time of session
        Date sessionLast = new Date(session.getLastAccessedTime()); //last access time of session
        int total = totalPrice(selectedItems); //get total price of selected items

        request.setAttribute("selectedItems", selectedItems); //passing to jsp items
        request.setAttribute("count", sessionCount); //passing count
        request.setAttribute("creation", sessionCreation); //passing creation time
        request.setAttribute("lastAccess", sessionLast); //passing last access time
        request.setAttribute("total", total);

        request.getRequestDispatcher("confirm-info").forward(request, response);
    }

    //lambda
    private int totalPrice(List<Item> selectedItems){
        int sum = 0;
        Summary totalSuml;
        totalSuml = (total, price)->total + price;
        for(Item item : selectedItems){
            sum = totalSuml.summary(sum, item.getPrice());
        }
        return sum;
    }
    private interface Summary{
        int summary(int total, int price);
    }
}
