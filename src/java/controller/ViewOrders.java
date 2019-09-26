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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marko
 */
@WebServlet(name = "ViewOrders", urlPatterns = {"/ViewOrders"})
public class ViewOrders extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        out.println("<style>body {background-color: powderblue;} th {background-color:#E0E0E0;} td {background-color:white; text-align: center;}\n" +" </style>");
        out.println("<h1>Order List</h1>");
        out.println("<p><a href='start'>Back to Select Menu</a></p>");  
        List<Orders> list=ProductDao.getAllOrders();  
     
        out.print("<table border='2' width='100%' style='border-color: #404040;' ");  
        out.print("<tr><th>Id</th><th>Quantity ordered</th><th>Customer name</th><th>Customer email</th><th>Customer phone</th><th>Edit</th><th>Delete</th></tr>");  
        for(Orders c:list){  
         out.print("<tr><td>"+c.getId()+"</td><td>"+c.getQuantityOrdered()+"</td><td>"+c.getCustomerName()+"</td> <td>"+c.getCustomerEmail()+"</td><td>"+c.getCustomerPhone()+"</td><td><a href='EditOrderServlet?id="+c.getId()+"&qty="+c.getQuantityOrdered()+"'>edit</a></td>  <td><a href='DeleteOrderServlet?id="+c.getId()+"&qty="+c.getQuantityOrdered()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close(); 
        
    }


}