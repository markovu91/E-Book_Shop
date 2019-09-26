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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marko
 */
@WebServlet(urlPatterns = {"/EditServlet"})
public class EditServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Product</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Product p= ProductDao.getEmployeeById(id);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+p.getId()+"'/></td></tr>");  
        out.print("<tr><td>Author:</td><td><input type='text' name='author' value='"+p.getAuthor()+"'/></td></tr>");  
        out.print("<tr><td>Title:</td><td><input type='text' name='title' value='"+p.getTitle()+"'/> </td></tr>");  
        out.print("<tr><td>Price:</td><td><input type='text' name='price' value='"+p.getPrice()+"'/></td></tr>"); 
        out.print("<tr><td>Quantity:</td><td><input type='text' name='qty' value='"+p.getQty()+"'/></td></tr>"); 
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }


  

}
