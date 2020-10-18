package servlets;

import domain.Item;
import services.ItemService;
import services.interfaces.IItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

@WebServlet(name = "CategoryItemServlet")
public class CategoryItemServlet extends HttpServlet {
    private IItemService itemService = new ItemService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("cate");
        HttpSession session = request.getSession();
        if(category.equals("all")){
            //taking from DB items and sending to jsp
            Set<Item> items = itemService.getAllItems();
            request.setAttribute("items", items);
            //
        }
        else{
            //taking from DB items and sending to jsp
            Queue<Item> items = itemService.getItemsByCategory(category);
            request.setAttribute("items", items);
            //
        }

        //taking from DB categories and sending to jsp
        Map<Integer, String> ct = itemService.getCategoriesOfItems();
        request.setAttribute("categories", ct);
        //
        request.getRequestDispatcher("items").forward(request, response);
    }
}
