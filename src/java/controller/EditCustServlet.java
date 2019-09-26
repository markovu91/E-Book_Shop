/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customers;
import model.Orders;
import model.ProductDao;

/**
 *
 * @author marko
 */
@WebServlet(name = "EditCustServlet", urlPatterns = {"/EditCustServlet"})
public class EditCustServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Customer</h1>");  
        out.println("<p><a href='start'>Back to Select Menu</a></p>"); 
        String sid=request.getParameter("id");
        String name=request.getParameter("name"); 
        int id=Integer.parseInt(sid);
        Customers cu = ProductDao.getCustomerByIdQty(id,name);  
   
        out.print("<form action='EditServlet4' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+cu.getId()+"'/></td></tr>");  
        out.print("<tr><td>Customer name:</td><td><input type='text' name='Customer name' value='"+cu.getCustomerName()+"'/></td></tr>");  
        out.print("<tr><td>Customer phone:</td><td><input type='text' name='Customer phone' value='"+cu.getCustomerPhone()+"'/> </td></tr>");  
        out.print("<tr><td>Customer email:</td><td><input type='text' name='Customer email' value='"+cu.getCustomerEmail()+"'/></td></tr>"); 
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }
}
