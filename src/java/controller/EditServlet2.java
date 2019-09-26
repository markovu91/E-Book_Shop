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
@WebServlet(urlPatterns = {"/EditServlet2"})
public class EditServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String author=request.getParameter("author");  
        String title=request.getParameter("title");  
        float price=Float.valueOf(request.getParameter("price"));  
        int qty=Integer.valueOf(request.getParameter("qty"));  
          
        Product p=new Product();  
        p.setId(id);  
        p.setTitle(title);  
        p.setAuthor(author);  
        p.setPrice(price);  
        p.setQty(qty);  
          
        int status=ProductDao.update(p);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }


}
