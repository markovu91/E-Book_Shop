/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ProductDao;
import model.Orders;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marko
 */
@WebServlet(name = "EditOrderServlet", urlPatterns = {"/EditOrderServlet"})
public class EditOrderServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Order</h1>");  
        out.println("<p><a href='start'>Back to Select Menu</a></p>"); 
        String sid=request.getParameter("id");
        int qty=Integer.parseInt(request.getParameter("qty")); 
        int id=Integer.parseInt(sid);
        Orders c = ProductDao.getOrderByIdQty(id,qty);  
   
        out.print("<form action='EditServlet3' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+c.getId()+"'/></td></tr>");  
        out.print("<tr><td>Quantity ordered:</td><td><input type='text' name='Quantity ordered' value='"+c.getQuantityOrdered()+"'/></td></tr>");  
        out.print("<tr><td>Customer name:</td><td><input type='text' name='Customer name' value='"+c.getCustomerName()+"'/> </td></tr>");  
        out.print("<tr><td>Customer email:</td><td><input type='text' name='Customer email' value='"+c.getCustomerEmail()+"'/></td></tr>"); 
        out.print("<tr><td>Customer phone:</td><td><input type='text' name='Customer phone' value='"+c.getCustomerPhone()+"'/></td></tr>"); 
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }


  

}
