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
import model.ProductDao;

/**
 *
 * @author marko
 */
@WebServlet(name = "DeleteOrderServlet", urlPatterns = {"/DeleteOrderServlet"})
public class DeleteOrderServlet extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sid=request.getParameter("id"); 
        int qty=Integer.parseInt(request.getParameter("qty")); 
        int id=Integer.parseInt(sid);  
        ProductDao.deleteOrder(id, qty);  
        response.sendRedirect("ViewOrders");  
    }


}
