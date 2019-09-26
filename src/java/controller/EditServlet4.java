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
@WebServlet(name = "EditServlet4", urlPatterns = {"/EditServlet4"})
public class EditServlet4 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name =request.getParameter("Customer name");  
        int phone =Integer.parseInt(request.getParameter("Customer phone"));  
        String email=request.getParameter("Customer email");  
   
          
        Customers cu=new Customers();  
        cu.setId(id);  
        cu.setCustomerName(name);  
        cu.setCustomerPhone(phone);  
        cu.setCustomerEmail(email);  
 
          
        int status=ProductDao.updateCust(cu);  
        if(status>0){  
            response.sendRedirect("CustomerList");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }


}
