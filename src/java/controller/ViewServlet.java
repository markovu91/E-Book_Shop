package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.ProductDao;
import model.Product;
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
@WebServlet(urlPatterns = {"/ViewServlet"})
public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        out.println("<style>body {background-color: powderblue;} th {background-color:#E0E0E0;} td {background-color:white; text-align: center;}\n" +" </style>");
  
        out.println("<p><a href='start'>Back to Select Menu</a></p>");
        out.println("<p><a href='ViewOrders'>View Orders</a></p>");
        out.println("<h1>Product List</h1>");  
          
        List<Product> list=ProductDao.getAllEmployees();  
     
        out.print("<table border='2' width='100%' style='border-color: #404040;'");  
        out.print("<tr><th>Id</th><th>Author</th><th>Title</th><th>Price</th><th>Quantity</th>  <th>Edit</th><th>Delete</th></tr>");  
        for(Product p:list){  
         out.print("<tr><td>"+p.getId()+"</td><td>"+p.getAuthor()+"</td><td>"+p.getTitle()+"</td> <td>"+p.getPrice()+"</td><td>"+p.getQty()+"</td><td><a href='EditServlet?id="+p.getId()+"'>edit</a></td>  <td><a href='DeleteServlet?id="+p.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>"); 
        out.println("<a href='addProduct.html'>Add New Product</a>"); 
          
        out.close(); 
        
        
        
    }


}
