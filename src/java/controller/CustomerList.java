/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ProductDao;
import model.Customers;
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
@WebServlet(name = "CustomerList", urlPatterns = {"/CustomerList"})
public class CustomerList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        out.println("<style>body {background-color: powderblue;} th {background-color:#E0E0E0;} td {background-color:white; text-align: center;}\n" +" </style>");
        out.println("<h1>Customer List</h1>");  
        out.println("<p><a href='start'>Back to Select Menu</a></p>");  
        List<Customers> list=ProductDao.getAllCustomers();  
     
        out.print("<table border='1' width='100%' style='border-color: #404040;'");  
        out.print("<tr><th>Id</th><th>Customer name</th><th>Customer phone</th><th>Customer email</th><th>Edit</th><th>Delete</th></tr>");  
        for(Customers cu:list){  
         out.print("<tr><td>"+cu.getId()+"</td><td>"+cu.getCustomerName()+"</td><td>"+cu.getCustomerPhone()+"</td> <td>"+cu.getCustomerEmail()+"</td><td><a href='EditCustServlet?id="+cu.getId()+"&name="+cu.getCustomerName()+"'>edit</a></td>  <td><a href='DeleteCustServlet?id="+cu.getId()+"&name="+cu.getCustomerName()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close(); 
        
    }


}
