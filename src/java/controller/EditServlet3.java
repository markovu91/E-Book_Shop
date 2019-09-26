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
@WebServlet(name = "EditServlet3", urlPatterns = {"/EditServlet3"})
public class EditServlet3 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        int qty=Integer.parseInt(request.getParameter("Quantity ordered"));  
        String name =request.getParameter("Customer name");  
        String email=request.getParameter("Customer email");  
        int phone=Integer.parseInt(request.getParameter("Customer phone"));  
          
        Orders c=new Orders();  
        c.setId(id);  
        c.setQuantityOrdered(qty);  
        c.setCustomerName(name);  
        c.setCustomerEmail(email);  
        c.setCustomerPhone(phone);  
          
        int status=ProductDao.updateOrder(c);  
        if(status>0){  
            response.sendRedirect("ViewOrders");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }


}